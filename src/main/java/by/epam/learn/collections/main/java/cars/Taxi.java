package by.epam.learn.collections.main.java.cars;

import java.io.Serializable;
import java.util.Objects;

public class Taxi implements Serializable {
    private String model;
    private String licensePlate;
    private int yearOfManufacture;
    private int maxSpeed;
    private double litresPer100km;
    private double currentCostValue;
    private static final long serialVersionUID = 1L;

    public Taxi(String model, String licensePlate,
                int yearOfManufacture, int maxSpeed,
                double litresPer100km, double currentCostValue) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.yearOfManufacture = yearOfManufacture;
        this.maxSpeed = maxSpeed;
        this.litresPer100km = litresPer100km;
        this.currentCostValue = currentCostValue;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getLitresPer100km() {
        return litresPer100km;
    }

    public double getCurrentCostValue() {
        return currentCostValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taxi taxi = (Taxi) o;
        return (Double.compare(taxi.currentCostValue, currentCostValue) != 0) &&
                (Double.compare(taxi.litresPer100km, litresPer100km) != 0) &&
                maxSpeed != taxi.maxSpeed &&
                yearOfManufacture != taxi.yearOfManufacture &&
                licensePlate.equals(taxi.licensePlate) &&
                model.equals(taxi.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, licensePlate, yearOfManufacture,
                maxSpeed, litresPer100km, currentCostValue);
    }

    @Override
    public String toString() {
        return "\nTaxi{" +
                "Модель: '" + model + '\'' +
                ", гос. номер: '" + licensePlate + '\'' +
                ", г.в.: " + yearOfManufacture +
                ", макс. скорость: " + maxSpeed +
                ", расход л/100км: " + litresPer100km +
                ", текущая стоимость: " + currentCostValue +
                '}';
    }


}
