package com.epam.rd.autotasks.max;

import java.util.Optional;
import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        Optional<int[]> optional = Optional.ofNullable(values);

        if (optional.isPresent() && values.length > 0) {
            int max = Integer.MIN_VALUE;
            for (int value : values) {

                max = Math.max(max, value);
            }

            return OptionalInt.of(max);
        }

        return OptionalInt.empty();
    }
}
