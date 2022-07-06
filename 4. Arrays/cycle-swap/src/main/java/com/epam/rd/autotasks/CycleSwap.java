package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length == 0) {
            return;
        }
        int lastElement = array[array.length - 1];
        int [] copyArray = new int[array.length];
        copyArray[0] = lastElement;
        System.arraycopy(array, 0, copyArray, 1, array.length - 1);

        System.arraycopy(copyArray, 0, array, 0, copyArray.length);

    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length == 0) {
            return;
        }
        int [] copyArray = new int[array.length];
        System.arraycopy(array, array.length - shift, copyArray, 0, shift);

        System.arraycopy(array, 0, copyArray, shift, array.length - shift);

        System.arraycopy(copyArray, 0, array, 0, copyArray.length);
    }
}
