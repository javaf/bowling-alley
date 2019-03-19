package main;
import java.sql.*;
import java.util.*;


public class ScoreDatabase extends RecordData {
  private static final String ID = "\"id\" TEXT";
  private static final String DATE = "\"date\" TEXT";
  private static final String VALUE = "\"value\" TEXT";
  private final Connection db;
  private final String table;
  
  
  public ScoreDatabase(Connection db) {
    this(db, "scores");
  }
  
  public ScoreDatabase(Connection db, String table) {
    this.db = db;
    this.table = table;
    try { createTableIfNotExists(); }
    catch (SQLException e) {}
  }
  
  @Override
  public void add(Record score) throws SQLException {
    String sql = String.format("INSERT INTO \"%s\" (\"id\", \"date\", \"value\") VALUES (?, ?, ?)", table);
    PreparedStatement s = db.prepareStatement(sql);
    s.setString(0, score.id());
    s.setString(1, score.date());
    s.setInt(2, score.score());
    s.executeUpdate();
  }

  @Override
  public List<Record> get(String id) throws SQLException {
    String sql = String.format("SELECT * FROM \"%s\" WHERE \"id\"=?", table);
    PreparedStatement s = db.prepareStatement(sql);
    s.setString(0, id);
    return query(s);
  }
  
  public List<Record> query(String query) throws SQLException {
    String sql = String.format("SELECT * FROM \"%s\" %s", table, query);
    PreparedStatement s = db.prepareStatement(sql);
    return query(s);
  }
  
  
  private void createTableIfNotExists() throws SQLException {
    String sql = String.format("CREATE TABLE \"%s\" IF NOT EXISTS (%s, %s, %s)", table, ID, DATE, VALUE);
    PreparedStatement s = db.prepareStatement(sql);
    s.executeUpdate();
  }
  
  private static List<Record> query(PreparedStatement s) throws SQLException {
    List<Record> scores = new ArrayList<>();
    ResultSet rows = s.executeQuery();
    while (rows.next()) {
      String id = rows.getString("id");
      String date = rows.getString("date");
      int value = rows.getInt("value");
      Record score = new Record(id, date, value);
      scores.add(score);
    }
    return scores;
  }
}
