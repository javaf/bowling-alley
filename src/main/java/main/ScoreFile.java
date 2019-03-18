package main;
import java.io.*;
import java.util.*;


public class ScoreFile extends ScoreData {
  private final String file;
  
  
  public ScoreFile(String file) {
    this.file = file;
  }
  
  @Override
  public void add(Score score) throws IOException {
    try (RandomAccessFile out = new RandomAccessFile(file, "rw")) {
      out.skipBytes((int) out.length());
      out.writeBytes(stringifyLine(score)+"\n");
    }
  }
  
  @Override
  public List<Score> get(String id) throws IOException {
    List<Score> scores = new ArrayList<>();
    BufferedReader in = new BufferedReader(new FileReader(file));
    for (String line; (line=in.readLine()) != null;) {
      Score score = parseLine(line);
      if(score!=null && score.id().equals(id)) scores.add(score);
    }
    return scores;
  }
  

  private static Score parseLine(String line) {
    String[] fields = line.trim().split("\t");
    return fields.length > 2? new Score(fields[0], fields[1], Integer.parseInt(fields[2])) : null;
  }
  
  private static String stringifyLine(Score s) {
    return s.id()+"\t"+s.date()+"\t"+s.score();
  }
}
