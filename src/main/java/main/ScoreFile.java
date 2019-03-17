package main;
import java.io.*;
import java.util.*;


public class ScoreFile {
  private final String file;
  
  
  public ScoreFile(String file) {
    this.file = file;
  }
  
  public void add(Score score)
    throws IOException {
    RandomAccessFile out = new RandomAccessFile(file, "rw");
    out.skipBytes((int) out.length());
    out.writeBytes(score.stringifyLine()+"\n");
    out.close();
  }
  
  public ArrayList<Score> get(String id)
    throws IOException {
    ArrayList<Score> scores = new ArrayList<>();
    BufferedReader in = new BufferedReader(new FileReader(file));
    for (String line; (line=in.readLine()) != null;) {
      Score score = Score.parseLine(line);
      if(score!=null && score.id().equals(id)) scores.add(score);
    }
    return scores;
  }
}