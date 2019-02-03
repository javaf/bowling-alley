package main;
import java.util.*;


public class Lane extends ArrayList<Game> {
  private final Pinsetter pinsetter;
  private int turn;
  
  public Lane() {
    pinsetter = new Pinsetter();
  }
  
  public Pinsetter pinsetter() {
    return pinsetter;
  }
  
  public String name() {
    return null;
  }
  
  @Override
  public void clear() {
    super.clear();
    pinsetter.reset();
    turn = 0;
  }
}
