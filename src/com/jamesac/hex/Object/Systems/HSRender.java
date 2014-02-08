package com.jamesac.hex.Object.Systems;

import com.jamesac.hex.HexDisplay;
import com.jamesac.hex.Object.Component.HCDrawable;
import com.jamesac.hex.Object.Component.HCPosition;

import java.util.Set;
import java.util.UUID;

/**
 * Created by James on 07/02/14.
 */
public class HSRender extends HexSystem {

  private HexDisplay display;

  public HSRender(HexDisplay display) {
    super();
    this.display = display;
  }

  @Override
  public void run() {
    Set<UUID> objs = objectManager.getAllObjectsWithComponent(HCDrawable.class);
    for (UUID o : objs) {
      HCDrawable drawable = objectManager.getComponent(o, HCDrawable.class);
      HCPosition position = objectManager.getComponent(o, HCPosition.class);
      display.renderSprite((int) position.x, (int) position.y, drawable.sprite);
    }
  }

  @Override
  public String getName() {
    return null;
  }
}
