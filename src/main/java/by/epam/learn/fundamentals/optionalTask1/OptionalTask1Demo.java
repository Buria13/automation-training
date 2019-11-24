package by.epam.learn.fundamentals.optionalTask1;


public class OptionalTask1Demo {
    public static void main(String[] args) {

        String[] numbers = Options.inputData();

        System.out.println("\n1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");
        NumbersLengthAnalyzer.showMostShortAndLongNumber(numbers);

        System.out.println("\n2. Вывести числа в порядке возрастания (убывания) значений их длины.");
        NumbersLengthAnalyzer.showSortedNumbersByLength(numbers);

        System.out.println("\n\n3. Вывести на консоль те числа, длина которых меньше (больше) " +
                "средней длины по всем числам, а также длину.");
        NumbersLengthAnalyzer.showAverageLengthOfNumbers(numbers);

        System.out.println("\n\n4. Найти число, в котором количество различных цифр минимально. Если таких " +
                "чисел несколько, найти первое из них.");
        DigitsAnalyzer.findNumberWithLeastDifferentDigits(numbers);

        System.out.println("\n5. Найти количество чисел, содержащих только четные цифры," +
                " а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.");
        DigitsAnalyzer.findEvenOddDigits(numbers);

        System.out.println("\n6. Найти число, цифры в котором идут в строгом порядке возрастания. " +
                "Если таких чисел несколько, найти первое из них.");
        DigitsAnalyzer.findNumberWithIncreasingDigits(numbers);

        System.out.println("\n7. Найти число, состоящее только из различных цифр." +
                " Если таких чисел несколько, найти первое из них.");
        DigitsAnalyzer.findNumberWithUniqueDigits(numbers);
    }
}
