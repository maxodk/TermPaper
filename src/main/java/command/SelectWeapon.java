package command;

import data.KnightData;
import data.WeaponData;
import database.Delete;
import database.Insert;
import database.Select;
import database.Update;
import weapon.Bow;
import weapon.HeavyWeapon;
import weapon.Spear;
import weapon.Sword;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectWeapon implements InterfaceConsole{
    private KnightData elem1;
    private WeaponData list;
    private ArrayList<WeaponData> wdata;
    @Override
    public CommandResult<String> execute() throws Exception {
        Scanner scan = new Scanner(System.in);
        int size;
        if(elem1.getSize() < 1)
        {
            System.out.println("Enter count of knights:");
            size = scan.nextInt();
            Delete delete = new Delete();
            delete.DeleteKnight();
            delete.DeleteKnightBow();
            delete.DeleteKnightHeavyWeapon();
            delete.DeleteKnightSpear();
            delete.DeleteKnightSword();
            elem1.fillKnight(size);
            Select select = new Select();
            select.SelectKnights();
        }
        else
        {
            size = elem1.getSize();
            elem1.printList(elem1.getSize());
        }
        Delete delete = new Delete();
        delete.DeleteBowList();
        delete.DeleteHeavyWeaponList();
        delete.DeleteSpearList();
        delete.DeleteSwordList();
        list.fillList();
        int ch_elem = -1;
        for(int i = 0;i < size;i++)
        {
            if(wdata.size() > 0)
            {
                wdata.add(i,new WeaponData());
                if(wdata.get(i).getSize() > 0)
                {
                    System.out.println("Error!This knight have equipment");
                }
                else
                {
                    equip(i);
                    wdata.get(i).printList();
                    double sum = wdata.get(i).getSummaryCost();
                    System.out.println("Your weapon costs " + sum);
                }
            }
            else
            {
                delete.DeleteKnightBow();
                delete.DeleteKnightHeavyWeapon();
                delete.DeleteKnightSpear();
                delete.DeleteKnightSword();
                wdata.add(i,new WeaponData());
                equip(i);
                wdata.get(i).printList();
                double sum = wdata.get(i).getSummaryCost();
                System.out.println("Your weapon costs " + sum);
            }
        }
        System.out.println("Select weapon works!");
        CommandResult<String> result = new CommandResult<String>("Succeed!!!!!","Select weapon works!",true);
        return result;
    }

    public SelectWeapon(KnightData elem1, WeaponData list, ArrayList<WeaponData> wdata) {
        this.elem1 = elem1;
        this.list = list;
        this.wdata = wdata;
    }
    public void equip(int i)
    {
        Scanner scan = new Scanner(System.in);
        int ch = 1;
        int count_of_chosen = 0;
        int ch_elem;
        boolean isBow = false;
        boolean isHeavy = false;
        boolean isSpear = false;
        boolean isSword = false;
        double money = elem1.getElem(i).getAvailable_money();
        while (ch != 0 && money > 0.0)
        {
            System.out.println("Enter what equipment do you want to select for your knight:"
                    + "\nBow - 1" + "\nHeavyWeapon - 2" + "\nSpear - 3" + "\nSword - 4" + "\nNext knight or exit - 0");
            ch = scan.nextInt();
            if(ch == 1 && !isBow)
            {
                list.filtrList(0,250);
                //list.FilterParam(0,250);
                System.out.println("Enter the number of element that you want to buy:");
                ch_elem = scan.nextInt();
                ch_elem -= 1;
                while (ch_elem > 249 || ch_elem < 0)
                {
                    ch_elem = scan.nextInt();
                    ch_elem -= 1;
                }
                if(money - list.getElem(ch_elem).getCost() > 0)
                {
                    money -= list.getElem(ch_elem).getCost();
                    wdata.get(i).addElem(list.getElem(ch_elem),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightBow(new Bow(list.getElem(ch_elem).getCost(),list.getElem(ch_elem).getWeight(),list.getElem(ch_elem).getType(),list.getElem(ch_elem).getStrength(),10,true),i);
                    isBow = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            if(ch == 2 && !isHeavy)
            {
                list.filtrList(250,500);
                //list.FilterParam(250,500);
                System.out.println("Enter the number of element that you want to buy:");
                ch_elem = scan.nextInt();
                ch_elem -= 1;
                while (ch_elem > 499 || ch_elem < 250)
                {
                    ch_elem = scan.nextInt();
                    ch_elem -= 1;
                }
                if(money - list.getElem(ch_elem).getCost() > 0)
                {
                    money -= list.getElem(ch_elem).getCost();
                    wdata.get(i).addElem(list.getElem(ch_elem),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightHeavyWeapon(new HeavyWeapon(list.getElem(ch_elem).getCost(),list.getElem(ch_elem).getWeight(),list.getElem(ch_elem).getType(),list.getElem(ch_elem).getStrength(),true),i);
                    isHeavy = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            if(ch == 3 && !isSpear)
            {
                list.filtrList(500,750);
                //list.FilterParam(500,750);
                System.out.println("Enter the number of element that you want to buy:");
                ch_elem = scan.nextInt();
                ch_elem -= 1;
                while (ch_elem > 749 || ch_elem < 500)
                {
                    ch_elem = scan.nextInt();
                    ch_elem -= 1;
                }
                if(money - list.getElem(ch_elem).getCost() > 0)
                {
                    money -= list.getElem(ch_elem).getCost();
                    wdata.get(i).addElem(list.getElem(ch_elem),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightSpear(new Spear(list.getElem(ch_elem).getCost(),list.getElem(ch_elem).getWeight(),list.getElem(ch_elem).getType(),list.getElem(ch_elem).getStrength(),50.0),i);
                    isSpear = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            if(ch == 4 && !isSword)
            {
                list.filtrList(750,1000);
                //list.FilterParam(750,1000);
                System.out.println("Enter the number of element that you want to buy:");
                ch_elem = scan.nextInt();
                ch_elem -= 1;
                while (ch_elem > 999 || ch_elem < 750)
                {
                    ch_elem = scan.nextInt();
                    ch_elem -= 1;
                }
                if(money - list.getElem(ch_elem).getCost() > 0)
                {
                    money -= list.getElem(ch_elem).getCost();
                    wdata.get(i).addElem(list.getElem(ch_elem),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightSword(new Sword(list.getElem(ch_elem).getCost(),list.getElem(ch_elem).getWeight(),list.getElem(ch_elem).getType(),list.getElem(ch_elem).getStrength(),true,50.0),i);
                    isSword = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            System.out.println("Available money is " + money);
            elem1.getElem(i).setAvailable_money(money);
            Update update = new Update();
            update.UpdateKnight(elem1.getElem(i));
            Select select = new Select();
            select.SelectKnights();
        }
    }
}


