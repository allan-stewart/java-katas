package com.github.allan.stewart.kata.roman;

import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

public class RomanNumeralConverter {
    private static final Map<Integer, String> map;
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
}
