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
}
