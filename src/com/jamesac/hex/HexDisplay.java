package com.jamesac.hex;

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
}
