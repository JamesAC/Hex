/*
 * Copyright (C) 2014 JamesAC (james@jamesac.co.uk)
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

package com.jamesac.Hex.Map;

/**
 * Created by jc3810 on 14/02/14.
 */
public class HexCoord {

  private int r;
  private int q;
  private int y;

  public HexCoord()
  {
    r = 0;
    q = 0;
    y = 0;
  }

  public HexCoord(int r, int q)
  {
    this.r = r;
    this.q = q;
    this.y = -r - q;
  }

  public HexCoord setCoord(int r, int q)
  {
    this.r = r;
    this.q = q;
    this.y = -r - q;

    return this;
  }

  public static HexCoord round(double q, double r)
  {
    int rx = (int) Math.round(q);
    int rz = (int) Math.round(r);
    int ry = (int) Math.round(-q - r);

    int x_diff = (int) Math.abs(rx - q);
    int y_diff = (int) Math.abs(ry - r);
    int z_diff = (int) Math.abs(rz - (-q - r));

    if ((x_diff > y_diff) && (x_diff > z_diff)) {
      rx = -ry - rz;
    } else if (y_diff > z_diff) {
      ry = -rx - rz;
    } else {
      rz = -rx - ry;
    }

    return new HexCoord(rz, rx);
  }

  public int getR()
  {
    return r;
  }

  public void setR(int r)
  {
    this.r = r;
  }

  public int getQ()
  {
    return q;
  }

  public void setQ(int q)
  {
    this.q = q;
  }
}
