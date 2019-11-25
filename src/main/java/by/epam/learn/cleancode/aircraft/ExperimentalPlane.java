package by.epam.learn.cleancode.aircraft;

import by.epam.learn.cleancode.models.ClassificationLevel;
import by.epam.learn.cleancode.models.ExperimentalType;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private ExperimentalType experimentalType;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance,
                             int maxLoadCapacity, ExperimentalType experimentalType,
                             ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperimentalPlane)) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane plane = (ExperimentalPlane) o;
        return  classificationLevel == plane.classificationLevel &&
                experimentalType == plane.experimentalType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalType, classificationLevel);
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }
}
