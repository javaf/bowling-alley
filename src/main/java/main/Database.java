package main;
import java.sql.*;


public class Database {
  private static Connection connection;
  
  public static Connection connection() throws SQLException {
    return connection!=null? connection : (connection = connection("jdbc:sqlite:test.db"));
  }
  

  private static Connection connection(String url) throws SQLException {
    return DriverManager.getConnection(url);
  }
}
