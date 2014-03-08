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

import com.jamesac.Hex.Map.HexCoord;
import com.jamesac.Hex.Map.HexMap;
import com.jamesac.Hex.Map.HexTile;
import com.jamesac.Hex.Object.Component.HCDrawable;
import com.jamesac.Hex.Object.Component.HCPosition;

import java.util.Map;
import java.util.UUID;

/**
 * Created by James on 18/02/14.
 */
public class HSLevel extends HexSystem {

  private HexMap map = null;

  public HSLevel()
  {
    super();
  }

  @Override
  protected void run()
  {
    if (map == null) {
      map = new HexMap();
      map.generateMap();

      int i = 0;
      for (Map.Entry<HexCoord, HexTile> currTile : map.map.entrySet()) {
        UUID t = objectManager.createObject("Tile" + i);

        int q = currTile.getKey().getQ();
        int r = currTile.getKey().getR();

        double x = 37.5 * (Math.sqrt(3.0) * ((double) q + (double) r / 2.0));
        double y = 32.5 * (3.0 / 2.0) * (double) r - 24;

        objectManager.addComponent(t,
                                   new HCDrawable(currTile.getValue().getSprite(),
                                                  r - 100));
        objectManager.addComponent(t, new HCPosition(x, y));
      }
    }
  }

  @Override
  public String getName()
  {
    return null;
  }
}
