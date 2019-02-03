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
  
  @Override
  public String toString() {
    StringBuilder string = new StringBuilder("[Roll]\n");
    string.append("strike: ").append(strike).append('\n');
    string.append("spare: ").append(spare).append('\n');
    string.append("miss: ").append(miss).append('\n');
    string.append("foul: ").append(foul).append('\n');
    string.append("split: ").append(split).append('\n');
    string.append("wide: ").append(wide).append('\n');
    string.append("score: ").append(score).append('\n');
    string.append(Pinsetter.stringifyPins(pins));
    return string.toString();
  }
}
