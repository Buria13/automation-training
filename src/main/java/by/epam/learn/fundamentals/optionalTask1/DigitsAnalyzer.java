package by.epam.learn.fundamentals.optionalTask1;

import java.util.*;

public class DigitsAnalyzer {

    private static List<Integer>[] splitStringsIntoListsOfDigits(String[] arrOfStrings) {
        List<Integer>[] listsOfDigits = new ArrayList[arrOfStrings.length];
        char[][] digitsOnly = new char[arrOfStrings.length][];

        for (int i = 0; i < arrOfStrings.length; i++) {
            digitsOnly[i] = arrOfStrings[i].replaceAll("[^\\d]", "").toCharArray();
            listsOfDigits[i] = new ArrayList<>();
            for (char j : digitsOnly[i]) {
                listsOfDigits[i].add(Character.getNumericValue(j));
            }
        }
        return listsOfDigits;
    }

    static void findNumberWithLeastDifferentDigits(String[] arr) {
        List<Integer>[] arraysOfDigits = splitStringsIntoListsOfDigits(arr);
        int amountOfDifferentDigits = arr[0].length();
        int indexOfNecessaryElement = 0;

        for (int i = 0; i < arraysOfDigits.length; i++) {
            Set<Integer> set = new HashSet<>(arraysOfDigits[i]);
            if (set.size() < amountOfDifferentDigits) {
                indexOfNecessaryElement = i;
                amountOfDifferentDigits = set.size();
            }
        }
        System.out.println("Число с наименьшим количеством различных цифр: "
                + arr[indexOfNecessaryElement]);
    }

    static void findEvenOddDigits(String[] arr) {
        List<Integer>[] arraysOfDigits = splitStringsIntoListsOfDigits(arr);
        int evenOnly = 0;
        int equalEvenOdd = 0;

        for (List<Integer> i : arraysOfDigits) {
            if (i.stream().allMatch(el -> el % 2 == 0)) {
                evenOnly++;
            }
            else {
                int initialAmountOfDigits = i.size();
                i.removeIf(el -> el % 2 == 0);
                if(initialAmountOfDigits / i.size() == 2) equalEvenOdd++;
            }
        }
        System.out.println("Количество чисел, содержащих только четные цифры: " + evenOnly +
                "\nКоличесивто чисел с равным числом четных и нечетных цифр среди оставшихся: " + equalEvenOdd);
    }

    static void findNumberWithIncreasingDigits(String[] arr) {
        List<Integer>[] arraysOfDigits = splitStringsIntoListsOfDigits(arr);
        String resultMessage = "Нет числа со строгим порядком возрастания цифр";
        int i = 0;

        do {
            TreeSet<Integer> treeSet = new TreeSet<>(arraysOfDigits[i]);
            if(Arrays.deepEquals(treeSet.toArray(), arraysOfDigits[i].toArray())) {
                resultMessage = "Число, цифры в котором идут в строгом порядке возрастания: " + arr[i];
                break;
            }
            i++;
        } while (i < arr.length);
        System.out.println(resultMessage);
    }

    static void findNumberWithUniqueDigits(String[] arr) {
        List<Integer>[] arraysOfDigits = splitStringsIntoListsOfDigits(arr);
        String resultMessage = "Нет числа, состоящего только из различных цифр";
        int i = 0;

        do {
            Set<Integer> set = new HashSet<>(arraysOfDigits[i]);
            if(set.size() == arraysOfDigits[i].size()) {
                resultMessage = "Число, состоящее только из различных цифр: " + arr[i];
                break;
            }
            i++;
        } while (i < arr.length);
        System.out.println(resultMessage);
    }

}



