package jo.edu.htu.currency.convertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;

public class BISGetRateHandler implements GetRateHandler {

    public static final int CURRENCY_INDEX = 2;
    public static final String CURRENCY_CODE_DELIM = ":";

    private Path path;

    public BISGetRateHandler(Path path) throws FileNotFoundException {
        if (path == null)
            throw new IllegalArgumentException("Null path");
        if (Files.notExists(path)) {
            throw new FileNotFoundException(path + " not found");
        }
        this.path = path;
    }

    @Override
    public GetRateResult getRate(GetRateRequest request) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            BigDecimal[] rates = findRates(request, reader);
            throwIfNotFound(request, rates);
            BigDecimal rate = calculateRateBasedOnUSD(rates);
            return new GetRateResult(rate);
        } catch (IOException e) {
            throw new BISException(e);
        }
    }

    private void throwIfNotFound(GetRateRequest request, BigDecimal[] rates) {
        if (rates[0] == null)
            throw new IllegalArgumentException("Unknown code from: " + request.getFrom());
        if (rates[1] == null)
            throw new IllegalArgumentException("Unknown code to: " + request.getTo());
    }

    private BigDecimal calculateRateBasedOnUSD(BigDecimal[] rates) {
        BigDecimal fromRate = rates[0];
        BigDecimal toRate = rates[1];
        BigDecimal rate = new BigDecimal(1.0 / fromRate.doubleValue());
        rate.setScale(toRate.scale(), RoundingMode.UP);
        rate = rate.multiply(toRate);
        return rate;
    }

    private BigDecimal[] findRates(GetRateRequest request, BufferedReader reader) throws IOException {
        BigDecimal[] rates = new BigDecimal[2];
        String line;
        while ((line = reader.readLine()) != null && !isBothFound(rates)) {
            String[] fields = line.split(",");
            if (!BISRecordUtility.isMonthlyRecord(fields))
                continue;
            processRecord(request, rates, fields);
        }
        return rates;
    }

    private boolean isBothFound(BigDecimal[] rates) {
        return rates[0] != null && rates[1] != null;
    }

    private void processRecord(GetRateRequest request, BigDecimal[] rates, String[] fields) {
        RateRecord record = mapFieldsToRecord(fields);
        String recordCurrency = record.getCurrency();

        if (recordCurrency.equals(request.getFrom())) {
            rates[0] = record.getRate();
        }
        if (recordCurrency.equals(request.getTo())) {
            rates[1] = record.getRate();
        }
    }

    private RateRecord mapFieldsToRecord(String[] fields) {
        String currency = fields[CURRENCY_INDEX].replace("\"", "").split(CURRENCY_CODE_DELIM)[0];
        String lastRate = fields[fields.length - 1];
        return new RateRecord(currency, new BigDecimal(lastRate));
    }

    private class RateRecord {
        private String currency;
        private BigDecimal rate;

        public RateRecord(String currency, BigDecimal rate) {
            this.currency = currency;
            this.rate = rate;
        }

        public String getCurrency() {
            return currency;
        }

        public BigDecimal getRate() {
            return rate;
        }
    }
}
