/*
 * Copyright (C) 2013 JamesAC (james@jamesac.co.uk)
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

package com.jamesac.hex;

import com.jamesac.hex.Graphics.HexSprite;
import com.jamesac.hex.Object.Component.HCDrawable;
import com.jamesac.hex.Object.Component.HCPosition;
import com.jamesac.hex.Object.Component.HCVelocity;
import com.jamesac.hex.Object.HexObjectManager;
import com.jamesac.hex.Object.Systems.HSPhysics;
import com.jamesac.hex.Object.Systems.HSRender;
import com.jamesac.hex.Object.Systems.HexSystem;
import com.jamesac.hex.Object.Systems.HexSystemManager;

import java.util.UUID;

public class HexEngine {

  public HexDisplay display;

  public HexObjectManager objectManager;
  public HexSystemManager systemManager;

  public HexEngine(int width, int height)
  {
    objectManager = new HexObjectManager();
    systemManager = new HexSystemManager(objectManager);
    display = new HexDisplay(width, height);
    systemManager.addSystem(new HSRender(display));
    systemManager.addSystem(new HSPhysics());

    UUID alien = objectManager.createObject("alien");
    objectManager.addComponent(alien, new HCDrawable(HexSprite.blueAlien));
    objectManager.addComponent(alien, new HCPosition(50.0, 50.0));
    objectManager.addComponent(alien, new HCVelocity(3.0, 3.0));
  }

  public void update(double dt)
  {
    for (HexSystem s : systemManager.systems) {
      s.update(dt);
    }
  }

}
