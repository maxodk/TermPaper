package command;

public class UpdateEquipment implements InterfaceConsole{
    @Override
    public CommandResult<String> execute() throws Exception {
        System.out.println("Updating works!");
        CommandResult<String> result = new CommandResult<String>("Succeed!!!!!","Updating works!",true);
        return result;
    }
}


