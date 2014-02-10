package com.jamesac.hex.Object.Component;

/**
 * Defines location of center of object. All logic should use this as a <b>center</b> point.
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
