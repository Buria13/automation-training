package by.epam.learn.fundamentals.maintask;

public class ArgumentsViceVersa {
    public static void main (String[] args){
        System.out.print("Аргументы командной строки в обратном порядке: \n");

        for (int i = args.length - 1; i >= 0; i--){
            System.out.print(args[i] + " ");
        }
    }
}

