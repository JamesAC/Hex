package com.jamesac.hex.Object.Systems;

import com.jamesac.hex.Object.HexObjectManager;

/**
 * Created by James on 07/02/14.
 */
public abstract class HexSystem {

  protected double minTime = 0;
  private double tDiff;
  protected HexObjectManager objectManager;

  protected HexSystem() {

  }

  public void update(double dt) {
    tDiff += dt;
    if (tDiff > minTime) {
      this.run();
      tDiff = 0;
    }
  }

  protected abstract void run();

  public abstract String getName();

  public void setObjectManager(HexObjectManager objectManager) {
    this.objectManager = objectManager;
  }
}
