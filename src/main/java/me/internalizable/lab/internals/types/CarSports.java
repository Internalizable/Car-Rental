package me.internalizable.lab.internals.types;

import lombok.Getter;
import lombok.Setter;
import me.internalizable.lab.internals.Car;
import me.internalizable.lab.internals.IConvertible;

@Getter @Setter
public class CarSports extends Car implements IConvertible {

    private double acceleration;

    public CarSports() {
        super.setType(CarType.SPORTS);
    }

    public CarSports(int id, String name) {
        super(id, name);
    }

    @Override
    public void move() {
        System.out.println("Moving the sports car...");
    }

    @Override
    public void openRoof() {
        System.out.println("Opening the roof...");
    }

    @Override
    public void closeRoof() {
        System.out.println("Closing the roof...");
    }

    public String toString() {
        return super.toString() + "\nType: Sports" + "\nAcceleration: " + acceleration;
    }
}
