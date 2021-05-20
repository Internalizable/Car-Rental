package me.internalizable.lab.internals.types;

import lombok.Getter;
import lombok.Setter;
import me.internalizable.lab.internals.Car;
import me.internalizable.lab.internals.IConvertible;

@Getter @Setter
public class LimousineCar extends Car implements IConvertible {

    private int numberOfCompartments;

    public LimousineCar() {
        super.setType(CarType.LIMOUSINE);
    }

    public LimousineCar(int id, String name) {
        super(id, name);
    }

    @Override
    public void move() {
        System.out.println("Moving the limousine with it's " + numberOfCompartments + " compartments.");
    }

    @Override
    public void openRoof() {
        System.out.println("Opening the roof of the limousine...");
    }

    @Override
    public void closeRoof() {
        System.out.println("Closing the roof of the limousine...");
    }

    public String toString() {
        return super.toString() + "\nType: Limousine" + "\nNumber Of Compartments: " + numberOfCompartments;
    }
}
