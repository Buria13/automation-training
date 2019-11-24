package by.epam.learn.collections.main.java.cars;

import by.epam.learn.collections.main.java.types.CarBodyType;
import by.epam.learn.collections.main.java.types.Category;

import java.util.Objects;


public class PassengerTaxi extends Taxi {
    private CarBodyType carBodyType;
    private Category category;
    private int passengers;

    public PassengerTaxi(String model, String licensePlate,
                         int yearOfManufacture, int maxSpeed,
                         double litresPer100km, double currentCostValue,
                         CarBodyType carBodyType, Category category) {
        super(model, licensePlate, yearOfManufacture,
                maxSpeed, litresPer100km, currentCostValue);
        this.carBodyType = carBodyType;
        this.category = category;
        this.passengers = (carBodyType == CarBodyType.VAN) ? 4 : 7;
    }

    public CarBodyType getCarBodyType() {
        return carBodyType;
    }

    public Category getCategory() {
        return category;
    }

    public int getPassengers() {
        return passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerTaxi)) return false;
        if (!super.equals(o)) return false;
        PassengerTaxi car = (PassengerTaxi) o;
        return (passengers != car.passengers) &&
                (carBodyType != car.carBodyType) &&
                (category != car.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carBodyType, carBodyType);
    }
}
