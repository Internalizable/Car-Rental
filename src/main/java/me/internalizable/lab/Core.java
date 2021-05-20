package me.internalizable.lab;

import me.internalizable.lab.reader.IReader;
import me.internalizable.lab.reader.JSONReader;
import me.internalizable.lab.utils.CarList;
import me.internalizable.lab.utils.StaticUtils;
import me.internalizable.lab.utils.cli.FormatMarkdown;

import java.util.Scanner;

public class Core {

    public static void main(String[] args) {
        IReader reader = new JSONReader();

        CarList queryManager = reader.readData();

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println(StaticUtils.getDivider());
            System.out.println("                  Cars Menu                   ");
            System.out.println(StaticUtils.getDivider());

            System.out.println(StaticUtils.getFormattedText("Please input your choice from the list below.", FormatMarkdown.ITALIC));
            System.out.println();

            System.out.println("1- Display all available cars.");
            System.out.println("2- Display all cars given by manufacturer name.");
            System.out.println("3- Display all cars given by certain type.");
            System.out.println("4- Display all cars given by certain name.");
            System.out.println("5- Display all cars with a capacity higher or equal to a given one.");
            System.out.println("6- Display the cheapest car.");
            System.out.println("7- Exit Menu");

            choice = scanner.nextInt();

            switch(choice) {
                case 1 -> queryManager.displayCars();

                case 2 -> {
                    scanner.nextLine();

                    System.out.print("Input the manufacturer name: ");
                    String manufacturerName = scanner.nextLine();

                    queryManager.searchCarManufacturer(manufacturerName);
                }

                case 3 -> {
                    System.out.print("Input the type: ");
                    String carType = scanner.next();

                    queryManager.searchCarType(carType);
                }

                case 4 -> {
                    scanner.nextLine();

                    System.out.print("Input the name: ");
                    String carName = scanner.nextLine();

                    queryManager.searchCarName(carName);
                }

                case 5 -> {
                    System.out.print("Input the capacity: ");
                    double capacity = scanner.nextDouble();

                    queryManager.searchCarCapacity(capacity);
                }

                case 6 -> queryManager.searchCheapestCar();
                case 7 -> System.out.println("Exiting application...");

                default -> System.out.println(StaticUtils.getFormattedText("Error, a choice with that ID does not exist.", FormatMarkdown.INVERTED));
            }

        } while(choice != 7);
    }

}
