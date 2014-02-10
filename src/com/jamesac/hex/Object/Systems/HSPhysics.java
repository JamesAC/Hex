package com.jamesac.hex.Object.Systems;

import com.jamesac.hex.Object.Component.HCPosition;
import com.jamesac.hex.Object.Component.HCVelocity;

import java.util.Set;
import java.util.UUID;

/**
 * Created by James on 07/02/14.
 */
public class HSPhysics extends HexSystem {

  public HSPhysics() {
    minTime = 1000000000.0 / 60;
  }

  @Override
  protected void run() {
    Set<UUID> objectsWithVelComponent = objectManager.getAllObjectsWithComponent(HCVelocity.class);
    for (UUID o : objectsWithVelComponent) {
      HCVelocity velocity = objectManager.getComponent(o, HCVelocity.class);
      HCPosition position = objectManager.getComponent(o, HCPosition.class);
      position.x += velocity.x;
      if (position.x > 1920 / 3 || position.x < 0) {
        velocity.x = -(velocity.x);
      }
      position.y += velocity.y;
      if (position.y > 1080 / 3 || position.y < 0) {
        velocity.y = -(velocity.y);
      }
    }
  }

  @Override
  public String getName() {
    return "System: Physics";
  }
}
