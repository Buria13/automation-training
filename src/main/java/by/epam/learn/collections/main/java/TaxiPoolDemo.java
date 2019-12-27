package by.epam.learn.collections.main.java;

import by.epam.learn.collections.main.java.cars.*;
import by.epam.learn.collections.main.java.types.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class TaxiPoolDemo {

    private static List<? extends Taxi> cars = Arrays.asList(
            new PassengerTaxi("Renault Logan", "8282IE7", 2007, 95, 7.5, 3000, CarBodyType.SEDAN, Category.ECONOMY),
            new PassengerTaxi("Skoda Rapid", "7231AI7", 2009, 100, 8, 6500, CarBodyType.SEDAN, Category.ECONOMY),
            new PassengerTaxi("Volkswagen Passat", "1234AI7", 2015, 100, 10, 8500, CarBodyType.WAGON, Category.COMFORT),
            new PassengerTaxi("Dodge Caravan", "5678AI7", 2014, 99, 14, 8888, CarBodyType.VAN, Category.COMFORT),
            new PassengerTaxi("M. Benz S-class", "1313XX5", 2019, 200, 13, 100000, CarBodyType.SEDAN, Category.BUSINESS),
            new PassengerTaxi("M. Benz E-class", "1212TT7", 2010, 140, 12, 15000, CarBodyType.SEDAN, Category.COMFORT),
            new PassengerTaxi("Skoda Octavia", "1525SS7", 2012, 120, 11, 9999.99, CarBodyType.SEDAN, Category.COMFORT),
            new CargoTaxi("M. Benz Sprinter", "0001AA1", 2000, 80, 15, 13000, 3000),
            new CargoTaxi("Gazel", "9339HK5", 1980, 65, 14, 1500.5, 1500)
    );

    public static void main(String[] args) {
        saveCarsToFile(cars, "src/main/java/by/epam/learn/collections/main/resources/cars.dat");
        TaxiPool taxiPool = new TaxiPool("src/main/java/by/epam/learn/collections/main/resources/cars.dat");

        System.out.println("Стоимость автопарка: " +
                taxiPool.getFullCost());
        System.out.println("\nАвтомобили компании, соответствующие заданному диапазону скорости: \n" +
                taxiPool.getCarsInSpeedRange(90, 100));
        System.out.println("\nАвтомобили парка, отсортированные по расходу топлива: \n" +
                taxiPool.sortByConsumption());
    }

    private static void saveCarsToFile(List<? extends Taxi> cars, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePath)
        )) {
            objectOutputStream.writeObject(cars);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл:  " + e);
        }
    }

}
