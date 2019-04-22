package com.clouway;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Sumator {
    public Sumator() {
    }

    /**
     * Sums a and b
     * @param a first number to sum
     * @param b second number to sum
     * @return a+b
     */
    public int sum(int a, int b){
        return a+b;
    }

    /**
     * Sums a and b
     * @param a first number to sum
     * @param b second number to sum
     * @return a+b
     */
    public Double sum(double a, double b){
        return a+b;
    }

    /**
     * Sums two string numbers
     * If one of them is null or empty sum returns the other one if its a number
     * If both numbers are null or empty or not numbers sum returns 0
     * @param a first string to sum
     * @param b second string to sum
     * @return sum if both strings are numbers
     */
    public String sum(String a, String b){
        if(a==null || a.equals("")){
            if(b==null || b.equals("")){
                return "0";
            } else {
                try {
                    Double.parseDouble(b);
                    return b;
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    return "0";
                }
            }
        } else if(b==null || b.equals("")) {
            try {
                Double.parseDouble(a);
                return a;
            } catch (NumberFormatException e){
                e.printStackTrace();
                return "0";
            }
        }

        try {
            return String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
        } catch (NumberFormatException e){
            e.printStackTrace();
            return "0";
        }
    }

    /**
     * Sums two big integers
     * @param a first number to sum
     * @param b second number to sum
     * @return a+b if both are numbers and not null
     */
    public BigInteger sum(BigInteger a , BigInteger b){
        try {
            return new BigInteger(String.valueOf(a)).add(b);
        } catch (NumberFormatException | NullPointerException e){
            e.printStackTrace();
            return BigInteger.valueOf(0);
        }
    }

    /**
     * Sums two big decimals
     * @param a first number to sum
     * @param b second number to sum
     * @return a+b if both are numbers and not null
     */
    public BigDecimal sum(BigDecimal a, BigDecimal b){
        try {
            return new BigDecimal(String.valueOf(a)).add(b);
        } catch (NumberFormatException | NullPointerException e){
            e.printStackTrace();
            return BigDecimal.valueOf(0);
        }
    }

    
    
    
}
