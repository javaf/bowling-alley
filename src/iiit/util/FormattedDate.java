package iiit.util;
import java.text.*;
import java.util.*;


public class FormattedDate extends Date {
  private final DateFormat dateFormat;
  
  
  public FormattedDate() {
    this("dd/MM/yyyy HH:mm:ss");
  }

  public FormattedDate(String format) {
    dateFormat = new SimpleDateFormat(format);
  }
  
  
  @Override
  public String toString() {
    return dateFormat.format(this);
  }
}
