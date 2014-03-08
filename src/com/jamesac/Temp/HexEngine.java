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

package com.jamesac.Temp;

import com.jamesac.Temp.Graphics.HexSprite;
import com.jamesac.Temp.Object.Component.HCDrawable;
import com.jamesac.Temp.Object.Component.HCKeyMotion;
import com.jamesac.Temp.Object.Component.HCPosition;
import com.jamesac.Temp.Object.Component.HCVelocity;
import com.jamesac.Temp.Object.HexObjectManager;
import com.jamesac.Temp.Object.Systems.HSKeyMotion;
import com.jamesac.Temp.Object.Systems.HSLevel;
import com.jamesac.Temp.Object.Systems.HSPhysics;
import com.jamesac.Temp.Object.Systems.HSRender;
import com.jamesac.Temp.Object.Systems.HexSystem;
import com.jamesac.Temp.Object.Systems.HexSystemManager;

import java.util.UUID;

public class HexEngine {

  public HexDisplay display;

  public HexObjectManager objectManager;
  public HexSystemManager systemManager;

  public HexEngine(int width, int height)
  {
    display = new HexDisplay(width, height);
    objectManager = new HexObjectManager();
    systemManager = new HexSystemManager(objectManager);
    systemManager.addSystem(new HSLevel());
    systemManager.addSystem(new HSRender(display));
    systemManager.addSystem(new HSPhysics());
    systemManager.addSystem(new HSKeyMotion());

    UUID alien = objectManager.createObject("alien");
    objectManager.addComponent(alien, new HCDrawable(HexSprite.blueAlien));
    objectManager.addComponent(alien, new HCPosition(50.0, 50.0));
    objectManager.addComponent(alien, new HCVelocity(0.0, 0.0));
    objectManager.addComponent(alien, new HCKeyMotion());
  }

  public void update(double dt)
  {
    for (HexSystem s : systemManager.systems) {
      s.update(dt);
    }
  }

}
