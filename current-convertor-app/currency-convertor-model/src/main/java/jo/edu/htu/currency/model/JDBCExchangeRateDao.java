package jo.edu.htu.currency.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class JDBCExchangeRateDao implements ExchangeRateDao {

    @Override
    public void insert(ExchangeRateTO exchangeRateTO) {
        String url = "jdbc:mysql://localhost:3306/countries?serverTimezone=UTC";
        String username = "root";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (Statement statement = connection.createStatement()) {
                String sql = "insert into exchange_rates (code, rate)" +
                        " values ('" + exchangeRateTO.getToCode()+"',"+exchangeRateTO.getRate().doubleValue()+")";
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(ExchangeRateTO exchangeRateTO) {

    }

    @Override
    public void delete(String toCode) {

    }

    @Override
    public List<ExchangeRateTO> listAllRates() {
        return null;
    }
}
