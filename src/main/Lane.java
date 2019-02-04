package main;
import java.util.*;


public class Lane extends ArrayList<Game> {
  private String status;
  private final Pinsetter pinsetter;

  
  public Lane() {
    pinsetter = new Pinsetter();
  }
  
  public String name() {
    if (isEmpty()) return "Empty Lane";
    Bowler bowler = get(0).bowler();
    return bowler==null? "Anonymous Lane" : bowler.id()+"'s Party Lane";
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
    if (isEmpty()) return true;
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
  
  public Game game() {
    if (isEmpty()) return null;
    int frame = frame();
    for (Game game : this)
      if(frame > game.size()) return game;
    return get(0);
  }
  
  public Bowler bowler() {
    Game game = game();
    return game!=null? game.bowler() : null;
  }
  
  
  @Override
  public void clear() {
    super.clear();
    pinsetter.reset();
  }
  
  public void addBowlers(Collection<Bowler> bowlers) {
    for (Bowler bowler : bowlers)
      add(new Game(bowler));
  }
}
