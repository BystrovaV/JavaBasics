package com.epam.rd.autotasks.meetanagent;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int password = scan.nextInt();

        if (PASSWORD == password) {
            System.out.print("Hello, Agent");
        }
        else {
            System.out.print("Access denied");
        }
    }
}
