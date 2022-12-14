package data;

import database.Insert;
import knight.Knight;

import java.util.ArrayList;
import java.util.Scanner;

public class KnightData {
    private ArrayList<Knight> list = new ArrayList<Knight>();
    public ArrayList<Knight> fillKnight(int size)
    {
        Scanner scan = new Scanner(System.in);
        for (int i = 0;i < size;i++)
        {
            System.out.println("Enter name:");
            String name = scan.next();
            System.out.println("Enter age");
            int age = scan.nextInt();
            System.out.println("Enter available money for equipping");
            double money = scan.nextDouble();
            Knight element = new Knight(name,age,money);
            Insert insert = new Insert();
            insert.InsertKnight(element);
            list.add(i,element);
        }
        return this.list;
    }
    public void printList(int size)
    {
        for(int i = 0;i < size;i++)
        {
            System.out.println(list.get(i));
        }
    }
    public int getSize()
    {
        return this.list.size();
    }
    public Knight getElem(int i)
    {
        return list.get(i);
    }
    public void addElem(int i,Knight knight)
    {
        list.add(i,knight);
    }
}

