package by.epam.learn.fundamentals;

import java.util.Scanner;

public class RandomNumbers {
    public static void main(String[] args) {
        double rndNumbers[];

        Scanner in = new Scanner(System.in);
        System.out.print("Задайте количество случайных чисел: \n");
        int count = Integer.parseInt(in.nextLine());
        rndNumbers = new double[count];
        System.out.println();

        for(int i = 0; i < count; i++) {
            rndNumbers[i] = (double) Math.round(100 * Math.random()) / 100;
            System.out.println(rndNumbers[i] + "  ");
        }

        System.out.println();

        for(double j : rndNumbers) {
            System.out.print(j + "  ");
        }
    }
}


