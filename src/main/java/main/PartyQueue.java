package main;
import java.util.*;


public class PartyQueue extends ArrayDeque<Party> {
  public String[] names() {
    int i = 0;
    String[] names = new String[size()];
    for (Party party : this)
      names[i++] = party.name();
    return names;
  }
}
