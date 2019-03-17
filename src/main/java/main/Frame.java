package main;
import java.util.*;


public class Frame extends ArrayList<Roll> {
  public static final Frame EMPTY = new Frame(0);
  private final int capacity;
  public int score;
  
  
  public Frame(int capacity) {
    this.capacity = capacity;
  }
  
  
  public int capacity() {
    return capacity;
  }
  
  public int score() {
    return score;
  }
  
  public boolean full() {
    for (Roll roll : this)
      if (roll.full()) return true;
    return false;
  }
  
  public int strikes() {
    int strikes = 0;
    for (Roll roll : this)
      strikes += roll.strike()? 1 : 0;
    return strikes;
  }
  
  public boolean penalty() {
    boolean prev = false;
    for (Roll roll : this) {
      if(roll.gutter() && prev) return true;
      prev = roll.gutter();
    }
    return false;
  }
  
  public boolean complete(boolean tenth) {
    int size = size();
    if (!tenth) return size==0 && size<capacity? false : (size>=capacity || last().full());
    return full()? size>=capacity+1 : size>=capacity;
  }
  
  public Roll last() {
    return isEmpty()? null : get(size() - 1);
  }

  @Override
  public boolean add(Roll roll) {
    return add(roll, false);
  }
  
  public boolean add(Roll roll, boolean tenth) {
    return complete(tenth)? false: super.add(roll);
  }

  
  @Override
  public String toString() {
    int size = size();
    String roll0 = size>0? get(0).toString() : "";
    String roll1 = size>1? get(1).toString() : "";
    String roll2 = size>2? get(2).toString() : "";
    StringBuilder out = new StringBuilder();
    out.append(String.format("|-:::%3d---|\n", score()));
    out.append(String.format("| %2s %2s %2s |\n", roll0, roll1, roll2));
    out.append(String.format("|----------|\n"));
    return out.toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Frame]\n");
    out.append(pad).append("score: ").append(score()).append('\n');
    for(int i=0; i<size(); i++) {
      out.append(pad).append("roll[").append(i).append("]:\n");
      get(i).stringify(out, pad+"  ").append('\n');
    }
    return out;
  }
}
