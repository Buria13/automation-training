package by.epam.learn.collections.main.java.cars;

import java.util.Objects;

public class CargoTaxi extends Taxi {
    private int payload;

    public CargoTaxi(String model, String licensePlate,
                     int yearOfManufacture, int maxSpeed,
                     double litresPer100km, double currentCostValue,
                     int payload) {
        super(model, licensePlate, yearOfManufacture,
                maxSpeed, litresPer100km, currentCostValue);
        this.payload = payload;
    }

    public int getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoTaxi)) return false;
        if (!super.equals(o)) return false;
        CargoTaxi cargoTaxi = (CargoTaxi) o;
        return (payload != cargoTaxi.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), payload);
    }
}
