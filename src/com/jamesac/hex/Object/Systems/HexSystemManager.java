package com.jamesac.hex.Object.Systems;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by James on 07/02/14.
 */
public class HexSystemManager {

  private boolean frozen;
  public List<HexSystem> systems;

  public HexSystemManager() {
    frozen = false;
    systems = new LinkedList<HexSystem>();
  }
}
