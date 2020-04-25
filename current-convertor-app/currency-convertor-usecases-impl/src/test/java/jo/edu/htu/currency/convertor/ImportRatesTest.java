package jo.edu.htu.currency.convertor;

import jo.edu.htu.currency.model.ExchangeRateRepository;
import jo.edu.htu.currency.model.JDBCExchangeRateRepository;

import java.nio.file.Paths;

public class ImportRatesTest {

    public static void main(String[] args) {
        ExchangeRateRepository repository = new JDBCExchangeRateRepository();
        ImportRatesHandler importRatesHandler = new DefaultImportRatesHandler(repository);

        ImportRequest request = new ImportRequest(Paths.get(".", "table-i3-e.csv"));
        importRatesHandler.importRates(request);
    }
}
