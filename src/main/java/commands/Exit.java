package commands;

import supplier.Supply;

public class Exit implements Command {

    public void execute(Supply s) {
        if (s.getPeremen().equals("")) {
            s.setRunning(false);
        } else System.out.println("Команда введена некорректно");
    }
}
