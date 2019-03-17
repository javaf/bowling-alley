package main;
import java.util.*;


public class Lane extends ArrayList<Game> {
  private final Pinsetter pinsetter;
  private boolean pinsetterClear;
  private Party party;
  private int turn;
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
    return turn<size()? get(turn) : Game.EMPTY;
  }
  
  public int progress() {
    int progress = 0;
    for (Game game : this)
      if (!game.complete()) progress = Math.min(progress, game.size());
    return progress;
  }
  
  public Frame frame() {
    return game().last();
  }
  
  public boolean complete() {
    for (Game game : this)
      if (!game.complete()) return false;
    return true;
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
    return true;
  }
  
  public void update() {
    if (frame().complete()) nextTurn();
    if (pinsetterClear) pinsetter.clear();
    pinsetterClear = false;
  }
  
  private void nextTurn() {
    pinsetterClear = true;
    for (int i=0, I=size(); i<I; i++) {
      turn = (turn+1) % I;
      if (!get(turn).complete()) return;
    }
  }
  
  @Override
  public void clear() {
    super.clear();
    pinsetter.clear();
    turn = 0;
    party = null;
  }
}
