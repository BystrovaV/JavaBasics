package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder

        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = scanner.nextInt();
        int numberOfPieces = scanner.nextInt();

        int numberOfPizza = 0;
        int currentNumberOfPieces = 0;

        do {
            currentNumberOfPieces += numberOfPieces;
            numberOfPizza++;

        } while(currentNumberOfPieces % numberOfPeople != 0);

        System.out.print(numberOfPizza);
    }
}
