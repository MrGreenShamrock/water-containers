package pl.kurs.models;

import java.util.Objects;

public class WaterContainer {
    private final String name;
    private final double maxCapacity;
    private double currentWaterLevel;


    public WaterContainer(String name, double maxCapacity, double currentWaterLevel) {
        if (maxCapacity <= 0) {
            throw new RuntimeException("Max capacity should be more than 0");
        }
        if (currentWaterLevel < 0) {
            throw new RuntimeException("Current water level should be 0 or more.");
        }
        if (currentWaterLevel > maxCapacity) {
            throw new RuntimeException("too much water regarding to max capacity.");
        }
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentWaterLevel = currentWaterLevel;
    }

    public String getName() {
        return name;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public double getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    public void setCurrentWaterLevel(double currentWaterLevel) {
        this.currentWaterLevel = currentWaterLevel;
    }

    public void addWater(double amount) {
        if (amount <= 0) {
            System.out.println("Amount should be > 0");
        } else if (!addIsPossible(amount)) {
            System.out.println("Too much water to add");
        } else {
            currentWaterLevel += amount;
        }
    }


    public void subtractWater(double amount) {
        if (amount <= 0) {
            System.out.println("Amount should be > 0");
        } else if (!subtractIsPossible(amount)) {
            System.out.println("Too much water to subtract");
        } else {
            currentWaterLevel -= amount;
        }
    }

    public void pourWater(WaterContainer sourceContainer, double amount) {
        if (amount <= 0) {
            System.out.println("Amount should be > 0");
        } else if (!sourceContainer.subtractIsPossible(amount)) {
            System.out.println("Not enough water in source container");
        } else if (!addIsPossible(amount)) {
            System.out.println("Not enough capacity in container");
        } else {
            sourceContainer.currentWaterLevel -= amount;
            currentWaterLevel += amount;
        }
    }

    private boolean addIsPossible(double amount) {
        return currentWaterLevel + amount <= maxCapacity;
    }

    private boolean subtractIsPossible(double amount) {
        return currentWaterLevel - amount >= 0;
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
