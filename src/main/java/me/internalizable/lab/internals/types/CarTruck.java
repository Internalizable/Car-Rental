package me.internalizable.lab.internals.types;

import lombok.Getter;
import lombok.Setter;
import me.internalizable.lab.internals.Car;

@Getter @Setter
public class CarTruck extends Car {

    private double torque;
    private EmissionStandards emissionStandards;
    private double maxLoadWeight;

    public CarTruck() {
        super.setType(CarType.TRUCK);
    }

    public CarTruck(int id, String name) {
        super(id, name);
    }

    @Override
    public void move() {
        System.out.println("Moving a truck using a speed of " + super.getHp() + " HP and a torque of " + torque);
    }

    public enum EmissionStandards {
        EURO_I, EURO_II, EURO_III, EURO_IV, EURO_V, EURO_VI;
    }

    public String toString() {
        return super.toString() + "Type: Truck \nTorque: " + torque + "\nEmission Standards: " + emissionStandards.name() + "\nMax Load Weight: " + maxLoadWeight;
    }
}
