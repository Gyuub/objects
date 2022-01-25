package domain.policy.addition;

import domain.Money;

public class TaxablePolicy extends AdditionPolicy{

    private double taxRate;

    public TaxablePolicy(FeePolicy feePolicy, double taxRate) {
        super(feePolicy);
        this.taxRate = taxRate;
    }

    @Override
    public Money afterCalculate(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
