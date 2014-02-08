package com.jamesac.hex.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by James on 07/02/14.
 */
public class HexSpriteSheet {

  private String path;
  public int[] pixels;
  public int width;
  private int height;

  public static HexSpriteSheet aliens = new HexSpriteSheet("/Spritesheet/aliens.png", 128, 256);

  public HexSpriteSheet(String path, int width, int height) {
    this.path = path;
    this.width = width;
    this.height = height;
    pixels = new int[width * height];
    loadSheet();
  }

  private void loadSheet() {
    try {
      BufferedImage image = ImageIO.read(HexSpriteSheet.class.getResourceAsStream(path));
      int w = image.getWidth();
      int h = image.getHeight();
      image.getRGB(0, 0, w, h, pixels, 0, w);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
