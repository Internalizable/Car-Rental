package me.internalizable.lab.internals;

import lombok.Getter;
import lombok.Setter;
import me.internalizable.lab.utils.StaticUtils;

@Getter @Setter
public abstract class Car {
    private int id;

    private String name;
    private int capacity;
    private double hp;
    private double cost;
    private double weight;

    private String manufacturerName;
    private CarType type;

    private transient Manufacturer manufacturer;

    public Car() {} // Dummy Constructor

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Car(int id, int capacity, double hp, double cost, double weight, Manufacturer manufacturer) {
        this.id = id;
        this.capacity = capacity;
        this.hp = hp;
        this.cost = cost;
        this.weight = weight;
        this.manufacturer = manufacturer;
    }

    public abstract void move();

    public String toString() {
        return StaticUtils.getDivider() + "\nCar ID: " + id + "\nCar Name: " + name + "\n" + manufacturer.toString() + "\nCapacity: " + capacity + "\nHP: " + hp + "\nCost: " + cost + "\nWeight: " + weight;
    }

    public enum CarType {
        SPORTS, TRUCK, LIMOUSINE;
    }
}
