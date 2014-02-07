package com.jamesac.hex.Object.Systems;

/**
 * Created by James on 07/02/14.
 */
public abstract class HexSystem {

  protected double minTime = 0;
  private double lastTime;

  public void update(double dt) {

    // TODO: Need to fix this
    if (dt > minTime) {
      this.run();
      lastTime = System.nanoTime();
    }
  }

  protected abstract void run();

  public abstract String getName();

}
