package com.jamesac.hex.Object.Component;

/**
 * Created by James on 07/02/14.
 */
public class HCVelocity implements HexComponent {

  public double x;
  public double y;

  public HCVelocity(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return "(" + x + "," + y + ")";
  }

}
