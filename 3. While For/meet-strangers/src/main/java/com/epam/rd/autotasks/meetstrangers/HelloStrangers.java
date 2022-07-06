package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        Scanner scan = new Scanner(System.in);

        int numberOfStrangers = scan.nextInt();

        scan.nextLine();
        if (numberOfStrangers == 0) {
            System.out.print("Oh, it looks like there is no one here");
        }
        else if (numberOfStrangers < 0) {
            System.out.print("Seriously? Why so negative?");
        }
        else {
            for (int i = 0; i < numberOfStrangers; i++) {
                String stranger = scan.nextLine();
                System.out.println("Hello, " + stranger);
            }
        }
    }
}
