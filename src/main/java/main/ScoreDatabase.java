package main;
import java.sql.*;
import java.util.*;


public class ScoreDatabase extends ScoreData {
  private static final String ID = "\"id\" TEXT";
  private static final String DATE = "\"date\" TEXT";
  private static final String VALUE = "\"value\" TEXT";
  private final Connection db;
  private final String table;
  
  
  public ScoreDatabase(Connection db) throws SQLException {
    this(db, "scores");
  }
  
  public ScoreDatabase(Connection db, String table) throws SQLException {
    this.db = db;
    this.table = table;
    createTableIfNotExists();
  }
  
  @Override
  public void add(Score score) throws SQLException {
    String sql = String.format("INSERT INTO \"%s\" (\"id\", \"date\", \"value\") VALUES (?, ?, ?)", table);
    PreparedStatement s = db.prepareStatement(sql);
    s.setString(0, score.id());
    s.setString(1, score.date());
    s.setInt(2, score.value());
    s.executeUpdate();
  }

  @Override
  public List<Score> get(String id) throws SQLException {
    String sql = String.format("SELECT * FROM \"%s\" WHERE \"id\"=?", table);
    PreparedStatement s = db.prepareStatement(sql);
    s.setString(0, id);
    return query(s);
  }
  
  public List<Score> query(String query) throws SQLException {
    String sql = String.format("SELECT * FROM \"%s\" %s", table, query);
    PreparedStatement s = db.prepareStatement(sql);
    return query(s);
  }
  
  
  private void createTableIfNotExists() throws SQLException {
    String sql = String.format("CREATE TABLE \"%s\" IF NOT EXISTS (%s, %s, %s)", table, ID, DATE, VALUE);
    PreparedStatement s = db.prepareStatement(sql);
    s.executeUpdate();
  }
  
  private static List<Score> query(PreparedStatement s) throws SQLException {
    List<Score> scores = new ArrayList<>();
    ResultSet rows = s.executeQuery();
    while (rows.next()) {
      String id = rows.getString("id");
      String date = rows.getString("date");
      int value = rows.getInt("value");
      Score score = new Score(id, date, value);
      scores.add(score);
    }
    return scores;
  }
}
