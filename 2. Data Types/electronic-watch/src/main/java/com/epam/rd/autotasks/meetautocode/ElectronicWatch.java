package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        int hours = seconds / 3600;
        String hoursString = (hours == 24) ? "0" : String.valueOf(hours);
        seconds = seconds % 3600;
        int minutes = seconds / 60;
        String minutesString = (minutes < 10) ? "0" + minutes : String.valueOf(minutes);
        seconds = seconds % 60;
        String secondsString = (seconds < 10) ? "0" + seconds : String.valueOf(seconds);
        System.out.print( hoursString + ":" + minutesString + ":" + secondsString);
    }
}
