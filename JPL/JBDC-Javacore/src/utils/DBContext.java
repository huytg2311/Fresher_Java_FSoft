//package utils;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBContext {
//
//    private static final String url = "jdbc:mysql://localhost:3306/jbdc_javacore";
//    private static final String user = "root";
//    private static final String pass = "huytg2311";
//
//    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        return DriverManager.getConnection(url, user, pass);
//    }
//
//    public static void main(String[] args) {
//        try {
//            System.out.println(DBContext.getConnection());
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
