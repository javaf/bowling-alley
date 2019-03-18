package main;
import java.util.*;


public class Party extends ArrayList<Bowler> {
  public int capacity = 6;
  
  
  public String name() {
    return isEmpty()? "Empty Party" : get(0).id()+"'s Party";
  }
  
  public String[] ids() {
    String[] ids = new String[size()];
    for (int i=0; i<ids.length; i++)
      ids[i] = get(i).id();
    return ids;
  }
  
  public boolean full() {
    return size()>=capacity;
  }
  
  
  @Override
  public boolean add(Bowler bowler) {
    return size()>=capacity? false : super.add(bowler);
  }
  
  public List<Game> play() {
    List<Game> games = new ArrayList<>();
    for (Bowler bowler : this) {
      Game game = new Game(bowler);
      bowler.games().add(game);
      games.add(game);
    }
    return games;
  }
  
  
  @Override
  public String toString() {
    return stringify(new StringBuilder(), "").toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Party]\n");
    out.append(pad).append("name: ").append(name()).append('\n');
    for(int i=0; i<size(); i++) {
      out.append(pad).append("bowler[").append(i).append("]:\n");
      get(i).stringify(out, pad+"  ");
    }
    return out;
  }
}
