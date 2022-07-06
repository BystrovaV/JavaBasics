package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int billTotal, numberOfFriends, partToPay;
        billTotal = scan.nextInt();
        numberOfFriends = scan.nextInt();

        if (billTotal < 0) {
            System.out.print("Bill total amount cannot be negative");
            return;
        }

        if (numberOfFriends <= 0) {
            System.out.print("Number of friends cannot be negative or zero");
            return;
        }

        billTotal += billTotal / 10;
        partToPay = billTotal / numberOfFriends;
        System.out.print(partToPay);
    }
}
