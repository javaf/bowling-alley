package main;
import java.util.*;


public class Lane extends ArrayList<Game> {
  private final Pinsetter pinsetter;
  private Party party;
  private int turn;
  private int progress;

  
  public Lane() {
    pinsetter = new Pinsetter();
  }
  
  public String name() {
    return party==null? "Empty Lane" : party.name();
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
    if (pinsetter.standing()==0) pinsetter.clear();
    if (frame().complete(progress==10)) { pinsetter.clear(); turn++; }
    if (turn >= size()) { turn = 0; progress++; }
    return true;
  }
  
  @Override
  public void clear() {
    super.clear();
    pinsetter.clear();
    turn = progress = 0;
    party = null;
  }
}
