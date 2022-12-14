package data;

import database.Delete;
import database.Insert;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserData {
    private ArrayList<Login> list = new ArrayList<>();
    public void addLog(int i,Login elem)
    {
        this.list.add(i,elem);
    }
    public Login getElem(int i)
    {
        return this.list.get(i);
    }
    public void printList()
    {
        for(int i = 0;i < list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
    public void checkList(Login user) throws Exception
    {
        int ch = 0;
        for (int i = 0;i < list.size();i++)
        {
            if(list.get(i).getLogin().equals(user.getLogin()) || list.get(i).getEmail().equals(user.getEmail()))
            {
                System.out.println("This user is registered!Try new login or email");
                ch = 1;
                break;
            }
        }
        if (ch == 0) {
            FileWriter fileWriter = new FileWriter("D:\\Java\\Lab7\\src\\main\\resources\\Logins.txt");
            System.out.println("You are registered!");
            list.add(list.size(), user);
            fileWriter.write(user.getEmail() + "\n" + user.getLogin() + "\n" + user.getPassword() + "\n");
            fileWriter.close();
        }
    }
    public int Login(Login user)
    {
        int ch = 0;
        for (int i = 0;i < list.size();i++)
        {
            if(list.get(i).getLogin().equals(user.getLogin()) && list.get(i).getEmail().equals(user.getEmail()) && list.get(i).getPassword().equals(user.getPassword()))
            {
                ch = 1;
                return 1;
            }
        }
        if(ch == 0)
        {
            System.out.println("Fail.Error.Try registration");
        }
        return 0;
    }
    public void ReadFromFile() throws Exception
    {
        FileReader fileReader = new FileReader("D:\\Java\\Lab7\\src\\main\\resources\\Logins.txt");
        Scanner scanner = new Scanner(fileReader);
        for (int i = 0;scanner.hasNext();i++)
        {
            String email = scanner.nextLine();
            String name = scanner.nextLine();
            String password = scanner.nextLine();
            Login test = new Login(name,email,password);
            addLog(i,test);
        }
        fileReader.close();
    }
    public int getSize()
    {
        return this.list.size();
    }
}


