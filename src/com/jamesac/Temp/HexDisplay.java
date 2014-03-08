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

import java.util.Random;

public class HexDisplay {

  private Random random = new Random();

  private   int     width;
  private   int     height;
  protected int[][] pixels;

  public HexDisplay(int width, int height)
  {
    this.width = width;
    this.height = height;

    pixels = new int[2][width * height];

    for (int i = 0; i < width * height; i++) {
      pixels[1][i] = random.nextInt();
    }
  }

  public void renderSprite(int xp, int yp, HexSprite sprite, int layer)
  {
    xp -= sprite.width / 2;
    yp -= sprite.height / 2;
    for (int y = 0; y < sprite.height; y++) {
      int ya = y + yp;
      for (int x = 0; x < sprite.width; x++) {
        int xa = x + xp;
        if (xa < -sprite.width || xa >= width || ya < 0 || ya >= height) break;
        if (xa < 0 || ya < 0) continue;
        if ((pixels[0][xa + ya * width] < layer)) {
          int col = sprite.pixels[x + y * sprite.width];
          if (col != 0x00000000) {
            pixels[0][xa + ya * width] = layer;
            pixels[1][xa + ya * width] = col;
          }
        }
      }
    }
  }

  public void clear()
  {
    clear(0);
  }

  /**
   * Clears all pixels to given colour. Use {@link #clear()} for default black.
   */
  public void clear(int col)
  {
    for (int i = 0; i < pixels[0].length; i++) {
      pixels[0][i] = Integer.MIN_VALUE;
      pixels[1][i] = col;
    }
  }

  public void clearRand()
  {
    for (int i = 0; i < pixels[0].length; i++) {
      pixels[0][i] = Integer.MIN_VALUE;
      pixels[1][i] = random.nextInt();
    }
  }
}
