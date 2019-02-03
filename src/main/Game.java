package main;
import java.util.*;

public class Game extends ArrayList<Frame> {
  public Game() {
    super();
  }
  
  public Game(Collection<Frame> frames) {
    super(frames);
  }
  
  public int score() {
    int score = 0;
    Frame frame0 = null, frame1 = null;
    for (Frame frame : this) {
      for (Roll roll : frame) {
        if (frame1 != null) {
          frame1.score += roll.score;
          score += roll.score;
        }
        if (frame0 != null) {
          frame0.score += roll.score;
          score += roll.score;
        }
        frame0 = roll.spare? frame : frame1;
        frame1 = roll.spare? frame : null;
        score += roll.score;
      }
      frame.score = score;
    }
    return score;
  }
  
  
  @Override
  public String toString() {
    return stringify(new StringBuilder(), "").toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Game]\n");
    out.append(pad).append("score: ").append(score()).append('\n');
    for(var i=0; i<size(); i++) {
      out.append(pad).append("frame[").append(i).append("]:\n");
      get(i).stringify(out, pad+"  ").append('\n');
    }
    return out;
  }
}
