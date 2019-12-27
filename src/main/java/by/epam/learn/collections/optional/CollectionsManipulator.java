package by.epam.learn.collections.optional;

import java.io.*;
import java.util.*;

public class CollectionsManipulator {

    static void inputOutputLinesInReverseOrder(String filePath) {
        Deque<String> stackOfStrings = new ArrayDeque<>(readStringsFromFileToStack(filePath));
        writeStringsInFileFromStack(filePath, stackOfStrings);
    }

    private static Deque<String> readStringsFromFileToStack(String filePath) {
        Deque<String> stackOfStrings = new ArrayDeque<>();
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(filePath))
        ) {
            while ((line = bufferedReader.readLine()) != null) {
                stackOfStrings.push(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e);
        }
        return stackOfStrings;
    }

    private static void writeStringsInFileFromStack(String filePath, Deque<String> deque) {
        String line;

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(filePath))
        ) {
            while (!deque.isEmpty()) {
                line = deque.pop();
                bufferedWriter.write(line, 0, line.length());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e);
        }

    }

    static void displayDigitsOfNumberInReverseOrder(String number) {
        Deque<Integer> stackOfDigits = new ArrayDeque<>();
        char[] digitsOnly = number.replaceAll("[^\\d]", "").toCharArray();

        for (char i : digitsOnly) {
            stackOfDigits.push(Character.getNumericValue(i));
        }

        for (int j : stackOfDigits) {
            System.out.print(j);
        }
    }

    static void writeStringsToListAndSortByLength(String filePath) {
        List<String> listOfStrings = new ArrayList<>(readStringsFromFileToStack(filePath));
        listOfStrings.sort((o1, o2) -> o1.length() - o2.length());

        for (String i : listOfStrings) {
            System.out.println(i);
        }
    }

    static void readStringsFromFileToArrayListAndSort(String filePath) {
        List<String> listOfStrings = new ArrayList<>(readStringsFromFileToStack(filePath));
        Collections.sort(listOfStrings);

        for (String i : listOfStrings) {
            System.out.println(i);
        }
    }

    static boolean checkBrackets(String str) {
        Deque<Character> brackets = new ArrayDeque<>();
        char[] chars = str.toCharArray();

        for (char i : chars) {
            if (i == '(' || i == '{' || i == '[') {
                addBracketToDeque(brackets, i);
            } else if (!brackets.remove(i)) {
                return false;
            }
        }
        return brackets.isEmpty();
    }

    private static void addBracketToDeque(Deque<Character> deque, char bracket) {
        if (bracket == '(') {
            deque.push(')');
        } else {
            deque.push((char) (bracket + 2));
        }
    }

    static Set<String> findDifferentWordsInFile(String filePath) {
        List<String> listOfStrings = new ArrayList<>(readStringsFromFileToStack(filePath));
        Set<String> setOfWords = new HashSet<>();

        for (String str : listOfStrings) {
            setOfWords.addAll(Arrays.asList(str.toLowerCase().split(" ")));
        }
        return setOfWords;
    }

}
