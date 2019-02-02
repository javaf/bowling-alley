public class Bowler {
  String nickname;
  String fullname;
  String email;

  
  public Bowler(String nickname, String fullname, String email) {
    this.nickname = nickname;
    this.fullname = fullname;
    this.email = email;
  }
  
  public static Bowler parse(String line) {
    // Format is <nickname>\t<fullname>\t<email>
    String[] fields = line.split("\t");
    return fields.length>2? new Bowler(fields[0], fields[1], fields[2]):null;
  }
  
  public String stringify() {
    return nickname+"\t"+fullname+"\t"+email;
  }
}
