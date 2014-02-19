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

package com.jamesac.Hex.Object.Component;

import com.jamesac.Hex.Graphics.HexSprite;

/**
 * Component to store drawable sprite for an object. Will be drawn centered on
 * an accompanying {@link com.jamesac.Hex.Object.Component.HCPosition}
 * component.
 *
 * @author JamesAC
 */
public class HCDrawable implements HexComponent {

  public HexSprite sprite;
  public int       layer;

  /**
   * @param sprite The sprite to be used to render the owner object
   */
  public HCDrawable(HexSprite sprite)
  {
    this(sprite, 0);
  }

  public HCDrawable(HexSprite sprite, int layer)
  {
    this.sprite = sprite;
    this.layer = layer;
  }
}
