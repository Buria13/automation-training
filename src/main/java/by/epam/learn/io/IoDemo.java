package by.epam.learn.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class IoDemo {


    public static void main(String[] args) {
        //String str = "d:\\com";
        String str = "someString";
        File file = new File(str);
        //File file = new File(args[0]);

        if (file.isDirectory()) {
            tree(file);
        } else {
            tree(str);
        }
    }

    private static void tree(String str) {
        System.out.println("второй трее");
    }


    private static void tree(File directory) {
        reassignSystemOutToFileOutputStream(directory);
    }

    private static void reassignSystemOutToFileOutputStream(File directory) {
        File tree = new File ("src/main/java/by/epam/learn/io/resources/tree.txt");
        try (PrintStream stream = new PrintStream(
                new FileOutputStream(tree))) {
            System.setOut(stream);
            writeTreeToFile(directory, "");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла");
        }
    }

    private static void writeTreeToFile(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File i : files) {
                if (i.isFile()) {
                    System.out.println(indent + "|     " + i.getName());
                }
            }

            for (File j : files) {
                if (j.isDirectory()) {
                    System.out.println(indent + "|-----" + j.getName());
                    writeTreeToFile(j, indent + "|     ");
                }
            }
        }
    }
}

