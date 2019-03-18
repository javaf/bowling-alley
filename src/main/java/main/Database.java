package main;
import java.sql.*;


public class Database {
  private static Connection connection;
  
  public static Connection connection() {
    return connection!=null? connection : (connection = connect("jdbc:sqlite:test.db"));
  }
  

  private static Connection connect(String url) {
    try (Connection conn = DriverManager.getConnection(url)) { return conn; }
    catch (SQLException e) { return null; }
  }
}
