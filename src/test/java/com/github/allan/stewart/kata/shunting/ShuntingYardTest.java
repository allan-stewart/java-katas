package com.github.allan.stewart.kata.shunting;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ShuntingYardTest {

    private String testInput = "4 * ( 3 + 2 ) - 1";

    @Test
    public void tokenize_normalInput() {
        Assert.assertEquals(new String[] {"4", "*", "(", "3", "+", "2", ")", "-", "1"},
                ShuntingYard.tokenize(testInput));
    }

    @Test
    public void tokenize_withExtraSpaces() {
        Assert.assertEquals(new String[] {"1", "+", "2"},
                ShuntingYard.tokenize("1  + 2 "));
    }

    @Test
    public void tokenize_throwExceptionOnOperandsWithNonDigits() {
        try {
            ShuntingYard.tokenize("4 + ( 3 * 2a ) - 1");
        }
        catch (IllegalArgumentException exception) {
            return;
        }
        Assert.fail("Did not get exception.");
    }

    @Test
    public void isOperator() {
        Assert.assertTrue(ShuntingYard.isOperator("+"));
        Assert.assertTrue(ShuntingYard.isOperator("-"));
        Assert.assertTrue(ShuntingYard.isOperator("*"));
        Assert.assertTrue(ShuntingYard.isOperator("/"));
        Assert.assertTrue(ShuntingYard.isOperator("("));
        Assert.assertTrue(ShuntingYard.isOperator(")"));
        Assert.assertTrue(ShuntingYard.isOperator("*"));
        Assert.assertTrue(ShuntingYard.isOperator("%"));

        Assert.assertFalse(ShuntingYard.isOperator("1"));
        Assert.assertFalse(ShuntingYard.isOperator("a"));
    }

    @Test
    public void isDigit() {
        Assert.assertTrue(ShuntingYard.isDigit("0"));
        Assert.assertTrue(ShuntingYard.isDigit("1"));
        Assert.assertTrue(ShuntingYard.isDigit("2"));
        Assert.assertTrue(ShuntingYard.isDigit("3"));
        Assert.assertTrue(ShuntingYard.isDigit("4"));
        Assert.assertTrue(ShuntingYard.isDigit("5"));
        Assert.assertTrue(ShuntingYard.isDigit("6"));
        Assert.assertTrue(ShuntingYard.isDigit("7"));
        Assert.assertTrue(ShuntingYard.isDigit("8"));
        Assert.assertTrue(ShuntingYard.isDigit("9"));

        Assert.assertTrue(ShuntingYard.isDigit("12"));

        Assert.assertFalse(ShuntingYard.isDigit("2a"));
    }

    @Test
    public void getOperatorPrecedence() {
        Assert.assertEquals(1, ShuntingYard.getOperatorPrecedence("+"));
        Assert.assertEquals(1, ShuntingYard.getOperatorPrecedence("-"));

        Assert.assertEquals(2, ShuntingYard.getOperatorPrecedence("*"));
        Assert.assertEquals(2, ShuntingYard.getOperatorPrecedence("/"));
        Assert.assertEquals(2, ShuntingYard.getOperatorPrecedence("%"));

        Assert.assertEquals(0, ShuntingYard.getOperatorPrecedence("("));
        Assert.assertEquals(0, ShuntingYard.getOperatorPrecedence(")"));
    }

    @Test
    public void infixToReversePolish() {
        List<String> output = ShuntingYard.infixToReversePolish(testInput);
        Assert.assertEquals("4 3 2 + * 1 - ", join(output));
    }

    private String join(List<String> input) {
        StringBuilder builder = new StringBuilder();
        for (String item : input) {
            builder.append(item);
            builder.append(" ");
        }
        return builder.toString();
    }

    @Test
    public void infixToReversePolish_missingLeftParen_arithmeticException() {
        try {
            ShuntingYard.infixToReversePolish("4 + 3 * 2 ) - 1");
        }
        catch (ArithmeticException exception) {
            return;
        }
        Assert.fail("Did not get expected ArithmeticException");
    }

    @Test
    public void infixToReversePolish_missingRightParen_arithmeticException() {
        try {
            ShuntingYard.infixToReversePolish("4 + ( 3 * 2 - 1");
        }
        catch (ArithmeticException exception) {
            return;
        }
        Assert.fail("Did not get expected ArithmeticException");
    }

    @Test
    public void calculateReversePolishNotation() {
        List<String> rpn = ShuntingYard.infixToReversePolish(testInput);
        Assert.assertEquals(19.0, ShuntingYard.calculateReversePolishNotation(rpn), 0.001);

        Assert.assertEquals(9.0, ShuntingYard.calculateReversePolishNotation(ShuntingYard.infixToReversePolish("2 + 3 + 4")), 0.001);
        Assert.assertEquals(1.0, ShuntingYard.calculateReversePolishNotation(ShuntingYard.infixToReversePolish("2 + 3 - 4")), 0.001);

        Assert.assertEquals(14.0, ShuntingYard.calculateReversePolishNotation(ShuntingYard.infixToReversePolish("2 + 3 * 4")), 0.001);
        Assert.assertEquals(11.0, ShuntingYard.calculateReversePolishNotation(ShuntingYard.infixToReversePolish("2 + 3 * 4 - 6 / 2")), 0.001);

        Assert.assertEquals(20.0, ShuntingYard.calculateReversePolishNotation(ShuntingYard.infixToReversePolish("( 2 + 3 ) * 4")), 0.001);
        Assert.assertEquals(-5.0, ShuntingYard.calculateReversePolishNotation(ShuntingYard.infixToReversePolish("( 2 + 3 ) * ( 4 - 6 ) / 2")), 0.001);
    }
}
