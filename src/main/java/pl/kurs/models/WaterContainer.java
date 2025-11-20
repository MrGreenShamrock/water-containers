package pl.kurs.models;

import java.util.Objects;

public class WaterContainer {
    private String name;
    private double maxCapacity;
    private double currentWaterLevel;


    public WaterContainer(String name, double maxCapacity, double currentWaterLevel) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentWaterLevel = currentWaterLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    public void setCurrentWaterLevel(double currentWaterLevel) {
        this.currentWaterLevel = currentWaterLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WaterContainer that = (WaterContainer) o;
        return Double.compare(maxCapacity, that.maxCapacity) == 0 && Double.compare(currentWaterLevel, that.currentWaterLevel) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxCapacity, currentWaterLevel);
    }

    @Override
    public String toString() {
        return "WaterContainer{" +
                "name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", currentWaterLevel=" + currentWaterLevel +
                '}';
    }
}
