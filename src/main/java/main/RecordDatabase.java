package main;
import java.sql.*;
import java.util.*;


public class RecordDatabase extends RecordData {
  private static final String TABLE = "records";
  private static final String ID = "\"id\" TEXT";
  private static final String DATE = "\"date\" TEXT";
  private static final String VALUE = "\"value\" TEXT";
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
    String sql = String.format("INSERT INTO \"%s\" (\"id\", \"date\", \"value\") VALUES (?, ?, ?)", table);
    PreparedStatement s = db.prepareStatement(sql);
    s.setString(0, record.id());
    s.setString(1, record.date());
    s.setInt(2, record.score());
    s.executeUpdate();
  }

  @Override
  public List<Record> get(String id) throws SQLException {
    String sql = String.format("SELECT * FROM \"%s\" WHERE \"id\"=?", table);
    PreparedStatement s = db.prepareStatement(sql);
    s.setString(0, id);
    return queryRecords(s);
  }
  
  @Override
  public List<Record> query(String query) throws SQLException {
    String sql = String.format("SELECT * FROM \"%s\" %s", table, query);
    PreparedStatement s = db.prepareStatement(sql);
    return queryRecords(s);
  }
  
  
  private void createTableIfNotExists() throws SQLException {
    String sql = String.format("CREATE TABLE \"%s\" IF NOT EXISTS (%s, %s, %s)", table, ID, DATE, VALUE);
    PreparedStatement s = db.prepareStatement(sql);
    s.executeUpdate();
  }
  
  private static List<Record> queryRecords(PreparedStatement s) throws SQLException {
    List<Record> reocrds = new ArrayList<>();
    ResultSet rows = s.executeQuery();
    while (rows.next()) {
      String id = rows.getString("id");
      String date = rows.getString("date");
      int value = rows.getInt("value");
      Record record = new Record(id, date, value);
      reocrds.add(record);
    }
    return reocrds;
  }
}
