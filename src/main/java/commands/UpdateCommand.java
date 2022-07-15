package commands;

import classes.Coordinates;
import classes.FuelType;
import classes.Vehicle;
import scanner.MyScanner;
import supplier.Supply;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UpdateCommand extends AddParent implements Command{
    ArrayList<Vehicle> list;
    @Override
    public void execute(Supply s) {
        try {
            list=s.getCopy();
            int id=Integer.parseInt(s.getPeremen());
            list.removeIf(vehicle -> vehicle.getId().equals(id));

            MyScanner scanner=new MyScanner();
            System.out.println("Введите имя");
            String name= scanner.readNextLine();
            Coordinates coordinates=new Coordinates(analizeFloat(scanner,"cordx"), analizeLong(scanner,"cordy"));
            Integer  capacity= analizeInteger(scanner, "capacity");
            Integer  enginePower= analizeInteger(scanner, "Engine Power");
            LocalDateTime creationDate = LocalDateTime.now();
            FuelType type=analizeFuel(scanner, "FuelType");

            list.add(new Vehicle(id, name, coordinates, creationDate, enginePower, capacity, type));
            System.out.println("Элемент добавлен");
            s.setCopy(list);

        }
        catch (NumberFormatException e){execute(s);}
    }
}
