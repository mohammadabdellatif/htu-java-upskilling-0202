package jo.edu.htu.currency.convertor;

import jo.edu.htu.currency.model.ExchangeRateRepository;
import jo.edu.htu.currency.model.ExchangeRateTO;
import jo.edu.htu.currency.model.RecordNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class DefaultImportRatesHandler implements ImportRatesHandler {

    public static final int CURRENCY_TO_FIELD = 2;
    public static final int CURRENCY_CODE_INDEX = 0;
    private ExchangeRateRepository repository;

    public DefaultImportRatesHandler(ExchangeRateRepository repository) {
        this.repository = repository;
    }

    @Override
    public void importRates(ImportRequest request) {
        Path filePath = request.getFilePath();
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (!BISRecordUtility.isMonthlyRecord(fields))
                    continue;
                processRecord(fields);
            }
        } catch (IOException e) {
            throw new ImportException(e);
        }
    }

    private void processRecord(String[] fields) {
        ExchangeRateTO rateTO = getFieldsAsTO(fields);
        try {
            System.out.println("update " + rateTO);
            repository.update(rateTO);
        } catch (RecordNotFoundException e) {
            System.out.println("insert " + rateTO);
            repository.insert(rateTO);
        }
    }

    private ExchangeRateTO getFieldsAsTO(String[] fields) {
        ExchangeRateTO rateTO = new ExchangeRateTO();
        String toCode = fields[CURRENCY_TO_FIELD].split(":")[CURRENCY_CODE_INDEX];
        rateTO.setToCode(toCode.replace("\"", ""));
        rateTO.setRate(new BigDecimal(fields[fields.length - 1]));
        return rateTO;
    }
}
