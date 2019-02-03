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
  public boolean[] pins;
  public int turn;
  private static final Random RANDOM = new Random();

  
  public Pinsetter() {
    pins = new boolean[10];
    turn = 0;
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
    turn++;
    Roll roll = new Roll(pins);
    if(foul) return roll;
    int score = drop(pins);
    roll.strike = score==10;
    roll.spare = standing()==0 && turn>1;
    roll.miss = score==0;
    roll.foul = foul;
    boolean spaced = spaced();
    roll.split = this.pins[0] && spaced;
    roll.wide = !this.pins[0] && spaced;
    roll.score = score;
    return roll;
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
      if(!(gapL & gapR & gapU)) return false;
      col++;
      if(col>row) {
        col = 0;
        row++;
      }
    }
    return true;
  }
  
  private static double luck(double skill) {
    return Math.pow(RANDOM.nextDouble(), 1-skill);
  }
  
  @Override
  public String toString() {
    StringBuilder string = new StringBuilder("[Pinsetter]\n");
    string.append("turn: ").append(turn).append('\n');
    string.append(stringifyPins(pins));
    return string.toString();
  }
  
  public static String stringifyPins(boolean[] pins) {
    StringBuilder string = new StringBuilder();
    for(int col=0, lastRow=rows(pins.length)-1, row=lastRow; row>=0;) {
      int i = row*(row+1)/2 + col;
      string.append(i).append(pins[i]? '_' : 'A').append("  ");
      col++;
      if(col>row) {
        col = 0;
        row--;
        string.append('\n');
        string.append("  ".repeat(lastRow-row));
      }
    }
    return string.toString();
  }
  
  private static int rows(int pins) {
    int a = 1, b = 1, c = -2*pins;
    return (int)Math.floor((-b + Math.sqrt(b*b - 4*a*c)) / (2*a));
  }
};
