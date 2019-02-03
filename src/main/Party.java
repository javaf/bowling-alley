package main;
import java.util.*;


public class Party extends ArrayList<Bowler> {
  
  public String name() {
    return get(0).id+"'s Party";
  }
  
  public ArrayList<String> nicknames() {
    ArrayList<String> nicknames = new ArrayList<>();
    for(Bowler bowler : this)
      nicknames.add(bowler.id);
    return nicknames;
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
