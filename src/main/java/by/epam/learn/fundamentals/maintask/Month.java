package by.epam.learn.fundamentals.maintask;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Month {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число от 1 до 12: ");

        try {
            byte month = Byte.parseByte(in.nextLine());
            if (month >= 1 && month <= 12) {
                GregorianCalendar date = new GregorianCalendar(0, month, 0);
                System.out.println(new SimpleDateFormat("MMMM").format(date.getTime()));
            } else System.out.println("Число должно быть в рамках от 1 до 12");
        } catch (NumberFormatException  e) {
            System.out.println("Ошибка ввода: " + e +
                    "\nВводимые данные должны быть целым числом от 1 до 12");
        }
    }
}
