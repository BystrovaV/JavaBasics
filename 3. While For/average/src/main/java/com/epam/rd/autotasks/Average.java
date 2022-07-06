package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int average = 0, number = 0, current;

        do {
            current = scanner.nextInt();
            if (current == 0) {
                break;
            }

            average += current;
            number++;
        } while (true);

        average /= number;
        System.out.print(average);
    }

}