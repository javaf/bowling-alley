package main;
import java.util.*;


public class Bowler {
  private final String id;
  private final String name;
  private final String email;
  private final double skill;
  private final List<Game> games;
  
  
  public Bowler() {
    this("Unknown", "Unknown", "Unknown");
  }
  
  public Bowler(String id, String name, String email) {
    this(id, name, email, Math.random());
  }
  
  public Bowler(String id, String name, String email, double skill) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.skill = skill;
    this.games = new ArrayList<>();
  }
  
  
  public String id() {
    return id;
  }
  
  public String name() {
    return name;
  }
  
  public String email() {
    return email;
  }
  
  public double skill() {
    return skill;
  }
  
  public List<Game> games() {
    return games;
  }
  
   
  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    out.append(String.format("%s aka %s <%s>\n", name(), id(), email()));
    for (int i=0, I=games.size(); i<I; i++)
      out.append(games.get(i).toString().replace("00", ""+(i+1)));
    return out.toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Bowler]\n");
    out.append(pad).append("id: ").append(id()).append('\n');
    out.append(pad).append("name: ").append(name()).append('\n');
    out.append(pad).append("email: ").append(email()).append('\n');
    out.append(pad).append("skill: ").append(skill()).append('\n');
    for (int i=0; i<games.size(); i++) {
      out.append(pad).append("game[").append(i).append("]:\n");
      games.get(i).stringify(out, pad+"  ");
    }
    return out;
  }
}
