package jo.edu.htu.jdbc;

import java.sql.*;
import java.util.Scanner;

public class SQLConsole {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/countries?serverTimezone=UTC";
        String username = "root";
        String password = "root";
        Scanner scanner = new Scanner(System.in);
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            try (Statement statement = connection.createStatement()) {
                while (true) {
                    System.out.print("mysql>");
                    String sql = scanner.nextLine();
                    if (sql.endsWith(";"))
                        sql = sql.substring(0, sql.length() - 1);
                    if (sql.equalsIgnoreCase("commit")) {
                        connection.commit();// commit all changes to the database
                        continue;
                    }
                    if (sql.equalsIgnoreCase("rollback")) {
                        connection.rollback();
                        continue;
                    }
                    if ("exit".equalsIgnoreCase(sql)) {
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
