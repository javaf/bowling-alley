package main;


public class Roll implements Comparable<Roll> {
  public static final Roll EMPTY = new Roll(0, 0, false, false, false, false);
  private final boolean headpin;
  private final boolean spaced;
  private final boolean gutter;
  private final boolean foul;
  private final int standing;
  private final int dropped;
  

  public Roll(Pinsetter pinsetter) {
    this(pinsetter, Math.random());
  }
  
  public Roll(Pinsetter pinsetter, double skill) {
    this(pinsetter, outcomes(skill, 10), luck(skill)<0.1, luck(skill)<0.05);
  }
  
  public Roll(Pinsetter pinsetter, boolean[] hits, boolean gutter, boolean foul) {
    this.dropped = gutter? 0 : pinsetter.drop(hits);
    this.standing = pinsetter.standing();
    this.headpin = pinsetter.pins()[0];
    this.spaced = pinsetter.spaced();
    this.gutter = gutter;
    this.foul = foul;
  }
  
  public Roll(int dropped, int standing, boolean headpin, boolean spaced, boolean gutter, boolean foul) {
    this.dropped = dropped;
    this.standing = standing;
    this.headpin = headpin;
    this.spaced = spaced;
    this.gutter = gutter;
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
  
  public boolean gutter() {
    return gutter;
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
    if(gutter()) return "G";
    if(foul()) return "F";
    if(strike()) return "X";
    if(spare()) return "/";
    if(miss()) return "-";
    if(split()) return "S"+score();
    if(wide()) return "W"+score();
    return ""+score();
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
    out.append(pad).append("gutter: ").append(gutter()).append('\n');
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

  @Override
  public int compareTo(Roll other) {
    int diff = score()-other.score();
    return diff!=0? diff : (strike()? 1:0) - (other.strike()? 1:0);
  }
}
