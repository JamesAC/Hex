package com.jamesac.hex;

import com.jamesac.hex.Object.HexObjectManager;
import com.jamesac.hex.Object.Systems.HexSystem;
import com.jamesac.hex.Object.Systems.HexSystemManager;

public class HexEngine {

  public HexDisplay display;

  public HexObjectManager objectManager;
  public HexSystemManager systemManager;

  public HexEngine(int width, int height) {
    systemManager = new HexSystemManager();
    objectManager = new HexObjectManager();
    display = new HexDisplay(width, height);
  }

  public void update(double dt) {
    for (HexSystem s : systemManager.systems) {
      s.update(dt);
    }
  }

}
