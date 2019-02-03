package main;
import java.util.*;


public class Lane extends ArrayList<Game> {
  private String status;
  private final Pinsetter pinsetter;

  
  public Lane() {
    pinsetter = new Pinsetter();
  }
  
  public String name() {
    return isEmpty()? "Empty Lane" : get(0).bowler().id()+"'s Party Lane";
  }
  
  public String status() {
    return status;
  }
  
  public String status(String status) {
    return this.status = status;
  }

  public Pinsetter pinsetter() {
    return pinsetter;
  }
  
  public boolean complete() {
    for (Game game : this)
      if (!game.complete()) return false;
    return true;
  }
  
  public int frame() {
    int frame = 0;
    for (Game game : this)
      frame = Math.max(frame, game.size());
    return frame;
  }
  
  public Bowler bowler() {
    if (isEmpty()) return null;
    int frame = frame();
    for (Game game : this)
      if(frame > game.size()) return game.bowler();
    return get(0).bowler();
  }
  
  
  @Override
  public void clear() {
    super.clear();
    pinsetter.reset();
  }
}
