package commands;

import classes.FuelType;
import classes.Vehicle;
import supplier.Supply;

import java.util.ArrayList;
import java.util.HashSet;


public class UniqueFuelConsumption implements Command {
    @Override
    public void execute(Supply s) {
        if (s.getPeremen().equals("")) {
            ArrayList<Vehicle> list = s.getCopy();
            HashSet<FuelType> listForFuel = new HashSet<>();
            for (Vehicle vehicle : list) {
                listForFuel.add(vehicle.getFuelType());
            }
            for (FuelType unique_fuel : listForFuel) {
                System.out.println(unique_fuel);
            }
        } else System.out.println("Команда введена некорректно");
    }
}
