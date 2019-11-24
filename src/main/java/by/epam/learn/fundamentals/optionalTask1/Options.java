package by.epam.learn.fundamentals.optionalTask1;

import java.util.Scanner;

public class Options {

    static String[] inputData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Задайте количество чисел, которые будут введены через консоль:");
        int count = in.nextInt();
        in.nextLine();
        String[] numbers = new String[count];
        System.out.println("Теперь введите числа:\n");
        for(int i = 0; i < count; i++) {
            numbers[i] = in.nextLine();
        }
        return numbers;
    }
}
