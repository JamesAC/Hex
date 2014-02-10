/*
 * Copyright (C) 2013 JamesAC (james@jamesac.co.uk)
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

package com.jamesac.hex;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Hex extends Canvas implements Runnable {

  private static int width;
  private static int height;
  public static int scale = 3;
  public static String title = "Hex";

  private JFrame frame;

  private boolean running = false;
  private Thread thread;

  private BufferedImage image;
  private int[] pixels;
  private HexEngine engine;

  public Hex() {
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    width = gd.getDisplayMode().getWidth() / scale;
    height = gd.getDisplayMode().getHeight() / scale;
    Dimension size = new Dimension(width * scale, height * scale);
    setPreferredSize(size);

    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    frame = new JFrame();
    engine = new HexEngine(width, height);
  }

  public synchronized void start() {
    running = true;
    thread = new Thread(this, "Display");
    thread.start();
  }

  public synchronized void stop() {
    running = false;
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void run() {
    long lastTime = System.nanoTime();
    long timer = System.currentTimeMillis();
    double delta;

    int frames = 0;

    requestFocus();

    while (running) {
      long now = System.nanoTime();
      delta = (now - lastTime);
      update(delta);
      render();
      frames++;
      lastTime = now;

      if (System.currentTimeMillis() - timer > 1000) {
        timer += 1000;
        frame.setTitle(title + "   |   " + frames + "fps");
        frames = 0;
      }
    }

  }

  private void update(double dt) {
    engine.update(dt);
  }

  private void render() {
    BufferStrategy bs = getBufferStrategy();
    if (bs == null) {
      createBufferStrategy(3);
      return;
    }

    System.arraycopy(engine.display.pixels, 0, pixels, 0, engine.display.pixels.length);

    Graphics g = bs.getDrawGraphics();
    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    g.dispose();
    bs.show();
  }

  public static void main(String[] args) {
    Hex game = new Hex();
    game.frame.setResizable(false);
    game.frame.setTitle(title);
    game.frame.setUndecorated(true);
    game.frame.add(game);
    game.frame.pack();
    game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.frame.setLocationRelativeTo(null);
    game.frame.setVisible(true);

    game.start();
  }
}
