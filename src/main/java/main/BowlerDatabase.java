package main;
import java.sql.*;


public class BowlerDatabase extends BowlerData {
  private static final String ID = "\"id\" TEXT PRIMARY KEY";
  private static final String NAME = "\"name\" TEXT";
  private static final String EMAIL = "\"email\" TEXT";
  private final Connection db;
  private final String table;
  
  
  public BowlerDatabase(Connection db) {
    this(db, "bowlers");
  }
  
  public BowlerDatabase(Connection db, String table) {
    this.db = db;
    this.table = table;
  }
  
  
  @Override
  public BowlerData load() throws SQLException {
    createTableIfNotExists();
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
  }
  
  
  private void createTableIfNotExists() throws SQLException {
    String sql = String.format("CREATE TABLE IF NOT EXISTS \"%s\"(%s, %s, %s)", table, ID, NAME, EMAIL);
    PreparedStatement s = db.prepareStatement(sql);
    s.executeUpdate();
  }
}
