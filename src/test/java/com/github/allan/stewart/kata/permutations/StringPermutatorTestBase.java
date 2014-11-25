package com.github.allan.stewart.kata.permutations;

import org.junit.Assert;
import org.junit.Test;

public class StringPermutatorTestBase {
    protected StringPermutator permutator;

    private void testPermutations(String input, String expected) {
        StringBuilderPermutationHandler handler = new StringBuilderPermutationHandler();
        permutator.getPermutations(input, handler);
        Assert.assertEquals(expected, handler.getOutput());
    }

    @Test
    public void emptyString() {
        testPermutations("", "");
    }

    @Test
    public void oneCharacter() {
        testPermutations("a", "a\n");
    }

    @Test
    public void twoCharacters() {
        testPermutations("ab", "ab\nba\n");
    }

    @Test
    public void threeCharacters() {
        testPermutations("cat", "act\natc\ncat\ncta\ntac\ntca\n");
    }

    @Test
    public void fourCharacters() {
        testPermutations("dogs", "dgos\ndgso\ndogs\ndosg\ndsgo\ndsog\n" +
                                 "gdos\ngdso\ngods\ngosd\ngsdo\ngsod\n" +
                                 "odgs\nodsg\nogds\nogsd\nosdg\nosgd\n" +
                                 "sdgo\nsdog\nsgdo\nsgod\nsodg\nsogd\n");
    }

    @Test
    public void speedTest() {
        String input = "alphabetical";
        long duration = 0;
        long start = 0;
        long end = 0;
        long threshold = 100;
        NoOpPermutationHandler handler = new NoOpPermutationHandler();
        String name = permutator.getClass().getSimpleName() + ' ';

        for (int length = 5; length <= 12; length++) {
            start = System.currentTimeMillis();
            permutator.getPermutations(input.substring(0, length), handler);
            end = System.currentTimeMillis();
            duration = end-start;

            System.out.println(name + length + "! = " + duration + "ms.");

            if (duration >= threshold) {
                return;
            }
        }
    }
}
