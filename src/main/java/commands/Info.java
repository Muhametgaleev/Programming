package commands;

import supplier.Supply;

import java.io.IOException;

public class Info implements Command {
    @Override
    public void execute(Supply s) {
        if (s.getPeremen().equals(""))
            System.out.println("Количество элементов в коллекции на данный момент " + s.getSize() + " Остальные данные " + s.toString() + " " + s.hashCode());
        else System.out.println("Команда введена некорректно");
    }
}
