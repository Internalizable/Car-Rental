package me.internalizable.lab.utils;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import me.internalizable.lab.internals.Car;
import me.internalizable.lab.internals.Manufacturer;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Getter @Setter
public class CarList {

    private List<Car> cars;
    private List<Manufacturer> manufacturers;

    public CarList(List<Car> cars, List<Manufacturer> manufacturers) {
        this.cars = cars;
        this.manufacturers = manufacturers;
    }

    public void displayCars() {
        cars.forEach(car -> System.out.println(car.toString()));
    }

    public void searchCarManufacturer(String manufacturer) {
        List<Car> reducedStream = cars.stream().filter(car -> car.getManufacturerName().equalsIgnoreCase(manufacturer)).collect(Collectors.toList());
        displayReducedStream(reducedStream);
    }

    public Manufacturer getManufacturerByName(String manufacturerName) {
        return manufacturers.stream().filter(manufacturer -> manufacturer.getName().equalsIgnoreCase(manufacturerName)).findFirst().orElse(null);
    }

    public void searchCarType(String type) {
        List<Car> reducedStream = cars.stream().filter(car -> car.getType().name().equalsIgnoreCase(type)).collect(Collectors.toList());
        displayReducedStream(reducedStream);
    }

    public void searchCarName(String name) {
        List<Car> reducedStream = cars.stream().filter(car -> car.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        displayReducedStream(reducedStream);
    }

    public void searchCarCapacity(double capacity) {
        List<Car> reducedStream = cars.stream().filter(car -> car.getCapacity() >= capacity).collect(Collectors.toList());
        displayReducedStream(reducedStream);
    }

    public void searchCheapestCar() {
        List<Car> reducedStream = cars.stream().min(Comparator.comparingDouble(Car::getCost)).stream().collect(Collectors.toList());
        displayReducedStream(reducedStream);
    }

    @NonNull
    private void displayReducedStream(List<Car> reducedStream) {
        if(reducedStream.isEmpty())
            System.out.println("No cars with the given option could be found");
        else
            reducedStream.forEach(car -> System.out.println(car.toString()));
    }
}
