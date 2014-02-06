package com.jamesac.hex.Object;

import com.jamesac.hex.Object.Component.HexComponent;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created by James on 02/02/14.
 */
public class HexObject {

  public final UUID objectID = UUID.randomUUID();

  private List<HexComponent> components = new LinkedList<HexComponent>();

  public HexObject(HexComponent... components) {
    for (HexComponent c : components) {
      this.components.add(c);
    }
  }

  public UUID getObjectID() {
    return objectID;
  }

  public <T extends HexComponent> HexComponent getComponent(Class<T> componentType) {
    if (components == null) return null;
    for (HexComponent c : components) {
      if (c.getClass().isInstance(componentType)) {
        return c;
      }
    }
    return null;
  }

  public <T extends HexComponent> boolean hasComponent(Class<T> componentType) {
    if (components == null) return false;
    for (HexComponent c : components) {
      if (c.getClass().isInstance(componentType)) {
        return true;
      }
    }
    return false;
  }
}
