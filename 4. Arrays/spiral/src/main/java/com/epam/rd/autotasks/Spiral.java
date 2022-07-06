package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] array = new int[rows][columns];

        int number = 1, maxValue = rows * columns;
        for (int k = 0; k < columns; k++) {
            array[0][k] = number;
            number++;
        }

        int currentColumnRight = columns - 1, currentRowBottom = rows - 1;
        int currentColumnLeft = 0, currentRowTop = 0;
        while (true) {
            // заполняем правый столбец
            for (int k = currentRowTop + 1; k <= currentRowBottom; k++) {
                array[k][currentColumnRight] = number;
                number++;
            }

            if (number > maxValue) {
                break;
            }

            // заполняем нижнию строку
            int reverseValue = number + currentColumnRight - 1 - currentColumnLeft;
            for (int k = currentColumnLeft; k < currentColumnRight; k++) {
                array[currentRowBottom][k] = reverseValue;
                reverseValue--;
                number++;
            }

            if (number > maxValue) {
                break;
            }

            // заполняем левый столбец
            reverseValue = number + currentRowBottom - 2 - currentRowTop ;
            for (int k = currentRowTop + 1; k < currentRowBottom; k++) {
                array[k][currentColumnLeft] = reverseValue;
                reverseValue--;
                number++;
            }

            if (number > maxValue) {
                break;
            }

            // заполняем верхнюю строку
            for (int k = currentColumnLeft + 1; k < currentColumnRight; k++) {
                array[currentRowTop + 1][k] = number;
                number++;
            }

            if (number > maxValue) {
                break;
            }

            currentColumnLeft++;
            currentColumnRight--;
            currentRowBottom--;
            currentRowTop++;
        }

        return array;
    }
}
