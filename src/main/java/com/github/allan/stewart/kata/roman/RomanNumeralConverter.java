package com.github.allan.stewart.kata.roman;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {
    private static final Map<Integer, String> map;
    private static final Map<String, Integer> mapToInt;
    static {
        map = new LinkedHashMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        mapToInt = new LinkedHashMap<String, Integer>();
        mapToInt.put("M", 1000);
        mapToInt.put("CM", 900);
        mapToInt.put("D", 500);
        mapToInt.put("CD", 400);
        mapToInt.put("C", 100);
        mapToInt.put("XC", 90);
        mapToInt.put("L", 50);
        mapToInt.put("XL", 40);
        mapToInt.put("X", 10);
        mapToInt.put("IX", 9);
        mapToInt.put("V", 5);
        mapToInt.put("IV", 4);
        mapToInt.put("I", 1);
    }

    public static String intToRoman(int input) {
        int remaining = input;
        StringBuilder output = new StringBuilder();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> numeral = (Map.Entry)iterator.next();
            while (remaining >= numeral.getKey()) {
                output.append(numeral.getValue());
                remaining -= numeral.getKey();
            }
        }

        return output.toString();
    }

    public static int romanToInt(String input) {
        int value = 0;
        int index = 0;

        Iterator iterator = mapToInt.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> numeral = (Map.Entry)iterator.next();
            while (getSubstring(input, index, numeral).equals(numeral.getKey())) {
                value += numeral.getValue();
                index += numeral.getKey().length();
            }
        }

        return value;
    }

    private static String getSubstring(String input, int startIndex, Map.Entry<String, Integer> numeral) {
        return input.substring(startIndex, Math.min(startIndex + numeral.getKey().length(), input.length()));
    }
}
