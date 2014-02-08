package com.jamesac.hex.Object.Systems;

import com.jamesac.hex.Object.HexObjectManager;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 07/02/14.
 */
public class HexSystemManager {

  private boolean frozen;
  public List<HexSystem> systems;
  private HexObjectManager objectManager;

  public HexSystemManager(HexObjectManager objectManager) {
    this.objectManager = objectManager;
    frozen = false;
    systems = new LinkedList<HexSystem>();
  }

  public <T extends HexSystem> void addSystem(T system) {
    system.setObjectManager(objectManager);
    systems.add(system);
  }
}
