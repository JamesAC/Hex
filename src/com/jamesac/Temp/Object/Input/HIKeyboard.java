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

package com.jamesac.Temp.Object.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by James on 01/03/14.
 */
public class HIKeyboard implements KeyListener {

  private static boolean[] keys = new boolean[120];
  public boolean up, down, left, right, esc;

  @Override
  public void keyTyped(KeyEvent e)
  {

  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    keys[e.getKeyCode()] = true;
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    keys[e.getKeyCode()] = false;
  }

  public void update()
  {
    up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
    down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
    left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
    right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
    esc = keys[KeyEvent.VK_ESCAPE];
  }
}
