package main;
import java.util.*;


public class Lane {
  private String name;
  private ArrayList<Bowler> bowlers;
  private ArrayList<Game> games;
  private Pinsetter pinsetter;
  private int turn;
  
  public Lane() {
    bowlers = new ArrayList<>();
    games = new ArrayList<>();
    pinsetter = new Pinsetter();
  }
  
  public void reset() {
    name = null;
    bowlers.clear();
    games.clear();
    pinsetter.reset();
    turn = 0;
  }
}
