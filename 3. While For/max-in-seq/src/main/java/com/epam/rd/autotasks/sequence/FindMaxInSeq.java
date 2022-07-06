package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner scan = new Scanner(System.in);
        int max = scan.nextInt(), current;

        do {
            current = scan.nextInt();
            if (current == 0) {
                break;
            }
            max = Math.max(current, max);
        } while (true);

        return max;
    }

    public static void main(String[] args) {

        //System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
