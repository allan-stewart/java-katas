package com.github.allan.stewart.kata.permutations;

import java.util.Arrays;

public class LinkedListRecursivePermutator implements StringPermutator {
    @Override
    public void getPermutations(String input, PermutationHandler handler) {
        if (input.length() == 0) {
            return;
        }
        Node permutation = new Node("");
        nextPermutation(buildLinkedList(input.toCharArray()), permutation, permutation, handler);
    }

    private Node buildLinkedList(char[] input) {
        Arrays.sort(input);

        Node root = null;
        Node current = null;
        Node last = null;
        for (int index = 0; index < input.length; index++) {
            current = new Node(input[index] + "", last);
            if (last != null) {
                last.next = current;
            }
            if (root == null) {
                root = current;
            }
            last = current;
        }
        return root;
    }

    private void nextPermutation(Node list, Node permutationStart, Node permutationEnd, PermutationHandler handler) {
        if (list == null) {
            buildPermutation(permutationStart, handler);
            return;
        }

        Node current = list;
        Node previous = null;
        Node next = null;
        Node sublist = list;
        while (current != null) {
            sublist = list == current ? current.next : list;
            previous = current.previous;
            next = current.next;

            if (previous != null) {
                previous.next = next;
            }
            if (next != null) {
                next.previous = previous;
            }
            current.previous = permutationEnd;
            current.next = null;
            permutationEnd.next = current;

            nextPermutation(sublist, permutationStart, current, handler);

            if (previous != null) {
                previous.next = current;
            }
            if (next != null) {
                next.previous = current;
            }
            current.previous = previous;
            current.next = next;

            current = current.next;
        }
    }

    private void buildPermutation(Node permutation, PermutationHandler handler) {
        StringBuilder builder = new StringBuilder();
        while (permutation != null) {
            builder.append(permutation.value);
            permutation = permutation.next;
        }
        handler.process(builder.toString());
    }

    class Node {
        public Node previous = null;
        public Node next = null;
        public String value;

        public Node(String value) {
            this.value = value;
        }

        public Node(String value, Node previous) {
            this.value = value;
            this.previous = previous;
        }
    }
}
