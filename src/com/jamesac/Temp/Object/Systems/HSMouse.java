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

package com.jamesac.Temp.Object.Systems;

import com.jamesac.Temp.Object.Input.HIMouse;

/**
 * Created by James on 01/03/14.
 */
public class HSMouse extends HexSystem {

  private HIMouse mouse;

  public HSMouse()
  {
    minTime = 1000000000.0 / 60.0;
  }

  @Override
  protected void run()
  {

  }

  @Override
  public String getName()
  {
    return null;
  }
}
