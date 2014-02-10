package com.jamesac.hex.Object.Component;

import com.jamesac.hex.Graphics.HexSprite;

/**
 * Component to store drawable sprite for an object. Will be drawn centered on an accompanying {@link com.jamesac.hex.Object.Component.HCPosition} component.
 *
 * @author JamesAC
 */
public class HCDrawable implements HexComponent {

  public HexSprite sprite;

  public HCDrawable(HexSprite sprite) {
    this.sprite = sprite;
  }
}
