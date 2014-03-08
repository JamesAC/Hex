/*
 * Copyright (C) 2014 JamesAC (james@jamesac.co.uk)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package com.jamesac.Temp.Object;

import com.jamesac.Temp.Object.Component.HexComponent;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by James on 02/02/14. Based on code from http://entity-systems-wiki.t-machine.org/rdbms-beta
 */
public class HexObjectManager {

  boolean                                               frozen;
  List<UUID>                                            allObjects;
  HashMap<UUID, String>                                 objectNames;
  HashMap<Class, HashMap<UUID, ? extends HexComponent>> componentStores;

  public HexObjectManager()
  {
    frozen = false;
    allObjects = new LinkedList<UUID>();
    objectNames = new HashMap<UUID, String>();
    componentStores = new HashMap<Class, HashMap<UUID, ? extends HexComponent>>();
  }

  public <T extends HexComponent> T getComponent(UUID object,
                                                 Class<T> componentType)
  {
    synchronized (componentStores) {
      HashMap<UUID, ? extends HexComponent> store = componentStores
          .get(componentType);

      if (store == null) {
        throw new IllegalArgumentException(
            "Component GET Error: There are no Objects with a component of type: " + componentType);
      }

      T result = (T) store.get(object);

      if (result == null) {
        throw new IllegalArgumentException("Component GET Error: " + object
                                           + "(name:" + nameFor(object) + ")"
                                           + "does not contain a component of type: " + componentType);
      }

      return result;
    }
  }

  public <T extends HexComponent> void removeComponent(UUID object, T component)
  {
    synchronized (componentStores) {
      HashMap<UUID, ? extends HexComponent> store = componentStores
          .get(component);

      if (store == null) {
        throw new IllegalArgumentException(
            "Component REMOVE Error: There are no Objects with a component of type: " + component
                .getClass());
      }

      T result = (T) store.remove(object);

      if (result == null) {
        throw new IllegalArgumentException("Component REMOVE Error: " + object
                                           + "(name:" + nameFor(object) + ")"
                                           + "does not contain a component of type: " + component
            .getClass());
      }
    }
  }

  public <T extends HexComponent> boolean hasComponent(UUID object,
                                                       Class<T> componentType)
  {
    synchronized (componentStores) {
      HashMap<UUID, ? extends HexComponent> store = componentStores
          .get(componentType);

      if (store == null) {
        return false;
      } else {
        return store.containsKey(object);
      }
    }
  }

  public <T extends HexComponent> List<T> getAllComponentsOnObject(UUID object)
  {
    synchronized (componentStores) {
      LinkedList<T> components = new LinkedList<T>();

      for (HashMap<UUID, ? extends HexComponent> store : componentStores
          .values()) {
        if (store == null) continue;

        T componentFromObj = (T) store.get(object);

        if (componentFromObj != null) {
          components.addLast(componentFromObj);
        }
      }
      return components;
    }
  }

  public <T extends HexComponent> Collection<T> getAllComponentsOfType(Class<T> componentType)
  {
    synchronized (componentStores) {
      HashMap<UUID, ? extends HexComponent> store = componentStores
          .get(componentType);

      if (store == null) {
        return new LinkedList<T>();
      }

      return (Collection<T>) store.values();
    }
  }

  public <T extends HexComponent> Set<UUID> getAllObjectsWithComponent(Class<T> componentType)
  {
    synchronized (componentStores) {
      HashMap<UUID, ? extends HexComponent> store = componentStores
          .get(componentType);

      if (store == null) {
        return new HashSet<UUID>();
      }

      return store.keySet();
    }
  }

  public <T extends HexComponent> void addComponent(UUID object, T component)
  {
    if (frozen) return;

    synchronized (componentStores) {
      HashMap<UUID, ? extends HexComponent> store = componentStores
          .get(component.getClass());

      if (store == null) {
        store = new HashMap<UUID, T>();
        componentStores.put(component.getClass(), store);
      }

      ((HashMap<UUID, T>) store).put(object, component);
    }
  }

  public UUID createObject()
  {
    if (frozen) return null;

    final UUID uuid = UUID.randomUUID();
    allObjects.add(uuid);

    return uuid;
  }

  public UUID createObject(String name)
  {
    if (frozen) return null;

    final UUID uuid = UUID.randomUUID();
    allObjects.add(uuid);
    objectNames.put(uuid, name);

    return uuid;
  }

  public void setObjectName(UUID object, String name)
  {
    objectNames.put(object, name);
  }

  public String nameFor(UUID object)
  {
    return objectNames.get(object);
  }

  public void killObject(UUID object)
  {
    if (frozen) return;

    synchronized (componentStores) {
      for (HashMap<UUID, ? extends HexComponent> componentStore : componentStores
          .values()) {
        componentStore.remove(object);
      }
      allObjects.remove(object);
    }
  }

  public void freeze()
  {
    frozen = true;
  }

  public void unfreeze()
  {
    frozen = false;
  }
}
