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

import com.jamesac.Hex.HexDisplay;
import com.jamesac.Hex.Object.Component.HCDrawable;
import com.jamesac.Hex.Object.Component.HCPosition;

import java.util.Set;
import java.util.UUID;

/**
 * Created by James on 07/02/14.
 */
public class HSRender extends HexSystem {

  private HexDisplay display;

  public HSRender(HexDisplay display)
  {
    super();
    this.display = display;
  }

  @Override
  public void run()
  {
    display.clear();
    Set<UUID> objects = objectManager
        .getAllObjectsWithComponent(HCDrawable.class);

    for (UUID o : objects) {
      HCDrawable drawable = objectManager.getComponent(o, HCDrawable.class);
      HCPosition position = objectManager.getComponent(o, HCPosition.class);
      display.renderSprite((int) position.x, (int) position.y,
                           drawable.sprite, drawable.layer);
    }
  }

  @Override
  public String getName()
  {
    return null;
  }
}
