package iiit.util;
import java.util.*;


public class StringArea extends ArrayList<StringBuilder> {
  public int rows() {
    return size();
  }
  
  public int columns() {
    int columns = 0;
    for (StringBuilder line : this)
      columns = Math.max(columns, line.length());
    return columns;
  }
  
  
  public StringArea insertAt(int row, int column, String string) {
    String[] blocks = string.split("\n");
    int rows = row+blocks.length;
    if (size()<rows) setRows(rows);
    for (int i=0; i<blocks.length; i++) {
      StringBuilder line = get(row+i);
      if(line.length()<column) line.append(" ".repeat(column-line.length()));
      line.replace(column, column+blocks[i].length(), blocks[i]);
    }
    return this;
  }
  
  public StringArea setRows(int rows) {
    if (size()<rows) {
      for (int i=0, I=rows-size(); i<I; i++)
        add(new StringBuilder());
    }
    else if(size()>rows) {
      for (int i=size()-1; i>=rows; i--)
        this.remove(i);
    }
    return this;
  }
  
  public StringArea setColumns(int columns) {
    for (StringBuilder line : this)
      if (line.length()>columns) line.setLength(columns);
    return this;
  }
  
  
  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    for (StringBuilder line : this)
      out.append(line).append('\n');
    return out.toString();
  }
}
