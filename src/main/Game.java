package main;
import java.util.*;

public class Game extends ArrayList<Frame> {
  public Game() {
  }
  
  public Frame last() {
    return isEmpty()? null : get(size()-1);
  }
  
  public boolean complete() {
    int size = size();
    return size==0? false : (size>=10 && last().complete(true));
  }
  
  public int score() {
    scoreEach();
    int score = 0;
    for (Frame frame : this) {
      score += frame.score;
      frame.score = score;
    }
    return score;
  }
  
  private void scoreEach() {
    Frame frame0 = null, frame1 = null;
    for (Frame frame : this) {
      frame.score = 0;
      for (Roll roll : frame) {
        if (frame1 != null && frame1 != frame) frame1.score += roll.score;
        if (frame0 != null && frame0 != frame) frame0.score += roll.score;
        frame0 = roll.spare()? frame : frame1;
        frame1 = roll.strike()? frame : null;
        frame.score += roll.score;
      }
    }
  }
  
  
  @Override
  public boolean add(Frame frame) {
    return size()<10? super.add(frame) : false;
  }
  
  public boolean addRoll(Roll roll) {
    if(isEmpty() || last().complete(size()==10)) add(new Frame());
    return last().add(roll, size()==10);
  }
  
  
  @Override
  public String toString() {
    return stringify(new StringBuilder(), "").toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Game]\n");
    out.append(pad).append("score: ").append(score()).append('\n');
    out.append(pad).append("complete: ").append(complete()).append('\n');
    for(var i=0; i<size(); i++) {
      out.append(pad).append("frame[").append(i).append("]:\n");
      get(i).stringify(out, pad+"  ").append('\n');
    }
    return out;
  }
}
