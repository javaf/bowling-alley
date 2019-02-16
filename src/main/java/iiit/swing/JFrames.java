package iiit.swing;

import java.awt.*;
import javax.swing.*;


public class JFrames {
  public static void screenCenter(JFrame frame) {
    Dimension size = frame.getSize();
    Dimension screen = (Toolkit.getDefaultToolkit()).getScreenSize();
    frame.setLocation((screen.width-size.width)/2, (screen.height-size.height)/2);
  }
}
