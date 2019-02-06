package main;


public class Roll {
  private final boolean headpin;
  private final boolean spaced;
  private final boolean foul;
  private final int standing;
  private final int dropped;
  

  public Roll(Pinsetter pinsetter) {
    this(pinsetter, Math.random());
  }
  
  public Roll(Pinsetter pinsetter, double skill) {
    this(pinsetter, outcomes(skill, 10), luck(skill)<0.05);
  }
  
  public Roll(Pinsetter pinsetter, boolean[] hits, boolean foul) {
    this.dropped = pinsetter.drop(hits);
    this.standing = pinsetter.standing();
    this.headpin = pinsetter.pins()[0];
    this.spaced = pinsetter.spaced();
    this.foul = foul;
  }
  
  
  public int score() {
    return foul? 0 : dropped;
  }
  
  public int dropped() {
    return dropped;
  }
  
  public int standing() {
    return standing;
  }
  
  public boolean strike() {
    return foul? false : dropped==10;
  }
  
  public boolean spare() {
    return foul? false : standing==0 && dropped<10;
  }
  
  public boolean full() {
    return foul? false : standing==0;
  }
  
  public boolean miss() {
    return dropped==0;
  }
  
  public boolean foul() {
    return foul;
  }
  
  public boolean split() {
    return !headpin && spaced;
  }
  
  public boolean wide() {
    return headpin && spaced;
  }
  
  
  @Override
  public String toString() {
    return stringify(new StringBuilder(), "").toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Roll]\n");
    out.append(pad).append("score: ").append(score()).append('\n');
    out.append(pad).append("dropped: ").append(dropped()).append('\n');
    out.append(pad).append("standing: ").append(standing()).append('\n');
    out.append(pad).append("strike: ").append(strike()).append('\n');
    out.append(pad).append("spare: ").append(spare()).append('\n');
    out.append(pad).append("full: ").append(full()).append('\n');
    out.append(pad).append("miss: ").append(miss()).append('\n');
    out.append(pad).append("foul: ").append(foul()).append('\n');
    out.append(pad).append("split: ").append(split()).append('\n');
    out.append(pad).append("wide: ").append(wide()).append('\n');
    return out;
  }

  
  private static boolean[] outcomes(double skill, int count) {
    boolean[] outcomes = new boolean[count];
    for (int i=0; i<count; i++)
      outcomes[i] = luck(skill)>=0.5;
    return outcomes;
  }
  
  private static double luck(double skill) {
    return Math.pow(Math.random(), 1-skill);
  }
}
