package com.github.allan.stewart.kata.roman;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralConverterTest {

    @Test
    public void primary_numerals() {
        Assert.assertEquals("I", RomanNumeralConverter.intToRoman(1));
        Assert.assertEquals("V", RomanNumeralConverter.intToRoman(5));
        Assert.assertEquals("X", RomanNumeralConverter.intToRoman(10));
        Assert.assertEquals("L", RomanNumeralConverter.intToRoman(50));
        Assert.assertEquals("C", RomanNumeralConverter.intToRoman(100));
        Assert.assertEquals("D", RomanNumeralConverter.intToRoman(500));
        Assert.assertEquals("M", RomanNumeralConverter.intToRoman(1000));
    }

    @Test
    public void additive() {
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
    public void subtractive() {
        Assert.assertEquals("IV", RomanNumeralConverter.intToRoman(4));
        Assert.assertEquals("IX", RomanNumeralConverter.intToRoman(9));
        Assert.assertEquals("XL", RomanNumeralConverter.intToRoman(40));
        Assert.assertEquals("XC", RomanNumeralConverter.intToRoman(90));
        Assert.assertEquals("CD", RomanNumeralConverter.intToRoman(400));
        Assert.assertEquals("CM", RomanNumeralConverter.intToRoman(900));
    }

    @Test
    public void combinations() {
        Assert.assertEquals("MMXIV", RomanNumeralConverter.intToRoman(2014));
        Assert.assertEquals("MMDCCCLXXVII", RomanNumeralConverter.intToRoman(2877));
    }
}
