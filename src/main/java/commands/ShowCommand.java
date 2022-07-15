package commands;

import classes.Vehicle;
import supplier.Supply;

import java.util.ArrayList;

public class ShowCommand implements Command {
    ArrayList<Vehicle> list;

    @Override
    public void execute(Supply s) {
        if (s.getPeremen().equals("")) {
            list = s.getCopy();
            for (Vehicle vehicle : list) {
                System.out.println(vehicle.getName() + " " + vehicle.getId() + " " + vehicle.getCapacity() + " " + vehicle.getEnginePower() + " " + vehicle.getCoordinateX() + " " + vehicle.getCoordinateY() + " " + vehicle.getCreationDate());
            }
        } else System.out.println("Команда введена некорректно");
    }
}
