package by.epam.learn.fundamentals.optionalTask2;

import java.util.*;

public class Matrix {

    static double[][] createMatrix(int dimension, int range) {
        double[][] matrix = new double[dimension][dimension];
        Random random = new Random();

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = random.nextDouble() * (2 * range + 1) - range;
            }
        }
        return matrix;
    }

    static void showMatrix(double[][] matrix){
        for(double[] i : matrix) {
            for(double j : i) System.out.print(String.format("%9.2f", j));
            System.out.println();
        }
    }

    static void showMatrix(ArrayList<ArrayList<Double>> matrixAsList) {
        for(ArrayList<Double> i : matrixAsList) {
            for(Double j : i) System.out.print(String.format("%9.2f", j));
            System.out.println();
        }
    }

    static double [][] sortByColumn(double[][] matrix, int column) {
        double[][] sortedMatrix = matrix.clone();
        Arrays.sort(sortedMatrix, (row1, row2) -> Double.compare(row1[column - 1], row2[column - 1]));
        return sortedMatrix;
    }

    static double[][] sortByRow(double[][] matrix, int row) {
        double[][] sortedMatrix = matrix.clone();
        return reverseMatrix(sortByColumn(reverseMatrix(sortedMatrix), row));
    }

    static double[][] reverseMatrix(double[][] matrix) {
        double[][] reversedMatrix = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                reversedMatrix[j][i] = matrix[i][j];
            }
        }
        return reversedMatrix;
    }

    static ArrayList<ArrayList<Double>> findIncreasingDecreasingElements(double[][] matrix) {
        return new ArrayList<ArrayList<Double>>(){{
            add(findIncreasingElements(matrix));
            add(findDecreasingElements(matrix));
        }};
    }

    private static ArrayList<Double> findIncreasingElements(double[][] matrix) {
        ArrayList<Double> increasingEls = new ArrayList<>();
        ArrayList<Double> tempList = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++) {
            tempList.clear();
            for (int j = 0; j < matrix.length -1 ; j++) {
                if(tempList.isEmpty()) tempList.add(matrix[i][j]);
                if((matrix[i][j] < matrix[i][j+1])) tempList.add(matrix[i][j+1]);
                else if(tempList.size() > increasingEls.size()) {
                    increasingEls = new ArrayList<>(tempList);
                    tempList.clear();
                } else tempList.clear();
            }
            if(tempList.size() > increasingEls.size()) increasingEls = new ArrayList<>(tempList);
        }
        return increasingEls;
    }

    private static ArrayList<Double> findDecreasingElements(double[][] matrix) {
        ArrayList<Double> decreasingEls = new ArrayList<>();
        ArrayList<Double> tempList = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++) {
            tempList.clear();
            for (int j = 0; j < matrix.length -1 ; j++) {
                if(tempList.isEmpty()) tempList.add(matrix[i][j]);
                if((matrix[i][j] > matrix[i][j+1])) tempList.add(matrix[i][j+1]);
                else if(tempList.size() > decreasingEls.size()) {
                    decreasingEls = new ArrayList<>(tempList);
                    tempList.clear();
                } else tempList.clear();
            }
            if(tempList.size() > decreasingEls.size()) decreasingEls = new ArrayList<>(tempList);
        }
        return decreasingEls;
    }

    static double findSumOfElements(double[][] matrix) {
        double sumOfElements = 0;
        for(double[] row : matrix) {
            int indexOfFirstPositive = -1;
            int indexOfSecondPositive = -1;
            int i = 0;
            do {
                if(row[i] > 0) {
                    if(indexOfFirstPositive < 0) indexOfFirstPositive = i;
                    else indexOfSecondPositive = i;
                }
                i++;
            } while (indexOfSecondPositive < 0 && i < row.length);
            if(indexOfSecondPositive > 0 && indexOfSecondPositive - indexOfFirstPositive > 1) {
                for (int j = indexOfFirstPositive + 1; j < indexOfSecondPositive; j++) {
                    sumOfElements += row[j];
                }
            }
        }
        return sumOfElements;
    }

    static ArrayList<ArrayList<Double>> deleteElementFromMatrix(double[][] matrix) {

        // Преобразуем двумерный массив в двумерный ArrayList и одновременно ищем максимальный элемент матрицы
        ArrayList<ArrayList<Double>> matrixAsList = new ArrayList<>();
        double maxElement = Double.MIN_VALUE;
        for(double[] row : matrix) {
            ArrayList<Double> list = new ArrayList<>();
            for(double el : row) {
                if(maxElement < el) maxElement = el;
                list.add(el);
            }
            matrixAsList.add(list);
        }

        // Удалаем все строки, содержащие максимальный элемент,
        // и сохраняем все позиции этого элемента, для последующего удаления из столбцов
        Iterator<ArrayList<Double>> iteratorByRow = matrixAsList.iterator();
        TreeSet<Integer> indexList = new TreeSet<>();
        while (iteratorByRow.hasNext()){
            ArrayList<Double> row = iteratorByRow.next();
            if (row.indexOf(maxElement) >= 0){
                for (int i = 0; i < row.size(); i++) {
                    if(row.get(i) == maxElement) indexList.add(i);
                }
                iteratorByRow.remove();
            }
        }

        for(ArrayList<Double> columnFromRow : matrixAsList){
            for(int i : indexList.descendingSet()) columnFromRow.remove(i);
        }
        return matrixAsList;
    }

}
