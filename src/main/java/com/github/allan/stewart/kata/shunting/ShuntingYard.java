package com.github.allan.stewart.kata.shunting;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShuntingYard {
    public static String[] tokenize(String input) {
        String[] tokens = input.split("\\s+");
        for (String token : tokens) {
            if (!isOperator(token) && !isDigit(token)) {
                throw new IllegalArgumentException();
            }
        }
        return tokens;
    }

    public static boolean isOperator(String operator) {
        return operator.matches("[+\\-*()/%]");
    }

    public static boolean isDigit(String digit) {
        return digit.matches("[0123456789]+");
    }

    public static List<String> infixToReversePolish(String input) {
        String[] tokens = tokenize(input);
        List<String> output = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();

        for (String token : tokens) {
            if (isOperator(token)) {
                while (shouldPopOperator(stack, token)) {
                    output.add(stack.pop());
                }
                if (!token.equals(")")) {
                    stack.push(token);
                }
            } else {
                output.add(token);
            }
        }

        while (stack.size() > 0) {
            if (stack.peek().equals("(")) {
                throw new ArithmeticException();
            }
            output.add(stack.pop());
        }

        return output;
    }

    private static boolean shouldPopOperator(Stack<String> stack, String currentOperator) {
        if (currentOperator.equals("(")) {
            return false;
        }
        if (currentOperator.equals(")") && stack.size() > 0) {
            if (!stack.contains("(")) {
                throw new ArithmeticException();
            }
            if (stack.peek().equals("(")) {
                stack.pop();
                return false;
            }
            return true;
        }
        if (stack.size() > 0) {
            if (getOperatorPrecedence(currentOperator) <= getOperatorPrecedence(stack.peek())) {
                return true;
            }
        }
        return false;
    }

    public static int getOperatorPrecedence(String operator) {
        if (operator.matches("[*/%]")) {
            return 2;
        }
        if (operator.matches("[+\\-]")) {
            return 1;
        }
        return 0;
    }

    public static double calculateReversePolishNotation(List<String> rpn) {
        String token = rpn.remove(rpn.size() - 1);
        if (isDigit(token)) {
            return Double.parseDouble(token);
        }
        if (token.equals("/")) {
            double temp = calculateReversePolishNotation(rpn);
            return calculateReversePolishNotation(rpn) / temp;
        }
        if (token.equals("*")) {
            return calculateReversePolishNotation(rpn) * calculateReversePolishNotation(rpn);
        }
        if (token.equals("+")) {
            return calculateReversePolishNotation(rpn) + calculateReversePolishNotation(rpn);
        }
        if (token.equals("-")) {
            double temp = calculateReversePolishNotation(rpn);
            return calculateReversePolishNotation(rpn) - temp;
        }
        throw new RuntimeException("Unexpected operator: " + token);
    }
}
