package main;
import java.util.*;


public abstract class RecordData {
  public abstract void add(Record record) throws Exception;
  public abstract List<Record> get(String id) throws Exception;
  public abstract List<Record> query(String query) throws Exception;
}
