package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {
        int max = Integer.MIN_VALUE;

        for (int element: values) {
            max = Math.max(element, max);
        }

        return max;
    }
}
