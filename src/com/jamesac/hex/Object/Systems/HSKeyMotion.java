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

package com.jamesac.Hex.Object.Systems;

import com.jamesac.Hex.Object.Component.HCKeyMotion;
import com.jamesac.Hex.Object.Component.HCVelocity;
import com.jamesac.Hex.Object.Input.HIKeyboard;

import java.util.Set;
import java.util.UUID;

/**
 * Created by James on 01/03/14.
 */
public class HSKeyMotion extends HexSystem {

  private HIKeyboard keyboard = new HIKeyboard();

  public HSKeyMotion()
  {
    minTime = 1000000000.0 / 60.0;
  }

  @Override
  protected void run()
  {
    Set<UUID> objectsWithComponent = objectManager.getAllObjectsWithComponent(HCKeyMotion.class);

    if (objectsWithComponent.isEmpty()) {
      return;
    }
    keyboard.update();
    if (keyboard.esc) System.exit(0);

    for (UUID o : objectsWithComponent) {
      HCVelocity velocity = objectManager.getComponent(o, HCVelocity.class);
      if (keyboard.up) {
        velocity.y = -3.0;
      } else if (keyboard.down) {
        velocity.y = 3.0;
      } else {
        velocity.y = 0.0;
      }
      if (keyboard.left) {
        velocity.x = -3.0;
      } else if (keyboard.right) {
        velocity.x = 3.0;
      } else {
        velocity.x = 0.0;
      }
    }
  }

  @Override
  public String getName()
  {
    return "[System: KeyMotion]";
  }
}
