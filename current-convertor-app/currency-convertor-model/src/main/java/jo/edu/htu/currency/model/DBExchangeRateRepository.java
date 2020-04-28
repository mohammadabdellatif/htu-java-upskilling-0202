package jo.edu.htu.currency.model;

import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

// statement -> compiled
// prepared statement -> pre-compiled
public class DBExchangeRateRepository implements ExchangeRateRepository {
    private static final String QUERY_ALL_RATES = "select to_code, rate from exchange_rates";
    private static final String INSERT_RATE_SQL = "insert into exchange_rates (to_code, rate) values(?,?)";
    private static final String QUERY_BY_CODE = "select rate from exchange_rates where to_code = ?";
    private static final String UPDATE_RATE = "update exchange_rates set rate = ? where to_code = ?";

    private DataSource dataSource;

    public DBExchangeRateRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Iterable<ExchangeRateTO> rates) {
//        insertAll(rates);
        insertUsingBatch(rates);
    }

    private void insertAll(Iterable<ExchangeRateTO> rates) {
        try (Connection connection = dataSource.getConnection()) {
            for (ExchangeRateTO rate : rates) {
                try (PreparedStatement statement = connection.prepareStatement(INSERT_RATE_SQL)) {
                    statement.setString(1, rate.getToCode());
                    statement.setBigDecimal(2, rate.getRate());
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private void insertUsingBatch(Iterable<ExchangeRateTO> rates) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT_RATE_SQL)) {
                for (ExchangeRateTO rate : rates) {
                    statement.setString(1, rate.getToCode());
                    statement.setBigDecimal(2, rate.getRate());
                    statement.addBatch();// batch the current parameters and prepare for new one
                }
                int[] batchResult = statement.executeBatch();
                System.out.println("number of executed statements: " + batchResult.length);
//                int batchStatus = batchResult[0];
//                if(batchStatus >= 0) {
//                    System.out.println("affected rows: " + batchStatus);
//                }
//                if(batchStatus == Statement.SUCCESS_NO_INFO) {
//                    System.out.println("statement executed successfully, without affecting rows");
//                }
//                if(batchStatus == Statement.EXECUTE_FAILED) {
//                    System.out.println("statement was failed: ");
//                }
            }
        } catch (BatchUpdateException e) {
            // same as array described above
            int[] updateCounts = e.getUpdateCounts();
            throw new DaoException(e);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(ExchangeRateTO exchangeRateTO) {
        try (Connection connection = dataSource.getConnection()) {
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
    public void update(ExchangeRateTO exchangeRateTO) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(UPDATE_RATE)) {
                statement.setBigDecimal(1, exchangeRateTO.getRate());
                statement.setString(2, exchangeRateTO.getToCode());
                int updated = statement.executeUpdate();
                if (updated == 0) {
                    throw new RecordNotFoundException("No rows where updated: " + exchangeRateTO.getToCode());
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public ExchangeRateTO findRateByToCode(String code) {
        try (Connection connection = dataSource.getConnection()) {
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
        try (Connection connection = dataSource.getConnection()) {
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


}
