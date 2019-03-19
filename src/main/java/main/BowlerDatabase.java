package main;
import java.sql.*;
import java.util.*;


public class BowlerDatabase extends BowlerData {
  private static final String TABLE = "bowlers";
  private static final String ID = "id";
  private static final String NAME = "name";
  private static final String EMAIL = "email";
  private final Connection db;
  private final String table;
  
  
  public BowlerDatabase(Connection db) throws SQLException {
    this(db, TABLE);
  }
  
  public BowlerDatabase(Connection db, String table) throws SQLException {
    this.db = db;
    this.table = table;
    createTableIfNotExists();
    loadBowlers();
  }
  

  @Override
  public void add(Bowler bowler) throws SQLException {
    String sql = String.format("REPLACE INTO \"%s\" (\"%s\", \"%s\", \"%s\") VALUES (?, ?, ?)", table, ID, NAME, EMAIL);
    PreparedStatement s = db.prepareStatement(sql);
    s.setString(1, bowler.id());
    s.setString(2, bowler.name());
    s.setString(3, bowler.email());
    s.executeUpdate();
    put(bowler.name(), bowler);
  }
  
  public List<Bowler> query(String query) throws SQLException {
    String sql = String.format("SELECT * FROM \"%s\" %s", table, query);
    PreparedStatement s = db.prepareStatement(sql);
    return queryBowlers(s);
  }
  
  
  private void createTableIfNotExists() throws SQLException {
    String sql = String.format("CREATE TABLE IF NOT EXISTS \"%s\" (\"%s\" TEXT PRIMARY KEY, \"%s\" TEXT, \"%s\" TEXT)", table, ID, NAME, EMAIL);
    PreparedStatement s = db.prepareStatement(sql);
    s.executeUpdate();
  }

  private void loadBowlers() throws SQLException {
    String sql = String.format("SELECT * FROM \"%s\"", table);
    PreparedStatement s = db.prepareStatement(sql);
    ResultSet rows = s.executeQuery();
    while (rows.next()) {
      String id = rows.getString(ID);
      String name = rows.getString(NAME);
      String email = rows.getString(EMAIL);
      Bowler bowler = new Bowler(id, name, email);
      put(bowler.name(), bowler);
    }
  }
  
  private static List<Bowler> queryBowlers(PreparedStatement s) throws SQLException {
    List<Bowler> bowlers = new ArrayList<>();
    ResultSet rows = s.executeQuery();
    while (rows.next()) {
      String id = rows.getString(ID);
      String name = rows.getString(NAME);
      String email = rows.getString(EMAIL);
      Bowler bowler = new Bowler(id, name, email);
      bowlers.add(bowler);
    }
    return bowlers;
  }
}
