package main;
import java.util.*;


public class Frame extends ArrayList<Roll> {
  public int score;
  
  
  public Frame() {
    super();
  }
  
  public int score() {
    return score;
  }
  
  public Roll last() {
    return isEmpty()? null : get(size() - 1);
  }
  
  public boolean complete(boolean tenth) {
    int size = size();
    if(!tenth) return size==0? false : (size>=2 || last().full());
    boolean bonus = (size>0 && get(0).full()) || (size>1 && get(1).full());
    return bonus? size>=3 : size>=2;
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
    return stringify(new StringBuilder(), "").toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Frame]\n");
    out.append(pad).append("score: ").append(score).append('\n');
    for(int i=0; i<size(); i++) {
      out.append(pad).append("roll[").append(i).append("]:\n");
      get(i).stringify(out, pad+"  ").append('\n');
    }
    return out;
  }
}
