package main;

public class Score {
  public String id;
  public String date;
  public String score;


  public Score(String id, String date, String score) {
    this.id = id;
    this.date = date;
    this.score = score;
  }
  
  public static Score parse(String line) {
    String[] fields = line.trim().split("\t");
    return fields.length > 2? new Score(fields[0], fields[1], fields[2]) : null;
  }
  
  public String stringify() {
    return id + "\t" + date + "\t" + score;
  }
  
  public String getNickName() {
    return id;
  }

  public String getDate() {
    return date;
  }

  public String getScore() {
    return score;
  }

  public String toString() {
    return stringify();
  }
}
