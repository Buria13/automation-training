package by.epam.learn.fundamentals.optionalTask2;

import java.util.Scanner;

public class OptionalTask2Demo {

    private static int inputData(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static void main(String[] args) {
        System.out.println("Введите n - размерность матрицы a [n] [n].");
        int n = inputData();
        System.out.println("Введите M - интервал значений от -M до M элементов матрицы");
        int m = inputData();

        double [][] matrix = Matrix.createMatrix(n, m);

        System.out.println("\nПервоначальная матрица:");
        Matrix.showMatrix(matrix);

        int k = (int)(Math.random() * n) + 1;
        System.out.println("\n1a. Упорядоченная матрица по столбцу k = " + k
                + " (k - случайное целое число от 1 до n):");
        Matrix.showMatrix(Matrix.sortByColumn(matrix, k));

        k = (int)(Math.random() * n) + 1;
        System.out.println("\n1b. Упорядоченная матрица по ряду k = " + k
                + " (k - случайное целое число от 1 до n):");
        Matrix.showMatrix(Matrix.sortByRow(matrix, k));

        System.out.println("\n2.\nНаибольший ряд возрастающих элементов:\n" +
                "Наибольший ряд убывающих элементов:");
        Matrix.showMatrix(Matrix.findIncreasingDecreasingElements(matrix));

        System.out.println("\n3. Cумма элементов матрицы, расположенных между первым и" +
                " вторым положительными элементами каждой строки:");
        System.out.println("Sum = " + String.format("%9.2f", Matrix.findSumOfElements(matrix)));

        System.out.println("\n4. Матрица без строк и столбцов, содержащих максимальный элемент:");
        Matrix.showMatrix(Matrix.deleteElementFromMatrix(matrix));
    }

}
