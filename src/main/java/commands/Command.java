package commands;

import supplier.Supply;

public interface Command {
    void execute(Supply s);
}
