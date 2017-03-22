package com.crm.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(19.1);
        BigDecimal b2 = new BigDecimal(Double.valueOf(20));
        BigDecimal decimal =b1.divideToIntegralValue(b2);
        System.out.println("---"+decimal);
        int n=decimal.setScale(0, RoundingMode.HALF_DOWN).intValue();
        System.out.println("===="+n);
    }
}
