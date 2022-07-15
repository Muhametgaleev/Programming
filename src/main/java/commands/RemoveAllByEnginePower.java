package commands;

import classes.Vehicle;
import supplier.Supply;

import java.util.ArrayList;

public class RemoveAllByEnginePower implements Command{
    @Override
    public void execute(Supply s) {
        try{
            ArrayList<Vehicle> list=s.getCopy();
            ArrayList<Vehicle> listZnach=new ArrayList<>();
            Integer enginePower=Integer.parseInt(s.getPeremen());

            for (Vehicle vehicle:list){
                if(vehicle.getEnginePower().equals(enginePower)){listZnach.add(vehicle);}
            }
            for (Vehicle znach : listZnach) {
                list.remove(znach);
            }
            s.setCopy(list);
            System.out.println("Команда выполнена");
        }
        catch (NumberFormatException e){
            System.out.println("К сожалению, данные введены неправильно");
        }
    }
}
