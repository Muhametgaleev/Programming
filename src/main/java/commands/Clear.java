package commands;

import classes.Vehicle;
import supplier.Supply;

import java.util.ArrayList;

public class Clear implements Command {
    ArrayList<Vehicle> list;

    @Override
    public void execute(Supply s) {
        if (s.getPeremen().equals("")) {
            list = new ArrayList<Vehicle>();
            s.setCopy(list);
            System.out.println("Команда выполнена");
        } else System.out.println("Команда введена некорректно");
    }
}