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
    return stringify(new StringBuilder(), "").toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Roll]\n");
    out.append(pad).append("strike: ").append(strike).append('\n');
    out.append(pad).append("spare: ").append(spare).append('\n');
    out.append(pad).append("miss: ").append(miss).append('\n');
    out.append(pad).append("foul: ").append(foul).append('\n');
    out.append(pad).append("split: ").append(split).append('\n');
    out.append(pad).append("wide: ").append(wide).append('\n');
    out.append(pad).append("score: ").append(score).append('\n');
    out.append(pad).append("pins:\n");
    return Pinsetter.stringifyPins(out, pad, pins);
  }
}
