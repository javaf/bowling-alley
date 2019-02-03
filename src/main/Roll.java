package main;


public class Roll {
  private final boolean[] pins; // true => drop pins
  private final boolean headpin; // true => headpin not standing
  private final boolean spaced;
  private final boolean foul;
  private final int turn;
  private final int standing;
  public final int score;
  
  
  public Roll(
      boolean[] pins, boolean headpin, boolean spaced, boolean foul,
      int turn, int standing, int score) {
    this.pins = pins;
    this.headpin = headpin;
    this.spaced = spaced;
    this.foul = foul;
    this.turn = turn;
    this.standing = standing;
    this.score = score;
  }
  
  public boolean[] pins() {
    return pins;
  }
  
  public int turn() {
    return turn;
  }
  
  public int standing() {
    return standing;
  }
  
  public int score() {
    return score;
  }
  
  public boolean strike() {
    return score==10;
  }
  
  public boolean spare() {
    return !foul && standing==0 && turn>0;
  }
  
  public boolean full() {
    return !foul && standing==0;
  }
  
  public boolean miss() {
    return score==0;
  }
  
  public boolean foul() {
    return foul;
  }
  
  public boolean split() {
    return headpin && spaced;
  }
  
  public boolean wide() {
    return !headpin && spaced;
  }

  
  @Override
  public String toString() {
    return stringify(new StringBuilder(), "").toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Roll]\n");
    out.append(pad).append("turn: ").append(turn()).append('\n');
    out.append(pad).append("standing: ").append(standing()).append('\n');
    out.append(pad).append("score: ").append(score()).append('\n');
    out.append(pad).append("strike: ").append(strike()).append('\n');
    out.append(pad).append("spare: ").append(spare()).append('\n');
    out.append(pad).append("full: ").append(full()).append('\n');
    out.append(pad).append("miss: ").append(miss()).append('\n');
    out.append(pad).append("foul: ").append(foul()).append('\n');
    out.append(pad).append("split: ").append(split()).append('\n');
    out.append(pad).append("wide: ").append(wide()).append('\n');
    out.append(pad).append("pins:\n");
    return Pinsetter.stringifyPins(out, pad, pins);
  }
}
