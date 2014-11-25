package com.github.allan.stewart.kata.roman;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralConverterTest {

    @Test
    public void intToRoman_primaryNumerals() {
        Assert.assertEquals("I", RomanNumeralConverter.intToRoman(1));
        Assert.assertEquals("V", RomanNumeralConverter.intToRoman(5));
        Assert.assertEquals("X", RomanNumeralConverter.intToRoman(10));
        Assert.assertEquals("L", RomanNumeralConverter.intToRoman(50));
        Assert.assertEquals("C", RomanNumeralConverter.intToRoman(100));
        Assert.assertEquals("D", RomanNumeralConverter.intToRoman(500));
        Assert.assertEquals("M", RomanNumeralConverter.intToRoman(1000));
    }

    @Test
    public void intToRoman_additive() {
        Assert.assertEquals("II", RomanNumeralConverter.intToRoman(2));
        Assert.assertEquals("III", RomanNumeralConverter.intToRoman(3));
        Assert.assertEquals("XX", RomanNumeralConverter.intToRoman(20));
        Assert.assertEquals("XXX", RomanNumeralConverter.intToRoman(30));
        Assert.assertEquals("CC", RomanNumeralConverter.intToRoman(200));
        Assert.assertEquals("CCC", RomanNumeralConverter.intToRoman(300));
        Assert.assertEquals("MM", RomanNumeralConverter.intToRoman(2000));
        Assert.assertEquals("MMM", RomanNumeralConverter.intToRoman(3000));
    }

    @Test
    public void intToRoman_subtractive() {
        Assert.assertEquals("IV", RomanNumeralConverter.intToRoman(4));
        Assert.assertEquals("IX", RomanNumeralConverter.intToRoman(9));
        Assert.assertEquals("XL", RomanNumeralConverter.intToRoman(40));
        Assert.assertEquals("XC", RomanNumeralConverter.intToRoman(90));
        Assert.assertEquals("CD", RomanNumeralConverter.intToRoman(400));
        Assert.assertEquals("CM", RomanNumeralConverter.intToRoman(900));
    }

    @Test
    public void intToRoman_combinations() {
        Assert.assertEquals("MMXIV", RomanNumeralConverter.intToRoman(2014));
        Assert.assertEquals("MMDCCCLXXVII", RomanNumeralConverter.intToRoman(2877));
    }

    @Test
    public void romanToInt_primaryNumerals() {
        Assert.assertEquals(1, RomanNumeralConverter.romanToInt("I"));
        Assert.assertEquals(5, RomanNumeralConverter.romanToInt("V"));
        Assert.assertEquals(10, RomanNumeralConverter.romanToInt("X"));
        Assert.assertEquals(50, RomanNumeralConverter.romanToInt("L"));
        Assert.assertEquals(100, RomanNumeralConverter.romanToInt("C"));
        Assert.assertEquals(500, RomanNumeralConverter.romanToInt("D"));
        Assert.assertEquals(1000, RomanNumeralConverter.romanToInt("M"));
    }

    @Test
    public void romanToInt_additive() {
        Assert.assertEquals(2, RomanNumeralConverter.romanToInt("II"));
        Assert.assertEquals(3, RomanNumeralConverter.romanToInt("III"));
        Assert.assertEquals(20, RomanNumeralConverter.romanToInt("XX"));
        Assert.assertEquals(30, RomanNumeralConverter.romanToInt("XXX"));
        Assert.assertEquals(200, RomanNumeralConverter.romanToInt("CC"));
        Assert.assertEquals(300, RomanNumeralConverter.romanToInt("CCC"));
        Assert.assertEquals(2000, RomanNumeralConverter.romanToInt("MM"));
        Assert.assertEquals(3000, RomanNumeralConverter.romanToInt("MMM"));
    }

    @Test
    public void romanToInt_subtractive() {
        Assert.assertEquals(4, RomanNumeralConverter.romanToInt("IV"));
        Assert.assertEquals(9, RomanNumeralConverter.romanToInt("IX"));
        Assert.assertEquals(40, RomanNumeralConverter.romanToInt("XL"));
        Assert.assertEquals(90, RomanNumeralConverter.romanToInt("XC"));
        Assert.assertEquals(400, RomanNumeralConverter.romanToInt("CD"));
        Assert.assertEquals(900, RomanNumeralConverter.romanToInt("CM"));
    }

    @Test
    public void romanToInt_combinations() {
        Assert.assertEquals(2014, RomanNumeralConverter.romanToInt("MMXIV"));
        Assert.assertEquals(2877, RomanNumeralConverter.romanToInt("MMDCCCLXXVII"));
    }
}
