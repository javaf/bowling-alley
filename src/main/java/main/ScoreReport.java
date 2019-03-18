package main;
import iiit.util.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.awt.print.*;


public class ScoreReport {
  private final Bowler bowler;
  private List<Score> scores;
  private static final ScoreFile SCORE_FILE = new ScoreFile("SCOREHISTORY.DAT");
  
  public ScoreReport(Bowler bowler) {
    this.bowler = bowler;
    try {
      for (Game game : bowler.games())
        SCORE_FILE.add(new Score(bowler.id(), new FormattedDate().toString(), game.score()));
      this.scores = SCORE_FILE.get(bowler.id());
    }
    catch (IOException e) { System.err.println(e); }
  }
  
  
  public void print() {
    printText(toString());
  }
  
  public void email() {
    sendEmail(bowler.email(), toString());
  }
  
  
  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    out.append("Lucky Strikes Bowling Center (LSBC)\n");
    out.append("===================================\n\n");
    out.append("Score Report: ").append(new FormattedDate()).append('\n');
    out.append(bowler).append('\n');
    out.append("Average score: ").append((int) averageScore(scores)).append('\n');
    for (Score score : scores)
      out.append(score).append('\n');
    return out.toString();
  }
  
  public StringBuilder stringify(StringBuilder out, String pad) {
    out.append(pad).append("[ScoreReport]\n");
    out.append(pad).append("bowler:\n");
    bowler.stringify(out, pad+"  ");
    for (int i=0; i<scores.size(); i++) {
      out.append(pad).append("score[").append(i).append("]:\n");
      scores.get(i).stringify(out, pad+"  ");
    }
    return out;
  }
  
  
  private static double averageScore(List<Score> scores) {
    int total = 0;
    for (Score score : scores)
      total += score.value();
    return scores.size()>0? ((double)total)/scores.size() : 0;
  }
  
  private static void printText(String content) {
    PrinterJob job = PrinterJob.getPrinterJob();
    PrintableText printobj = new PrintableText(content);
    job.setPrintable(printobj);
    if (job.printDialog()) {
      try { job.print(); }
      catch (PrinterException e) { System.err.println(e); }
    }
  }
  
  private static void sendEmail(String recipient, String content) {
    try {
      Socket s = new Socket("osfmail.rit.edu", 25);
      BufferedReader in = new BufferedReader(
        new InputStreamReader(s.getInputStream(), "8859_1"));
      BufferedWriter out = new BufferedWriter(
        new OutputStreamWriter(s.getOutputStream(), "8859_1"));
      String boundary = "DataSeparatorString";
      // here you are supposed to send your username
      sendLine(in, out, "HELO world");
      sendLine(in, out, "MAIL FROM: <mda2376@rit.edu>");
      sendLine(in, out, "RCPT TO: <" + recipient + ">");
      sendLine(in, out, "DATA");
      sendLine(out, "Subject: Bowling Score Report ");
      sendLine(out, "From: <Lucky Strikes Bowling Club>");
      sendLine(out, "Content-Type: text/plain; charset=\"us-ascii\"\r\n");
      sendLine(out, content + "\n\n");
      sendLine(out, "\r\n");
      sendLine(in, out, ".");
      sendLine(in, out, "QUIT");
      s.close();
    } catch (IOException e) {
      System.err.println(e);
    }
  }

  private static void sendLine(BufferedReader in, BufferedWriter out, String s) {
    try {
      out.write(s + "\r\n");
      out.flush();
      // System.out.println(s);
      s = in.readLine();
      // System.out.println(s);
    } catch (IOException e) {
      System.err.println(e);
    }
  }

  private static void sendLine(BufferedWriter out, String s) {
    try {
      out.write(s + "\r\n");
      out.flush();
      // System.out.println(s);
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
