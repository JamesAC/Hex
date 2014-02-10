package com.jamesac.hex;

import com.jamesac.hex.Graphics.HexSprite;

import java.util.Random;

public class HexDisplay {

  private Random random = new Random();

  private int width;
  private int height;
  protected int[] pixels;

  public HexDisplay(int width, int height) {
    this.width = width;
    this.height = height;

    pixels = new int[width * height];

    for (int i = 0; i < width * height; i++) {
      pixels[i] = random.nextInt();
    }
  }

  public void renderSprite(int xp, int yp, HexSprite sprite) {
    xp -= sprite.width / 2;
    yp -= sprite.height / 2;
    for (int y = 0; y < sprite.height; y++) {
      int ya = y + yp;
      for (int x = 0; x < sprite.width; x++) {
        int xa = x + xp;
        if (xa < -sprite.width || xa >= width || ya < 0 || ya >= height) break;
        if (xa < 0) xa = 0;
        int col = sprite.pixels[x + y * sprite.width];
        if (col != 0x00000000)
          pixels[xa + ya * width] = col;
      }
    }
  }

  public void clear() {
    clear(0);
  }

  /**
   * Clears all pixels to given colour. Use {@link #clear()} for default black.
   */
  public void clear(int col) {
    for (int i = 0; i < pixels.length; i++) {
      pixels[i] = col;
    }
  }

  public void clearRand() {
    for (int i = 0; i < pixels.length; i++) {
      pixels[i] = random.nextInt();
    }
  }
}
