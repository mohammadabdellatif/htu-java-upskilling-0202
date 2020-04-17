package jo.edu.htu.currency.convertor;

// represent the case for "convert amount"
public interface ConvertAmountHandler {
    // given: currency from, currency to, amount
    // when: convert
    // then: converted amount, rate
    ConvertResult convert(ConvertRequest request);
}
