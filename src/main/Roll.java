package main;


public class Roll {
  public boolean[] pins; // true => pins dropped
  public boolean strike;
  public boolean spare;
  public boolean miss;
  public boolean foul;
  public boolean split;
  public boolean wide;
  public int score;
  
  
  public Roll(boolean[] pins) {
    this.pins = pins;
  }
}
