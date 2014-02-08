package com.jamesac.hex.Object.Systems;

import com.jamesac.hex.Object.HexObjectManager;

/**
 * Created by James on 07/02/14.
 */
public abstract class HexSystem {

  protected double minTime = 0;
  private double lastTime;
  protected HexObjectManager objectManager;

  protected HexSystem() {

  }

  public void update(double dt) {

    // TODO: Need to fix this
    if (dt > minTime) {
      this.run();
      lastTime = System.nanoTime();
    }
  }

  protected abstract void run();

  public abstract String getName();

  public void setObjectManager(HexObjectManager objectManager) {
    this.objectManager = objectManager;
  }
}
