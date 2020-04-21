package jo.edu.htu.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSample {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/htu_students2?createDatabaseIfNotExist=true&serverTimezone=UTC";
        // String url = "jdbc:oracle:thin:@localhost:1521:XE";
        // String url = "jdbc:h2://localhost:3307/students
        String username = "root";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getDatabaseProductName());
            System.out.println(metaData.getDatabaseMajorVersion());
            System.out.println(metaData.getDatabaseMinorVersion());
        }
    }
}
