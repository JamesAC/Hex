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

package com.jamesac.Hex.Map;

import java.util.HashMap;

/**
 * Created by jc3810 on 14/02/14.
 */
public class HexMap {

  public HashMap<HexCoord, HexTile> map;

  public HexMap()
  {
    map = new HashMap<HexCoord, HexTile>(256);
  }

  public void generateMap()
  {
    for (int y = 0; y < 12; y++) {
      for (int x = -4; x < 12; x++) {
        HexCoord pos = new HexCoord(x, y);
        map.put(pos, HexTile.tileDirt);
      }
    }
  }

  public HexTile getTileAtPixel(double x, double y)
  {
    HexCoord coord;
    int size = 32;
    double q = (1 / 3 * Math.sqrt(3) * x - 1 / 3 * y) / size;
    double r = 2 / 3 * y / size;

    coord = HexCoord.round(q, r);

    // TODO: This won't work as is, need to hash by actual location (Maybe?)
    return map.get(coord);
  }
}
