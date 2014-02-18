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

package com.jamesac.Hex.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by James on 07/02/14.
 */
public class HexSpriteSheet {

  private String path;
  public  int[]  pixels;
  public  int    width;
  private int    height;

  public static HexSpriteSheet aliens = new HexSpriteSheet(
      "/Spritesheet/aliens.png",
      128,
      256);

  public static HexSpriteSheet tiles = new HexSpriteSheet(
      "/Spritesheet/fullTiles.png",
      512,
      512);

  public HexSpriteSheet(String path, int width, int height)
  {
    this.path = path;
    this.width = width;
    this.height = height;
    pixels = new int[width * height];
    loadSheet();
  }

  private void loadSheet()
  {
    try {
      BufferedImage image = ImageIO
          .read(HexSpriteSheet.class.getResourceAsStream(path));
      int w = image.getWidth();
      int h = image.getHeight();
      image.getRGB(0, 0, w, h, pixels, 0, w);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
