package commands;

import classes.Coordinates;
import classes.FuelType;
import classes.Vehicle;
import scanner.MyScanner;
import supplier.Supply;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AddIfMax extends AddParent implements Command {
    ArrayList<Vehicle> list;
    int maxEllement = 0;

    @Override
    public void execute(Supply s) {
        if (s.getPeremen().equals("")) {
            list = s.getCopy();
            MyScanner scanner = new MyScanner();

            for (Vehicle vehicle : list) {
                if (maxEllement < vehicle.getCapacity()) {
                    maxEllement = vehicle.getCapacity();
                }
            }
            Integer id = this.findMaxIdFile() + 1;
            System.out.println("Введите имя");
            String name = scanner.readNextLine();
            Coordinates coordinates = new Coordinates(analizeFloat(scanner, "cordx"), analizeLong(scanner, "cordy"));
            System.out.println("Введите значение Capacity");
            Integer capacity = analizeInteger(scanner, "capacity");
            System.out.println("Введите значание Engine power");
            Integer enginePower = analizeInteger(scanner, "Engine Power");
            LocalDateTime creationDate = LocalDateTime.now();
            System.out.println("Введите значение FuelType");
            FuelType type = analizeFuel(scanner, "FuelType");
            if (maxEllement < capacity) {
                list.add(new Vehicle(id, name, coordinates, creationDate, enginePower, capacity, type));
                System.out.println("Элемент успешно добавлен");
                s.setCopy(list);
            } else {
                System.out.println("К сожалению, ваш элемент не подходит по значениям");
            }
        }
        else System.out.println("Команда введена некорректно");
    }
    public int findMaxIdFile() {
        int maxx = 0;
        for (Vehicle vehicle : list) {
            if (vehicle.getId() > maxx) {
                maxx = vehicle.getId();
            }
        }
        return maxx;
    }
}
