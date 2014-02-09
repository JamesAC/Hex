package com.jamesac.hex.Graphics;

/**
 * Created by James on 07/02/14.
 */
public class HexSprite {

  public int width, height;
  public int[] pixels;
  private HexSpriteSheet sheet;

  public static HexSprite blueAlien = new HexSprite(40, 66, 40, 66, HexSpriteSheet.aliens);

  public HexSprite(int xOff, int yOff, int width, int height, HexSpriteSheet sheet) {
    this.width = width;
    this.height = height;
    this.sheet = sheet;
    this.pixels = new int[width * height];
    loadSprite(xOff, yOff);
  }

  private void loadSprite(int xOff, int yOff) {
    for (int iy = 0; iy < height; iy++) {
      for (int ix = 0; ix < width; ix++) {
        pixels[ix + iy * width] = sheet.pixels[(ix + xOff) + (iy + yOff) * sheet.width];
      }
    }
  }
}
