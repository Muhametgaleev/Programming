
import managers.CommandManager;
import parser.SaxPars;
import scanner.MyScanner;
import supplier.Supply;

public class Main {
    public static  void main(String[] args) {
        MyScanner myScanner=new MyScanner();
        SaxPars saxPars=new SaxPars();
        Supply supply=new Supply(saxPars);
        CommandManager command=new CommandManager();

        while (supply.getRunning()) {
            String[] s = myScanner.readNextLine().split(" ");
            try{
                    if(s.length==2) supply.setPeremen(s[1]);
                    command.getCommand(s[0]).execute(supply);
                    supply.setHistory(s[0]);
            }
            catch (NullPointerException e){

                System.out.println("такой команды не существует");
            }
            supply.setPeremen("");
        }
    }
}
