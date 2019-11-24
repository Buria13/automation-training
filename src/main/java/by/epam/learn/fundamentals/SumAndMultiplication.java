package by.epam.learn.fundamentals;

public class SumAndMultiplication {
    public static void main (String args[]) {
        int sum = 0;
        long multiplication = 1;
        int num;

        for (String i : args){
            num = Integer.parseInt(i);
            sum += num;
            multiplication *= num;
        }

        System.out.println("Sum = " + sum);
        System.out.println("Multiplication = " + multiplication);
    }
}
