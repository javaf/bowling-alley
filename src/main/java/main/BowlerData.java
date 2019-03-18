package main;
import java.util.*;


public abstract class BowlerData extends HashMap<String, Bowler> {
  
  public String[] ids() {
    int i = 0;
    String[] ids = new String[size()];
    for (Bowler bowler : values())
      ids[i++] = bowler.id();
    return ids;
  }
  
  
  public abstract BowlerData load() throws Exception;
  public abstract void add(Bowler bowler) throws Exception;
}
