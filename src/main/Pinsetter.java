package main;
import java.util.*;


/* PINS:
   true => pins dropped
    6   7U   8U   9
      3L   4   5R
        1L   2R
           0
   neighbours of 4:
   U=up, L=left, R=right
 */
public class Pinsetter {
  private final boolean[] pins;
  private int turn;
  private static final Random RANDOM = new Random();

  
  public Pinsetter() {
    pins = new boolean[10];
    turn = 0;
  }
  
  public boolean[] pins() {
    return pins;
  }
  
  public int turn() {
    return turn;
  }
  
  public int standing() {
    int count = 0;
    for(var i=0; i<pins.length; i++)
      count += pins[i]? 1 : 0;
    return count;
  }
  
  public void reset() {
    for (int i=0; i<pins.length; i++)
      pins[i] = false;
    turn = 0;
  }
  
  public Roll roll() {
    return roll(RANDOM.nextDouble());
  }
  
  public Roll roll(double skill) {
    boolean[] pins = new boolean[10];
    boolean foul = luck(skill)<0.05;
    for (int i=0; i<pins.length; i++)
      pins[i] = luck(skill)>=0.5;
    return roll(pins, foul);
  }
  
  public Roll roll(boolean[] pins, boolean foul) {
    int score = drop(pins);
    if(foul) return new Roll(pins, pins[0], false, foul, turn++, standing(), 0);
    return new Roll(pins, pins[0], spaced(), foul, turn++, standing(), score);
  }
  
  
  private int drop(boolean[] pins) {
    int score = 0;
    for(int i=0; i<pins.length; i++) {
      score += !this.pins[i] && pins[i]? 1 : 0;
      this.pins[i] |= pins[i];
    }
    return score;
  }
  
  private boolean spaced() {
    for(int i=0, col=0, row=0; i<pins.length; i++) {
      boolean edgeL = row==0 || col==0;
      boolean edgeR = row==0 || col==row;
      boolean edgeU = i+row+2>=pins.length;
      boolean gapL = edgeL? true : pins[i-1] & pins[i-row+1];
      boolean gapR = edgeR? true : pins[i+1] & pins[i-row];
      boolean gapU = edgeU? true : pins[i+row+2] & pins[i+row+1];
      if(!pins[i] && !(gapL & gapR & gapU)) return false;
      col++;
      if(col>row) {
        col = 0;
        row++;
      }
    }
    return true;
  }
  
  private static int rows(int pins) {
    int a = 1, b = 1, c = -2*pins;
    return (int)Math.floor((-b + Math.sqrt(b*b - 4*a*c)) / (2*a));
  }
  
  private static double luck(double skill) {
    return Math.pow(RANDOM.nextDouble(), 1-skill);
  }
  
  
  @Override
  public String toString() {
    return stringify(new StringBuilder(), "").toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Pinsetter]\n");
    out.append(pad).append("turn: ").append(turn()).append('\n');
    out.append(pad).append("standing: ").append(standing()).append('\n');
    out.append(pad).append("pins:\n");
    return stringifyPins(out, pad+"  ", pins);
  }
  
  public static StringBuilder stringifyPins(StringBuilder out, String pad, boolean[] pins) {
    out.append(pad);
    for(int col=0, lastRow=rows(pins.length)-1, row=lastRow; row>=0;) {
      int i = row*(row+1)/2 + col;
      out.append(i).append(pins[i]? '_' : 'A').append("  ");
      col++;
      if(col>row) {
        col = 0;
        row--;
        out.append('\n').append(pad);
        out.append("  ".repeat(lastRow-row));
      }
    }
    out.append('\n');
    return out;
  }
};
