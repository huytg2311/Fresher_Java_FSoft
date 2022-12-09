/**
 * @project SaleManagement
 */

package fa.training.dbconfig;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * author Duy Bach.
 * 
 * @time 2:28:26 PM
 * @date Jun 22, 2019
 */
public class DatabaseConnection {

  static DatabaseConnection instance;
  private Connection connection;

  public DatabaseConnection() {
    Properties properties = new Properties();
    try {
      properties.load(
          DatabaseConnection.class.getResourceAsStream("/dbInfo.properties"));

      String driver = properties.getProperty("driver");
      String url = properties.getProperty("url");
      String user = properties.getProperty("user");
      String pass = properties.getProperty("pass");

      Class.forName(driver);
      connection = DriverManager.getConnection(url, user, pass);

    } catch (IOException | SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public Connection getConnection() {
    return connection;
  }

  public static DatabaseConnection getInstance() throws SQLException {
    if (instance == null) {
      instance = new DatabaseConnection();
    } else if (instance.getConnection().isClosed())
      instance = new DatabaseConnection();
    return instance;
  }
}
