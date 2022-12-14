package command;

import java.io.FileWriter;
import java.util.ArrayList;

public class BuildReport implements InterfaceConsole{
    private ArrayList<CommandResult<String>> list;
    private ArrayList<java.util.Date> dates;
    @Override
    public CommandResult<String> execute() throws Exception {
        FileWriter writer = new FileWriter("D:\\Java\\Lab7\\src\\main\\resources\\Results.txt");
        if (list.isEmpty() && dates.isEmpty())
        {
            return new CommandResult<String>("Succeed!!!!!","List is empty!",true);
        }
        for (int i = 0;i < list.size() && i < dates.size();i++)
        {
            System.out.println(list.get(i).Result());
            System.out.println(dates.get(i));
            writer.write(dates.get(i) + "\n" + list.get(i).getResult() + "\n" + list.get(i).getMessage() + "\n" + list.get(i).isSucceed() + "\n");
        }
        writer.close();
        System.out.println("Building report works!");
        CommandResult<String> result = new CommandResult<String>("Succeed!!!!!","Building report works!",true);
        return result;
    }

    public BuildReport(ArrayList<CommandResult<String>> list,ArrayList<java.util.Date> dates) {
        this.list = list;
        this.dates = dates;
    }
}


