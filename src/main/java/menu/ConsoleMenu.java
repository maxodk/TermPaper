package menu;

import command.*;
import data.*;
import database.Delete;
import database.Insert;
import database.Select;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class ConsoleMenu {
    private ArrayList<CommandResult<String>> resultArrayList = new ArrayList<>();
    private ArrayList<java.util.Date> dates = new ArrayList<>();
    public void Menu2() throws Exception
    {
        UserData userlist = new UserData();
        userlist.ReadFromFile();
        Delete delete = new Delete();
        delete.DeleteUsers();
        Insert insert = new Insert();
        insert.InsertUsers(userlist);
        Select select = new Select();
        select.SelectUsers();
        int index = resultArrayList.size();
        KnightData kdata = new KnightData();
        EquipmentData list = new EquipmentData();
        WeaponData wlist = new WeaponData();
        ArrayList<EquipmentData> edata = new ArrayList<>();
        ArrayList<WeaponData> wdata = new ArrayList<>();
        System.out.println("\nSelect your action:\nselect equipment for knight - 1" +
                "\nadd equipment - 2\nupdate equipment - 3\ndelete equipment - 4\nlog out - 5\nbuild report - 6\nselect weapon - 7\ncalculate data - 8");
        Scanner scan = new Scanner(System.in);
        int ch = scan.nextInt();
        Map<Integer , InterfaceConsole> commands = new HashMap<>();
        commands.put(1,new SelectEquipment(kdata,list,edata));
        commands.put(2,new AddEquipment(kdata,list,edata,wlist,wdata));
        commands.put(3,new UpdateEquipment());
        commands.put(4,new DeleteEquipment(kdata,list,edata,wlist,wdata));
        commands.put(5,new LogOut(userlist));
        commands.put(6,new BuildReport(resultArrayList,dates));
        commands.put(7,new SelectWeapon(kdata,wlist,wdata));
        commands.put(8,new CalculateData(kdata,edata,wdata));
        while(ch != 0)
        {
            CommandResult<String> res = commands.get(ch).execute();
            long millis = System.currentTimeMillis();
            dates.add(index,new Date(millis));
            resultArrayList.add(index,res);
            index++;
            if(res.isSucceed() && ch == 5)
            {
                break;
            }
            System.out.println("\nSelect your action:\nselect equipment for knight - 1" +
                    "\nadd equipment - 2\nupdate equipment - 3\ndelete equipment - 4\nlog out - 5\nbuild report - 6\nselect weapon - 7\ncalculate data - 8");
            ch = scan.nextInt();
        }
    }
    public void Menu() throws Exception {
        UserData userlist = new UserData();
        userlist.ReadFromFile();
        Delete delete = new Delete();
        delete.DeleteUsers();
        Insert insert = new Insert();
        insert.InsertUsers(userlist);
        Select select = new Select();
        select.SelectUsers();
        System.out.println("Welcome to menu.What you want?\nhelp - 1\nlog in - 2\nregister - 3\nexit - 0");
        Scanner scan = new Scanner(System.in);
        Map<Integer , InterfaceConsole> commands = new HashMap<>();
        commands.put(1,new Help());
        commands.put(2,new LogIn(userlist));
        commands.put(3,new Register(userlist));
        int index = 0;
        int ch = scan.nextInt();
        while(ch != 0)
        {
            CommandResult<String> res = commands.get(ch).execute();
            long millis = System.currentTimeMillis();
            dates.add(index,new Date(millis));
            resultArrayList.add(index,res);
            index += 1;
            if(res.isSucceed() && ch == 2)
            {
                Menu2();
            }
            if(!res.isSucceed())
            {
                System.out.println(res.getMessage());
            }
            System.out.println("\nWelcome to menu.What you want?\nhelp - 1\nlog in - 2\nregister - 3\nexit - 0");
            ch = scan.nextInt();
        }
        FileWriter writer = new FileWriter("D:\\Java\\Lab7\\src\\main\\resources\\Logins.txt");
        for (int i = 0;i < userlist.getSize();i++)
        {
            writer.write(userlist.getElem(i).getEmail() + "\n" + userlist.getElem(i).getLogin() + "\n" + userlist.getElem(i).getPassword() + "\n");
        }
        writer.close();
        FileWriter writer1 = new FileWriter("D:\\Java\\Lab7\\src\\main\\resources\\Results.txt");
        boolean isSend = false;
        for (int i = 0;i < resultArrayList.size();i++)
        {
            if(resultArrayList.get(i).getResult().equals("Critical error!"))
            {
                isSend = true;
            }
            writer1.write(dates.get(i) + "\n" + resultArrayList.get(i).getResult() + "\n" + resultArrayList.get(i).getMessage() + "\n" + resultArrayList.get(i).isSucceed() + "\n");
        }
        writer1.close();
        if(isSend)
        {
            SendEmail temp = new SendEmail();
            temp.send();
        }
    }
}


