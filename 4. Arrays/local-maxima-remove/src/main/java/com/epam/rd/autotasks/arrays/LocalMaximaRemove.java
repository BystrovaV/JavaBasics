package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){

        boolean[] isLocal = new boolean[array.length];
        int sizeWithoutLocal = array.length;

        if (array[0] > array[1]) {
            isLocal[0] = true;
            sizeWithoutLocal--;
        }
        else {
            isLocal[0] = false;
        }

        if (array[array.length - 1] > array[array.length - 2]) {
            isLocal[array.length - 1] = true;
            sizeWithoutLocal--;
        }
        else {
            isLocal[array.length - 1] = false;
        }

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                isLocal[i] = true;
                sizeWithoutLocal--;
            }
            else {
                isLocal[i] = false;
            }
        }

        int [] newArray = new int[sizeWithoutLocal];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (!isLocal[i]) {
                newArray[j] = array[i];
                j++;
            }
        }

        return newArray;
    }
}
