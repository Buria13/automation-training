package by.epam.learn.fundamentals.maintask;

import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input your name: \n");
        String userName = in.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
}
