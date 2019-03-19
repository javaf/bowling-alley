package main;
import java.util.*;


public abstract class ScoreData {
  public abstract void add(Record score) throws Exception;
  public abstract List<Record> get(String id) throws Exception;
}
