package main;
import java.util.*;
import java.io.*;


public class ScoreHistoryFileAdapter {
  private static ScoreFile SCORE_FILE = new ScoreFile("SCORE_HISTORY.DAT");
  
  public static void addScore(String nick, String date, String score)
    throws IOException {
    SCORE_FILE.add(new Score(nick, date, score));
  }

  public static Vector getScores(String nick)
    throws IOException {
    return new Vector(SCORE_FILE.get(nick));
  }
}
