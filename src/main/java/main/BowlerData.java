package main;
import java.util.*;


public class BowlerData extends HashMap<String, Bowler> {
  public void add(Bowler bowler) throws Exception {
    put(bowler.id(), bowler);
  }
  

  public String[] ids() {
    int i = 0;
    String[] ids = new String[size()];
    for (Bowler bowler : values())
      ids[i++] = bowler.id();
    return ids;
  }
}
