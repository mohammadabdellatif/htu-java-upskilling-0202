package jo.edu.htu.currency.model;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
// statement -> compiled
// prepared statement -> pre-compiled
public class JDBCExchangeRateRepository implements ExchangeRateRepository {
    private static final String QUERY_ALL_RATES = "select to_code, rate from exchange_rates";
    private static final String INSERT_RATE_SQL = "insert into exchange_rates (to_code, rate) values(?,?)";
    private static final String QUERY_BY_CODE = "select rate from exchange_rates where to_code = ?";

    @Override
    public void insert(ExchangeRateTO exchangeRateTO) {
        try (Connection connection = getConnection()) {
            // parameterized
            try (PreparedStatement statement = connection.prepareStatement(INSERT_RATE_SQL)) {
                statement.setString(1, exchangeRateTO.getToCode());
                statement.setBigDecimal(2, exchangeRateTO.getRate());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public ExchangeRateTO findRateByToCode(String code) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_BY_CODE)) {
                preparedStatement.setString(1, code);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        ExchangeRateTO rateTO = new ExchangeRateTO();
                        rateTO.setRate(resultSet.getBigDecimal("rate"));
                        rateTO.setToCode(code);
                        return rateTO;
                    }
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<ExchangeRateTO> listAllRates() {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(QUERY_ALL_RATES)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<ExchangeRateTO> rates = new LinkedList<>();
                    while (resultSet.next()) {
                        ExchangeRateTO to = new ExchangeRateTO();
                        to.setToCode(resultSet.getString("to_code"));
                        to.setRate(resultSet.getBigDecimal("rate"));
                        rates.add(to);
                    }
                    return rates;
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/countries?serverTimezone=UTC";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }
}
