package main;
import iiit.util.*;
import java.util.*;

public class Game extends ArrayList<Frame> implements Comparable<Game> {
  private final Bowler bowler;
  public int capacity = 10;
  
  
  public Game(Bowler bowler) {
    this.bowler = bowler;
  }
  
  
  public String name() {
    return bowler==null? "No Game" : bowler.id()+"'s Game";
  }
  
  public Bowler bowler() {
    return bowler;
  }
  
  public Frame last() {
    return isEmpty()? null : get(size()-1);
  }
  
  public boolean complete() {
    return !isEmpty() && size()>=capacity && last().complete(true);
  }
  
  public int capacity() {
    return capacity;
  }
  
  public int score() {
    scoreFrames();
    int score = 0;
    for (Frame frame : this) {
      score += frame.score;
      frame.score = score;
    }
    return score;
  }
  
  private void scoreFrames() {
    int max = 0;
    Frame frame0 = null, frame1 = null;
    for (Frame frame : this) {
      frame.score = 0;
      for (Roll roll : frame) {
        if (frame1 != null && frame1 != frame) frame1.score += roll.score();
        if (frame0 != null && frame0 != frame) frame0.score += roll.score();
        frame0 = roll.spare()? frame : frame1;
        frame1 = roll.strike()? frame : null;
        frame.score += roll.score();
      }
      // NOTE: maybe we can use strategy pattern to dynamically choose:
      // - whether to do it the default way
      // - or give penalty for consecutive gutters
      max = Math.max(max, frame.score);
      if(frame.penalty()) frame.score -= max/2;
    }
  }
  
  public int strikes() {
    int strikes = 0;
    for (Frame frame : this)
      strikes += frame.strikes();
    return strikes;
  }
  
  
  @Override
  public boolean add(Frame frame) {
    return size()<capacity? super.add(frame) : false;
  }
  
  public boolean addRoll(Roll roll) {
    if(isEmpty() || last().complete(size()==capacity)) add(new Frame());
    return last().add(roll, size()==capacity);
  }
  
  
  @Override
  public String toString() {
    StringArea out = new StringArea();
    String frame = get(0).toString();
    if (!isEmpty()) out.insertAt(1, 0, frame);
    int columns = out.columns();
    out.insertAt(0, 0, "Game 00: "+score());
    for (int i=0, I=size(); i<I; i++) {
      frame = get(i).toString();
      String frameId = ""+(i+1);
      out.insertAt(1, i*(columns-1), frame);
      out.insertAt(1, i*(columns-1)+2, frameId);
      System.out.println(frame);
      System.out.println(out);
    }
    return out.toString();
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

  @Override
  public int compareTo(Game other) {
    int diff = this.score()-other.score();
    return diff!=0? diff : this.strikes()-other.strikes();
  }
}
