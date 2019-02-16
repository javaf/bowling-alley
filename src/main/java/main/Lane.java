package main;
import java.util.*;


public class Lane extends ArrayList<Game> {
  private final Pinsetter pinsetter;
  private boolean pinsetterClear;
  private Party party;
  private int turn;
  private int progress;
  public String status;

  
  public Lane() {
    pinsetter = new Pinsetter();
  }
  
  public String name() {
    return party==null? "Empty Lane" : party.name();
  }
  
  public String status() {
    return status;
  }

  public Pinsetter pinsetter() {
    return pinsetter;
  }
  
  public Party party() {
    return party;
  }
  
  public int turn() {
    return turn;
  }
  
  public Game game() {
    return turn<size()? get(turn) : null;
  }
  
  public int progress() {
    return progress;
  }
  
  public Frame frame() {
    return game().get(progress);
  }
  
  public boolean complete() {
    return isEmpty() || progress==10;
  }
  
  
  public void assign(Party party) {
    clear();
    this.party = party;
    for (Game game : party.play())
      add(game);
  }
  
  public boolean addRoll(Roll roll) {
    if (complete()) return false;
    game().addRoll(roll);
    pinsetterClear = pinsetter.standing()==0;
    if (frame().complete(progress+1==10)) { pinsetterClear = true; turn++; }
    if (turn >= size()) { turn = 0; progress++; }
    return true;
  }
  
  public void update() {
    if (pinsetterClear) pinsetter.clear();
    pinsetterClear = false;
  }
  
  @Override
  public void clear() {
    super.clear();
    pinsetter.clear();
    turn = progress = 0;
    party = null;
  }
}
