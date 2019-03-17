package main;
import java.sql.*;


public class Test {
  public static void connect() {
    String url = "jdbc:sqlite:test.db";
    try (Connection db = DriverManager.getConnection(url)) {
    }
    catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
