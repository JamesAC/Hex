package com.jamesac.hex.Object.Component;

/**
 * Created by James on 07/02/14.
 */
public class HCPosition implements HexComponent {

  public double x, y;

  public HCPosition(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return "(" + x + "," + y + ")";
  }

}
