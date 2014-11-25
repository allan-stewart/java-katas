package com.github.allan.stewart.kata.roman;

import java.util.ArrayList;

public class RomanNumeralConverter {
    private static final ArrayList<Numeral> numerals;
    static {
        numerals = new ArrayList<Numeral>();
        numerals.add(new Numeral("M", 1000));
        numerals.add(new Numeral("CM", 900));
        numerals.add(new Numeral("D", 500));
        numerals.add(new Numeral("CD", 400));
        numerals.add(new Numeral("C", 100));
        numerals.add(new Numeral("XC", 90));
        numerals.add(new Numeral("L", 50));
        numerals.add(new Numeral("XL", 40));
        numerals.add(new Numeral("X", 10));
        numerals.add(new Numeral("IX", 9));
        numerals.add(new Numeral("V", 5));
        numerals.add(new Numeral("IV", 4));
        numerals.add(new Numeral("I", 1));
    }

    public static String intToRoman(int input) {
        int remaining = input;
        StringBuilder output = new StringBuilder();
        for (Numeral numeral : numerals) {
            while (remaining >= numeral.getValue()) {
                output.append(numeral.getSymbol());
                remaining -= numeral.getValue();
            }
        }
        return output.toString();
    }

    public static int romanToInt(String input) {
        int value = 0;
        int index = 0;
        for (Numeral numeral : numerals) {
            while (getSubstring(input, index, numeral).equals(numeral.getSymbol())) {
                value += numeral.getValue();
                index += numeral.getSymbol().length();
            }
        }
        return value;
    }

    private static String getSubstring(String input, int startIndex, Numeral numeral) {
        return input.substring(startIndex, Math.min(startIndex + numeral.getSymbol().length(), input.length()));
    }


    private static class Numeral {
        private String symbol;
        private int value;

        public Numeral(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }

        public String getSymbol() {
            return symbol;
        }

        public int getValue() {
            return value;
        }
    }
}
