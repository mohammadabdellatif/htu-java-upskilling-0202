package jo.edu.htu.currency.convertor;

public interface GetRateHandler {
    // given: currency from, currency to
    // when: getRate
    // then: Rate

    GetRateResult getRate(GetRateRequest request);
}
