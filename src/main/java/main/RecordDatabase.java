package main;
import java.sql.*;
import java.util.*;


public class RecordDatabase extends RecordData {
  private static final String TABLE = "records";
  private static final String ID = "id";
  private static final String DATE = "date";
  private static final String SCORE = "score";
  private final Connection db;
  private final String table;
  
  
  public RecordDatabase(Connection db) throws SQLException {
    this(db, TABLE);
  }
  
  public RecordDatabase(Connection db, String table) throws SQLException {
    this.db = db;
    this.table = table;
    createTableIfNotExists();
  }
  
  @Override
  public void add(Record record) throws SQLException {
    String sql = String.format("INSERT INTO \"%s\" (\"%s\", \"%s\", \"%s\") VALUES (?, ?, ?)", table, ID, DATE, SCORE);
    PreparedStatement s = db.prepareStatement(sql);
    s.setString(1, record.id());
    s.setString(2, record.date());
    s.setInt(3, record.score());
    s.executeUpdate();
  }

  @Override
  public List<Record> get(String id) throws SQLException {
    String sql = String.format("SELECT * FROM \"%s\" WHERE \"%s\"=?", table, ID);
    PreparedStatement s = db.prepareStatement(sql);
    s.setString(1, id);
    return queryRecords(s);
  }
  
  @Override
  public List<Record> query(String query) throws SQLException {
    String sql = String.format("SELECT * FROM \"%s\" %s", table, query);
    PreparedStatement s = db.prepareStatement(sql);
    return queryRecords(s);
  }
  
  
  private void createTableIfNotExists() throws SQLException {
    String sql = String.format("CREATE TABLE IF NOT EXISTS \"%s\" (\"%s\" TEXT, \"%s\" TEXT, \"%s\" INT)", table, ID, DATE, SCORE);
    PreparedStatement s = db.prepareStatement(sql);
    s.executeUpdate();
  }
  
  private static List<Record> queryRecords(PreparedStatement s) throws SQLException {
    List<Record> reocrds = new ArrayList<>();
    ResultSet rows = s.executeQuery();
    while (rows.next()) {
      String id = rows.getString(ID);
      String date = rows.getString(DATE);
      int score = rows.getInt(SCORE);
      Record record = new Record(id, date, score);
      reocrds.add(record);
    }
    return reocrds;
  }
}
