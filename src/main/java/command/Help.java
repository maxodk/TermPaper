package command;

public class Help implements InterfaceConsole{
    @Override
    public CommandResult<String> execute() throws Exception {
        System.out.println("Our Father, which art in heaven,\n" +
                "hallowed be thy name;\n" +
                "thy kingdom come;\n" +
                "thy will be done in earth as it is in heaven.\n" +
                "Give us this day our daily bread;\n" +
                "and forgive us our trespasses\n" +
                "as we forgive them who trespass against us;\n" +
                "and lead us not into temptation,\n" +
                "but deliver us from the evil one.\n" +
                "For thine is the kingdom\n" +
                "and the power and the glory, for ever.\n" +
                "Amen.");
        System.out.println("Help works!");
        CommandResult<String> result = new CommandResult<String>("Critical error!","Help works!",true);
        return result;
    }
}

