package main;

import java.util.*;
import java.io.*;


class BowlerMap extends HashMap<String, Bowler> {
  private String file;

  
  public BowlerMap(String file) {
    this.file = file;
  }
  
  public String file() {
    return file;
  }
  
  public ArrayList<String> ids() {
    ArrayList<String> ids = new ArrayList<>();
    for(Bowler bowler : values())
      ids.add(bowler.id());
    return ids;
  }
  
  
  public BowlerMap load()
    throws IOException, FileNotFoundException {
    BufferedReader in = new BufferedReader(new FileReader(file));
    for(String line; (line=in.readLine())!=null;) {
      Bowler bowler = Bowler.parseLine(line);
      if(bowler!=null) put(bowler.id(), bowler);
    }
    in.close();
    return this;
  }

  public void add(Bowler bowler)
    throws IOException, FileNotFoundException {
    put(bowler.id(), bowler);
    RandomAccessFile out = new RandomAccessFile(file, "rw");
    out.skipBytes((int)out.length());
    out.writeBytes(bowler.stringifyLine()+"\n");
    out.close();
  }
}
