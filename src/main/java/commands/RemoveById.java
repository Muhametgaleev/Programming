package commands;

import classes.Vehicle;
import supplier.Supply;

import java.util.ArrayList;


public class RemoveById implements Command {
    ArrayList<Vehicle> list;
    int id;

    @Override
    public void execute(Supply s) {
        try {
            id = Integer.parseInt(s.getPeremen());
            list = s.getCopy();
            for (Vehicle vehicle : list) {
                if (vehicle.getId().equals(id)) {
                    list.remove(vehicle);
                }
            }
            s.setCopy(list);
            System.out.println("Команда выполнена");
        } catch (NumberFormatException e) {
            execute(s);
        }
    }
}
