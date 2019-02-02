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
    Roll roll = new Roll(pins, foul);
    if(foul) return roll;
    int score = drop(pins);
    int standing = standing();
    roll.strike = score==10;
    roll.spare = standing==0 && turn>1;
    roll.miss = score==0;
    boolean spaced = spaced();
    roll.split = pins[0] && spaced;
    roll.wide = !pins[0] && spaced;
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
      boolean gapL = edgeL? true : pins[i-row] & pins[i+1];
      boolean gapR = edgeR? true : pins[i-row-1] & pins[i-1];
      boolean gapU = pins[i+row+2] & pins[i+row+1];
      if(!(gapL & gapR & gapU)) return false;
      col++;
      if(col>row) {
        row++;
        col = 0;
      }
    }
    return true;
  }
    
  private double luck(double skill) {
    return Math.pow(RANDOM.nextDouble(), 1-skill);
  }
};
