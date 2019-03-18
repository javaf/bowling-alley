package main;
import java.util.*;


public abstract class ScoreData {
  public abstract void add(Score score) throws Exception;
  public abstract List<Score> get(String id) throws Exception;
}
