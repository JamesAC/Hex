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

package com.jamesac.Temp.Map;

import com.jamesac.Temp.Graphics.HexSprite;

/**
 * Created by jc3810 on 14/02/14.
 */
public class HexTile {

  public static HexTile tileDirt = new HexTile(HexSprite.tileDirt,
                                               "Dirt Tile");
  public static HexTile tileGrass = new HexTile(HexSprite.tileGrass,
                                                "Grass Tile");

  private HexSprite sprite;
  private String    tileName;

  public HexTile(HexSprite sprite, String tileName)
  {
    this.sprite = sprite;
    this.tileName = tileName;
  }

  public HexSprite getSprite()
  {
    return sprite;
  }
}
