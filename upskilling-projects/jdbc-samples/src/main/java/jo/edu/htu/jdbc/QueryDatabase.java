package jo.edu.htu.jdbc;

import java.sql.*;

public class QueryDatabase {

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
                String sql = "select ctry_code code,ctry_name name,ctry_iso_code " +
                        "from countries where ctry_code = 'JOR'";
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        String code = resultSet.getString(1);// by index (starting from 1)
                        String name = resultSet.getString("name"); // by alias
                        int isoCode = resultSet.getInt("ctry_iso_code");// by name
                        System.out.println(String.join(",", code, name, "" + isoCode));
                    }
                }
            }
        }
    }
}
