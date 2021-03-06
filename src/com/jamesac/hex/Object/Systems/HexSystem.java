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

package com.jamesac.Hex.Object.Systems;

import com.jamesac.Hex.Object.HexObjectManager;

/**
 * Created by James on 07/02/14.
 */
public abstract class HexSystem {

  protected double minTime = 0;
  private   double           tDiff;
  protected HexObjectManager objectManager;

  protected HexSystem()
  {

  }

  public void update(double dt)
  {
    tDiff += dt;
    if (tDiff > minTime) {
      this.run();
      tDiff = 0;
    }
  }

  protected abstract void run();

  public abstract String getName();

  public void setObjectManager(HexObjectManager objectManager)
  {
    this.objectManager = objectManager;
  }
}
