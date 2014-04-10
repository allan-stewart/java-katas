package com.github.allan.stewart.kata.permutations;

public class StringBuilderPermutationHandler implements PermutationHandler {
    private StringBuilder builder;

    public StringBuilderPermutationHandler() {
        builder = new StringBuilder();
    }

    @Override
    public void process(String permutation) {
        builder.append(permutation);
        builder.append("\n");
    }

    public String getOutput() {
        return builder.toString();
    }
}
