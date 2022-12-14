package command;

import data.Login;
import data.UserData;

import java.util.Scanner;

public class Register implements InterfaceConsole{
    private UserData list;
    @Override
    public CommandResult<String> execute() throws Exception {
        String name,email,password;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your email:");
        email = scan.next();
        System.out.println("Enter your login:");
        name = scan.next();
        System.out.println("Enter your password:");
        password = scan.next();
        Login newuser  = new Login(name,email,password);
        list.checkList(newuser);
        list.printList();
        System.out.println("Registration is successful!");
        CommandResult<String> result = new CommandResult<String>("Succeed!!!!!","Registration works!",true);
        return result;
    }

    public Register(UserData list) {
        this.list = list;
    }
}

