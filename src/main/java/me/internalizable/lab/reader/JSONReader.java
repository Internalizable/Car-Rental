package me.internalizable.lab.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import me.internalizable.lab.internals.Car;
import me.internalizable.lab.internals.Manufacturer;
import me.internalizable.lab.internals.types.CarSports;
import me.internalizable.lab.internals.types.CarTruck;
import me.internalizable.lab.internals.types.LimousineCar;
import me.internalizable.lab.utils.CarList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

public class JSONReader implements IReader {

    private final Type CAR_TYPE;
    private final Type MANUFACTURER_TYPE;

    private final Gson gson;

    public JSONReader() {
        CAR_TYPE = new TypeToken<List<Car>>() {
        }.getType();
        MANUFACTURER_TYPE = new TypeToken<List<Manufacturer>>() {
        }.getType();

        RuntimeTypeAdapterFactory<Car> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(Car.class, "type")
                .registerSubtype(CarSports.class, "SPORTS")
                .registerSubtype(CarTruck.class, "TRUCK")
                .registerSubtype(LimousineCar.class, "LIMOUSINE");

        gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).setPrettyPrinting().create();
    }

    @Override
    public CarList readData() {
        JsonReader carReader = null;
        JsonReader manufacturerReader = null;

        try {
            carReader = new JsonReader(new FileReader("data/cars.json"));
            manufacturerReader = new JsonReader(new FileReader("data/manufacturers.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        List<Car> cars = gson.fromJson(carReader, CAR_TYPE);
        List<Manufacturer> manufacturers = gson.fromJson(manufacturerReader, MANUFACTURER_TYPE);

        CarList carList = new CarList(cars, manufacturers);

        carList.getCars().sort(Comparator.comparingInt(Car::getId));
        carList.getCars().forEach(car -> car.setManufacturer(carList.getManufacturerByName(car.getManufacturerName())));

        return carList;
    }


}
