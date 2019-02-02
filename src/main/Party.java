package main;
import java.util.*;


public class Party extends ArrayList<Bowler> {
  
  public String name() {
    return get(0).nickname+"'s Party";
  }
  
  public ArrayList<String> nicknames() {
    ArrayList<String> nicknames = new ArrayList<>();
    for(Bowler bowler : this)
      nicknames.add(bowler.nickname);
    return nicknames;
  }
}
