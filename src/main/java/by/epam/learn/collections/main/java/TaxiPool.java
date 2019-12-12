package by.epam.learn.collections.main.java;

import by.epam.learn.collections.main.java.cars.Taxi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;


public class TaxiPool {
    private List<? extends Taxi> cars = new ArrayList<>();

    public TaxiPool(List<? extends Taxi> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public TaxiPool(String filePath) {
        this.cars = readFromFile(filePath);
    }

    public List<? extends Taxi> getCars() {
        return cars;
    }

    private List<? extends Taxi> readFromFile(String filePath) {
        List<? extends Taxi> carsFromFile = new ArrayList<>();

        try(ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filePath)
        )) {
            carsFromFile = (List<? extends Taxi>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка чтения файла: " + e);
        }
        return carsFromFile;
    }

    public double getFullCost() {
        double fullCost = 0;

        for(Taxi car : cars) {
            fullCost += car.getCurrentCostValue();
        }
        return fullCost;
    }

    public TaxiPool sortByConsumption() {
        Collections.sort(cars, (Comparator<Taxi>) (o1, o2) ->
                Double.compare(o1.getLitresPer100km(), o2.getLitresPer100km()));
        return this;
    }

    public List<? extends Taxi> getCarsInSpeedRange(int minSpeed, int maxSpeed) {
        List<? extends Taxi> CarsInSpeedRange = new ArrayList<>(cars);
        Iterator<? extends Taxi> iterator = CarsInSpeedRange.iterator();

        while (iterator.hasNext()) {
            Taxi car = iterator.next();
            if(car.getMaxSpeed() < minSpeed || car.getMaxSpeed() > maxSpeed) {
                iterator.remove();
            }
        }
        return CarsInSpeedRange;
    }

    @Override
    public String toString() {
        return "TaxiPool{" +
                "cars=" + cars +
                '}';
    }
}
