package roseindia.net;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCOnnectionExample {
        Connection connection = null;

        public JDBCCOnnectionExample() {
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                        System.out.println(e.toString());
                }
        }

        public Connection createConnection() {
                Connection con = null;
                if (connection != null) {
                        System.out.println("Cant create a connection");
                } else {
                        try {
                                con = DriverManager.getConnection(
                                                "jdbc:mysql://localhost:3306/login", "root",
                                                "naresh");
                                System.out.println("Connection created Successfully");
                                DatabaseMetaData dbMetaData = con.getMetaData();
                                ResultSet dbInfo = dbMetaData.getCatalogs();
                                System.out.println("Getting Concurrency of MetaData");
                                System.out.println(dbInfo.getConcurrency());
                        } catch (SQLException e) {
                                System.out.println(e.toString());
                        }
                }
                return con;
        }

        public static void main(String[] args) throws SQLException {
                JDBCCOnnectionExample jdbccOnnectionExample = new JDBCCOnnectionExample();
                Connection conn = jdbccOnnectionExample.createConnection();
                conn.close();
        }
}