package main;
import java.util.*;


public class Bowler {
  String id;
  String name;
  String email;
  private double skill;
  private static final Random RANDOM = new Random();
  
  
  public Bowler(String id, String name, String email) {
    this(id, name, email, RANDOM.nextDouble());
  }
  
  public Bowler(String id, String name, String email, double skill) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.skill = skill;
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
  
  
  public static Bowler parseLine(String line) {
    // Format is <nickname>\t<fullname>\t<email>
    String[] fields = line.split("\t");
    return fields.length>2? new Bowler(fields[0], fields[1], fields[2]):null;
  }
  
  public String stringifyLine() {
    return id+"\t"+name+"\t"+email;
  }
  
   
  @Override
  public String toString() {
    return stringify(new StringBuilder(), "").toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Bowler]\n");
    out.append(pad).append("id: ").append(id()).append('\n');
    out.append(pad).append("name: ").append(name()).append('\n');
    out.append(pad).append("email: ").append(email).append('\n');
    out.append(pad).append("skill: ").append(skill()).append('\n');
    return out;
  }
}
