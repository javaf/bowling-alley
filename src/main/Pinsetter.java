package main;
import java.util.*;


/* PINS:
    6   7U   8U   9
      3L   4   5R
        1L   2R
           0
   neighbours of 4:
   U=up, L=left, R=right
 */
public class Pinsetter {
  private final boolean[] pins;

  
  public Pinsetter() {
    pins = new boolean[10];
    Arrays.fill(pins, true);
  }

  
  public boolean[] pins() {
    return pins;
  }
  
  public int standing() {
    int standing = 0;
    for(var i=0; i<pins.length; i++)
      if(pins[i]) standing++;
    return standing;
  }
  
  public boolean spaced() {
    for(int i=0, col=0, row=0; i<pins.length; i++) {
      boolean lend = row==0 || col==0;
      boolean rend = row==0 || col==row;
      boolean uend = i+row+2>=pins.length;
      boolean l = lend? false : pins[i-1] | pins[i-row+1];
      boolean r = rend? false : pins[i+1] | pins[i-row];
      boolean u = uend? false : pins[i+row+2] | pins[i+row+1];
      if(pins[i] && (l | r | u)) return false;
      col++;
      if(col>row) {
        col = 0;
        row++;
      }
    }
    return true;
  }

  public void clear() {
    Arrays.fill(pins, true);
  }
  
  public int drop(boolean[] hits) {
    int dropped = 0;
    for(int i=0; i<pins.length; i++)
      if (pins[i] && hits[i]) { pins[i] = false; dropped++; }
    return dropped;
  }
  
  
  @Override
  public String toString() {
    return stringify(new StringBuilder(), "").toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Pinsetter]\n");
    out.append(pad).append("standing: ").append(standing()).append('\n');
    out.append(pad).append("spaced: ").append(spaced()).append('\n');
    out.append(pad).append("pins:\n");
    return stringifyPins(out, pad+"  ", pins);
  }
  
  
  private static StringBuilder stringifyPins(StringBuilder out, String pad, boolean[] pins) {
    out.append(pad);
    for(int col=0, lastRow=rows(pins.length)-1, row=lastRow; row>=0;) {
      int i = row*(row+1)/2 + col;
      out.append(i).append(pins[i]? 'A' : '_').append("  ");
      col++;
      if(col>row) {
        col = 0; row--;
        out.append('\n').append(pad);
        out.append("  ".repeat(lastRow-row));
      }
    }
    out.append('\n');
    return out;
  }
  
  private static int rows(int pins) {
    int a = 1, b = 1, c = -2*pins;
    return (int)Math.floor((-b + Math.sqrt(b*b - 4*a*c)) / (2*a));
  }
};
