package com.github.allan.stewart.kata.permutations;

import java.util.Arrays;

public class BasicRecursivePermutator implements StringPermutator {
    @Override
    public void getPermutations(String input, PermutationHandler handler) {
        nextPermutation(alphabetize(input), "", handler);
    }

    private String alphabetize(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private void nextPermutation(String remaining, String permutation, PermutationHandler handler) {
        if (remaining.length() == 1) {
            handler.process(permutation + remaining);
            return;
        }

        for (int index = 0; index < remaining.length(); index++) {
            nextPermutation(removeCharacterAtIndex(remaining, index), permutation + remaining.charAt(index), handler);
        }
    }

    private String removeCharacterAtIndex(String input, int index) {
        if (index == 0) {
            return input.substring(1);
        }
        if (index == input.length() - 1) {
            return input.substring(0, input.length() - 1);
        }
        return input.substring(0, index) + input.substring(index + 1);
    }
}
