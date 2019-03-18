package main;
import java.sql.*;
import java.util.*;


public class BowlerDatabase extends BowlerData {
  private static final String ID = "\"id\" TEXT PRIMARY KEY";
  private static final String NAME = "\"name\" TEXT";
  private static final String EMAIL = "\"email\" TEXT";
  private final Connection db;
  private final String table;
  
  
  public BowlerDatabase(Connection db) throws SQLException {
    this(db, "bowlers");
  }
  
  public BowlerDatabase(Connection db, String table) throws SQLException {
    this.db = db;
    this.table = table;
    createTableIfNotExists();
  }
  
  
  @Override
  public BowlerData load() throws SQLException {
    String sql = String.format("SELECT * FROM \"\"", table);
    PreparedStatement s = db.prepareStatement(sql);
    ResultSet rows = s.executeQuery();
    while (rows.next()) {
      String id = rows.getString("id");
      String name = rows.getString("name");
      String email = rows.getString("email");
      Bowler bowler = new Bowler(id, name, email);
      put(bowler.name(), bowler);
    }
    return this;
  }

  @Override
  public void add(Bowler bowler) throws SQLException {
    String sql = String.format("INSERT OR REPLACE INTO \"%s\" (\"id\", \"name\", \"email\") VALUES (?, ?, ?)", table);
    PreparedStatement s = db.prepareStatement(sql);
    s.setString(0, bowler.id());
    s.setString(1, bowler.name());
    s.setString(2, bowler.email());
    s.executeUpdate();
    put(bowler.name(), bowler);
  }
  
  public List<Bowler> query(String query) throws SQLException {
    String sql = String.format("SELECT * FROM \"%s\" %s", table, query);
    PreparedStatement s = db.prepareStatement(sql);
    return query(s);
  }
  
  
  private void createTableIfNotExists() throws SQLException {
    String sql = String.format("CREATE TABLE IF NOT EXISTS \"%s\"(%s, %s, %s)", table, ID, NAME, EMAIL);
    PreparedStatement s = db.prepareStatement(sql);
    s.executeUpdate();
  }
  
  private static List<Bowler> query(PreparedStatement s) throws SQLException {
    List<Bowler> bowlers = new ArrayList<>();
    ResultSet rows = s.executeQuery();
    while (rows.next()) {
      String id = rows.getString("id");
      String name = rows.getString("name");
      String email = rows.getString("email");
      Bowler bowler = new Bowler(id, name, email);
      bowlers.add(bowler);
    }
    return bowlers;
  }
}
