package commands;


import classes.Vehicle;
import scanner.MyScanner;
import supplier.Supply;

import java.util.ArrayList;

public class RemoveLower extends AddParent implements Command {
    @Override
    public void execute(Supply s) {
        if (s.getPeremen().equals("")) {
            ArrayList<Vehicle> list = s.getCopy();
            ArrayList<Vehicle> listZnach = new ArrayList<>();
            MyScanner scanner = new MyScanner();


            System.out.println("Введите значение Capacity");
            Integer capacity = analizeInteger(scanner, "capacity");


            for (Vehicle vehicle : list) {
                if (vehicle.getCapacity() < capacity) {
                    listZnach.add(vehicle);
                }
            }

            for (Vehicle znach : listZnach) {
                list.remove(znach);
            }
            s.setCopy(list);
            System.out.println("Команда выполнена");
        } else System.out.println("Команда введена некорректно");
    }
}
