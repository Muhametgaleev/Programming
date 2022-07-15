package commands;

import supplier.Supply;

import java.util.ArrayList;

public class HistoryCommand implements Command {
    @Override
    public void execute(Supply s) {
        if (s.getPeremen().equals("")) {
            ArrayList<String> list = s.getHistory();
            for (String history : list) System.out.println(history);
        } else System.out.println("Команда введена некорректно");
    }
}
