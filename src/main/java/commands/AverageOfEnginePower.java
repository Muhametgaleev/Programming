package commands;

import classes.Vehicle;
import supplier.Supply;

import java.util.ArrayList;

public class AverageOfEnginePower implements Command {
    ArrayList<Vehicle> list;
    int average = 0, number = 0;

    @Override
    public void execute(Supply s) {
        if (s.getPeremen().equals("")) {
            try {
                list = s.getCopy();
                for (Vehicle vehicle : list) {
                    average += vehicle.getEnginePower();
                    number += 1;
                }
                System.out.println(average / number);
            } catch (ArithmeticException e) {
                System.out.println("Коллекция пуста");
            }
        }
        else System.out.println("Команда введена некорректно");
    }
}
