package main;
import java.util.*;


public class Frame extends ArrayList<Roll> {
  public int score;
  
  
  public Frame() {
    super();
  }
  
  public Frame(Collection<Roll> rolls) {
    super(rolls);
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
      this.get(i).stringify(out, pad+pad).append('\n');
    }
    return out;
  }
}
