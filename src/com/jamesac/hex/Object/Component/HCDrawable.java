package com.jamesac.hex.Object.Component;

import com.jamesac.hex.Graphics.HexSprite;

/**
 * Created by James on 07/02/14.
 */
public class HCDrawable implements HexComponent {

  public HexSprite sprite;

  public HCDrawable(HexSprite sprite) {
    this.sprite = sprite;
  }
}
