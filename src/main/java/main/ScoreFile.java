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
    RandomAccessFile out = new RandomAccessFile(file, "rw");
    out.skipBytes((int) out.length());
    out.writeBytes(score.stringifyLine()+"\n");
    out.close();
  }
  
  @Override
  public List<Score> get(String id) throws IOException {
    List<Score> scores = new ArrayList<>();
    BufferedReader in = new BufferedReader(new FileReader(file));
    for (String line; (line=in.readLine()) != null;) {
      Score score = Score.parseLine(line);
      if(score!=null && score.id().equals(id)) scores.add(score);
    }
    return scores;
  }
}
