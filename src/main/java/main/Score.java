package main;

public class Score {
  private final String id;
  private final String date;
  private final int value;


  public Score(String id, String date, int score) {
    this.id = id;
    this.date = date;
    this.value = score;
  }
  
  
  public String id() {
    return id;
  }

  public String date() {
    return date;
  }

  public int value() {
    return value;
  }

  
  @Override
  public String toString() {
    return String.format("%-20s %-20s %d", id(), date(), value());
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[Score]\n");
    out.append(pad).append("id: ").append(id()).append('\n');
    out.append(pad).append("date: ").append(date()).append('\n');
    out.append(pad).append("value: ").append(value()).append('\n');
    return out;
  }
}
