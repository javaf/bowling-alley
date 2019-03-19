package main;
import java.util.*;


public abstract class BowlerData extends HashMap<String, Bowler> {
  public abstract void add(Bowler bowler) throws Exception;
  

  public String[] ids() {
    int i = 0;
    String[] ids = new String[size()];
    for (Bowler bowler : values())
      ids[i++] = bowler.id();
    return ids;
  }
}
