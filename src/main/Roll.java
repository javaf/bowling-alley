package main;
import java.util.*;


public class Roll {
  private static final Random RANDOM = new Random();
  public boolean[] pins; // true => pins dropped
  public boolean strike;
  public boolean spare;
  public boolean miss;
  public boolean foul;
  public boolean split;
  public boolean wide;
  public int score;
  
  
  public Roll(boolean[] pins, boolean foul) {
    this.pins = pins;
    this.foul = foul;
  }
}
