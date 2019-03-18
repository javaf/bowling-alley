package main;
import java.io.*;


public class BowlerFile extends BowlerData {
  private final String file;

  
  public BowlerFile(String file) {
    this.file = file;
  }

  
  @Override
  public BowlerFile load() throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(file));
    for(String line; (line=in.readLine())!=null;) {
      Bowler bowler = parseLine(line);
      if(bowler!=null) put(bowler.id(), bowler);
    }
    in.close();
    return this;
  }

  @Override
  public void add(Bowler bowler) throws IOException {
    put(bowler.id(), bowler);
    RandomAccessFile out = new RandomAccessFile(file, "rw");
    out.skipBytes((int)out.length());
    out.writeBytes(stringifyLine(bowler)+"\n");
    out.close();
  }


  private static Bowler parseLine(String line) {
    // Format is <nickname>\t<fullname>\t<email>
    String[] fields = line.split("\t");
    return fields.length>2? new Bowler(fields[0], fields[1], fields[2]):null;
  }
  
  private static String stringifyLine(Bowler b) {
    return b.id()+"\t"+b.name()+"\t"+b.email();
  }
}
