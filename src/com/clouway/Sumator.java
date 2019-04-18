package com.clouway;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Sumator {
    public Sumator() {
    }

    public int sum(int a, int b){
        return a+b;
    }
    
    public Double sum(double a, double b){
        return a+b;
    }

    public String sum(String a, String b){
        return String.valueOf(Double.parseDouble(a)+Double.parseDouble(b));
    }

    public BigInteger sum(BigInteger a , BigInteger b){
        return new BigInteger(String.valueOf(a)).add(b);
    }

    public BigDecimal sum(BigDecimal a, BigDecimal b){
        return new BigDecimal(String.valueOf(a)).add(b);
    }

    
    
    
}
