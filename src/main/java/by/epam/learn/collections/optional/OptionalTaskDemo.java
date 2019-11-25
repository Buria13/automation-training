package by.epam.learn.collections.optional;

public class OptionalTaskDemo {

    public static void main(String[] args) {
        System.out.println("\n   Результат задачи 'Ввести строки из файла, записать в список. " +
                "Вывести строки в файл в обратном порядке.' находится " +
                "в текущей дериктории resources/song.txt");
        CollectionsManipulator.inputOutputLinesInReverseOrder(
                "src/main/java/by/epam/learn/collections/optional/resources/song.txt");

        String number = "-41.42";
        System.out.println("\n   Введенное число: " + number);
        System.out.print("   Число, цифры которого идут в обратном порядке: ");
        CollectionsManipulator.displayDigitsOfNumberInReverseOrder(number);

        System.out.println("\n\n   Стихотворение, занесенное в список, и остортированное по длине строк: ");
        CollectionsManipulator.writeStringsToListAndSortByLength(
                "src/main/java/by/epam/learn/collections/optional/resources/verse.txt");

        System.out.println("\n   Ввести строки из файла, записать в список ArrayList. " +
                "\n   Выполнить сортировку строк, используя метод sort() из класса Collections:");
        CollectionsManipulator.readStringsFromFileToArrayListAndSort(
                "src/main/java/by/epam/learn/collections/optional/resources/verse.txt");

        String str = "{([[[(}[]({)]]))}{(])(})";
        System.out.println("\n   Правильность расстановок скобок: " + CollectionsManipulator.checkBrackets(str));

        System.out.println("\n   Коллекция различных слов в файле текущей дериктории resources/song.txt: " +
                CollectionsManipulator.findDifferentWordsInFile("src/main/java/by/epam/learn/collections/optional/resources/song.txt"));
    }
}
