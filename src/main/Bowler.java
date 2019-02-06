package main;


public class Bowler {
  private final String id;
  private final String name;
  private final String email;
  private final double skill;
  
  
  public Bowler() {
    this("unknown", "unknown", "unknown");
  }
  
  public Bowler(String id, String name, String email) {
    this(id, name, email, Math.random());
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
  
   
  @Override
  public String toString() {
    return stringify(new StringBuilder(), "").toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Bowler]\n");
    out.append(pad).append("id: ").append(id()).append('\n');
    out.append(pad).append("name: ").append(name()).append('\n');
    out.append(pad).append("email: ").append(email()).append('\n');
    out.append(pad).append("skill: ").append(skill()).append('\n');
    return out;
  }
  
  
  public static Bowler parseLine(String line) {
    // Format is <nickname>\t<fullname>\t<email>
    String[] fields = line.split("\t");
    return fields.length>2? new Bowler(fields[0], fields[1], fields[2]):null;
  }
  
  public String stringifyLine() {
    return id+"\t"+name+"\t"+email;
  }
}
