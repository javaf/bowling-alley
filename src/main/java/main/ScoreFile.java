package main;
import java.io.*;
import java.util.*;


public class ScoreFile extends ScoreData {
  private final String file;
  
  
  public ScoreFile(String file) {
    this.file = file;
  }
  
  @Override
  public void add(Record score) throws IOException {
    try (RandomAccessFile out = new RandomAccessFile(file, "rw")) {
      out.skipBytes((int) out.length());
      out.writeBytes(stringifyLine(score)+"\n");
    }
  }
  
  @Override
  public List<Record> get(String id) throws IOException {
    List<Record> scores = new ArrayList<>();
    BufferedReader in = new BufferedReader(new FileReader(file));
    for (String line; (line=in.readLine()) != null;) {
      Record score = parseLine(line);
      if(score!=null && score.id().equals(id)) scores.add(score);
    }
    return scores;
  }
  

  private static Record parseLine(String line) {
    String[] fields = line.trim().split("\t");
    return fields.length > 2? new Record(fields[0], fields[1], Integer.parseInt(fields[2])) : null;
  }
  
  private static String stringifyLine(Record s) {
    return s.id()+"\t"+s.date()+"\t"+s.score();
  }
}
