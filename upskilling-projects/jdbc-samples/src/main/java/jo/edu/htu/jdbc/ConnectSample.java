package jo.edu.htu.jdbc;

import java.sql.*;

public class ConnectSample {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/countries?serverTimezone=UTC";
        String username = "root";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getDatabaseProductName());
            System.out.println(metaData.getDatabaseMajorVersion());
            System.out.println(metaData.getDatabaseMinorVersion());

            try (Statement statement = connection.createStatement()) {
                String sql = "insert into countries (ctry_code,ctry_name,ctry_iso_code) " +
                        "values ('KSA','Kingdom of Saudi Arabia',682)";
                int updateCount = statement.executeUpdate(sql);// DDL, DML (insert update delete)
                System.out.println("total affected: " + updateCount);
            }
        }
    }
}
