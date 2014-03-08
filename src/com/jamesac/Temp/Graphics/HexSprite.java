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

package com.jamesac.Temp.Graphics;

/**
 * Created by James on 07/02/14.
 */
public class HexSprite {

  public int width, height;
  public  int[]          pixels;
  private HexSpriteSheet sheet;

  public static HexSprite blueAlien = new HexSprite(40,
                                                    66,
                                                    40,
                                                    66,
                                                    HexSpriteSheet.aliens);

  public static HexSprite tileDirt  = new HexSprite(0, 0, 65, 89,
                                                    HexSpriteSheet.tiles);
  public static HexSprite tileGrass = new HexSprite(195, 267, 65, 89,
                                                    HexSpriteSheet.tiles);

  public HexSprite(int xOff,
                   int yOff,
                   int width,
                   int height,
                   HexSpriteSheet sheet)
  {
    this.width = width;
    this.height = height;
    this.sheet = sheet;
    this.pixels = new int[width * height];
    loadSprite(xOff, yOff);
  }

  private void loadSprite(int xOff, int yOff)
  {
    for (int iy = 0; iy < height; iy++) {
      for (int ix = 0; ix < width; ix++) {
        pixels[ix + iy * width] = sheet.pixels[(ix + xOff) + (iy + yOff) * sheet.width];
      }
    }
  }
}
