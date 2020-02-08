package main.java.Profile;

import java.math.BigDecimal;

public class Financial {
    private int creditScore, income;

    private Financial(int creditScore, int income) {
        this.creditScore = creditScore;
        this.income = income;
    }

    public static final Financial of(int creditScore, int income) throws Exception {
        if(validCreditScore(creditScore) && validIncome(income)){
            return new Financial(creditScore, income);
        }else {
            throw new Exception("Bad bad bad");
        }
    }

    private static boolean validCreditScore(int creditScore){
        return 300 < creditScore && creditScore < 850;
    }

    private static boolean validIncome(int income){
        return income > 0;
    }
}
