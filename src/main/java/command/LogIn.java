package command;

import data.Login;
import data.UserData;

import java.util.Scanner;

public class LogIn implements InterfaceConsole{
    private UserData list;
    @Override
    public CommandResult<String> execute() throws ExceptionInInitializerError {
        String name,email,password;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your email:");
        email = scan.next();
        System.out.println("Enter your login:");
        name = scan.next();
        System.out.println("Enter your password:");
        password = scan.next();
        Login newuser  = new Login(name,email,password);
        int ch = list.Login(newuser);
        CommandResult<String> result;
        if(ch == 0)
        {
            System.out.println("Log in failed!");
            result = new CommandResult<String>("Succeed!!!!!","Log in failed!",false);
        }
        else
        {
            System.out.println("Log in successful!");
            result = new CommandResult<String>("Succeed!!!!!","Log in successful!",true);
        }
        return result;
    }

    public LogIn(UserData list) {
        this.list = list;
    }
}

