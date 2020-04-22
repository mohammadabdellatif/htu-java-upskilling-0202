package jo.edu.htu.jdbc;

import java.sql.*;
import java.util.Scanner;

public class QueryDatabase2 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/countries?serverTimezone=UTC";
        String username = "root";
        String password = "root";
        Scanner scanner = new Scanner(System.in);
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (Statement statement = connection.createStatement()) {
                while (true) {
                    System.out.print("mysql>");
                    String sql = scanner.nextLine();
                    if("exit".equalsIgnoreCase(sql)){
                        break;
                    }
                    boolean query = statement.execute(sql);// general execute method
                    if (query) {
                        try (ResultSet resultSet = statement.getResultSet()) {
                            displayResultSet(resultSet);
                        }
                    } else {
                        int updateCount = statement.getUpdateCount();
                        System.out.println("total updated records: " + updateCount);
                    }
                }
            }
        }
    }

    private static void displayResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(metaData.getColumnLabel(i) + "|");
        }
        System.out.println("");
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getString(i) + "|");
            }
            System.out.println();
        }
    }
}
