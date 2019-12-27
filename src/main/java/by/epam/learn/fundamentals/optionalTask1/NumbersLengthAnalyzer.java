package by.epam.learn.fundamentals.optionalTask1;

import java.util.Arrays;

public class NumbersLengthAnalyzer {

    private static String[] sortArrayByElementLength(String[] arr) {
        Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
        return arr;
    }

    static void showMostShortAndLongNumber(String arr[]) {
        sortArrayByElementLength(arr);

        System.out.println("Самое короткое (или одно из, если их несколько) число: " + arr[0] +
                " , его длина: " + arr[0].length());
        System.out.println("Самое длинное (или одно из, если их несколько) число: " + arr[arr.length-1] +
                " , и его длина: " + arr[arr.length-1].length());
    }

    static void showSortedNumbersByLength(String[] arr) {
        sortArrayByElementLength(arr);

        System.out.println("Числа в порядке возрастания длины: ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + "  ");
        }

        System.out.println("\nЧисла в порядке убывания длины: ");
        for (int i = arr.length-1; i >= 0 ; i--) {
            System.out.print(arr[i] + "  ");
        }
    }

    static void showAverageLengthOfNumbers(String arr[]) {
        int sum = 0;

        for (String i : arr) {
            sum += i.length();
        }
        float averageLength = sum / arr.length;

        System.out.println("Числа, длина которых меньше средней длины по всем числам:");
        for (String j : arr) {
            if (j.length() < averageLength) {
                System.out.print("число: " + j
                        + ", длина: " + j.length() + "   ");
            }
        }

        System.out.println("\nЧисла, длина которых больше средней длины по всем числам:");
        for (String k : arr) {
            if (k.length() > averageLength) {
                System.out.print("число: "
                        + k + ", длина: " + k.length() + "   ");
            }
        }

    }

}
