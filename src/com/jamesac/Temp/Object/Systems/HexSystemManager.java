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

package com.jamesac.Temp.Object.Systems;

import com.jamesac.Temp.Object.HexObjectManager;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 07/02/14.
 */
public class HexSystemManager {

  private boolean          frozen;
  public  List<HexSystem>  systems;
  private HexObjectManager objectManager;

  public HexSystemManager(HexObjectManager objectManager)
  {
    this.objectManager = objectManager;
    frozen = false;
    systems = new LinkedList<HexSystem>();
  }

  public <T extends HexSystem> void addSystem(T system)
  {
    if (frozen) return;
    system.setObjectManager(objectManager);
    systems.add(system);
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
