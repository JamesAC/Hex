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

package com.jamesac.hex.Object.Systems;

import com.jamesac.hex.Object.Component.HCPosition;
import com.jamesac.hex.Object.Component.HCVelocity;

import java.util.Set;
import java.util.UUID;

/**
 * Created by James on 07/02/14.
 */
public class HSPhysics extends HexSystem {

  public HSPhysics()
  {
    minTime = 1000000000.0 / 60;
  }

  @Override
  protected void run()
  {
    Set<UUID> objectsWithVelComponent = objectManager
        .getAllObjectsWithComponent(HCVelocity.class);
    for (UUID o : objectsWithVelComponent) {
      HCVelocity velocity = objectManager.getComponent(o, HCVelocity.class);
      HCPosition position = objectManager.getComponent(o, HCPosition.class);
      position.x += velocity.x;
      if (position.x > 1920 / 3 || position.x < 0) {
        velocity.x = -(velocity.x);
      }
      position.y += velocity.y;
      if (position.y > 1080 / 3 || position.y < 0) {
        velocity.y = -(velocity.y);
      }
    }
  }

  @Override
  public String getName()
  {
    return "System: Physics";
  }
}
