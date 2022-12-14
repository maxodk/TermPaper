package command;

import data.EquipmentData;
import data.KnightData;
import data.WeaponData;
import database.Insert;
import database.Select;
import database.Update;
import equipment.Boots;
import equipment.Breastplate;
import equipment.Helmet;
import equipment.Shield;
import weapon.Bow;
import weapon.HeavyWeapon;
import weapon.Spear;
import weapon.Sword;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class AddEquipment implements InterfaceConsole{
    private static final Logger log = Logger.getLogger(AddEquipment.class.getName());
    private KnightData elem1;
    private EquipmentData list;
    private ArrayList<EquipmentData> e;
    private WeaponData wlist;
    private ArrayList<WeaponData> w;
    @Override
    public CommandResult<String> execute() throws Exception {
        log.info("Add work go");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter what you want:select equipment or select weapon?(0 or 1)");
        int ch = scan.nextInt();
        if(ch == 0)
        {
            addEquip();
        }
        if(ch == 1)
        {
            addWeapon();
        }
        CommandResult<String> result = new CommandResult<String>("Succeed!!!!","Add working!",true);
        return result;
    }
    public AddEquipment(KnightData elem, EquipmentData list, ArrayList<EquipmentData> e,WeaponData wlist,ArrayList<WeaponData> w) {
        this.elem1 = elem;
        this.list = list;
        this.e = e;
        this.wlist = wlist;
        this.w = w;
    }
    public boolean addEquip()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter for what knight do you want to add equipment?");
        int ch_elem = scan.nextInt();
        ch_elem -= 1;
        while (ch_elem >= elem1.getSize() || ch_elem < 0)
        {
            System.out.println("Enter again for what knight do you want to add equipment?");
            ch_elem = scan.nextInt();
        }
        double money = elem1.getElem(ch_elem).getAvailable_money();
        if(e.isEmpty())
        {
            return true;
        }
        e.get(ch_elem).printList();
        boolean isHelmet = false;
        boolean isBoots = false;
        boolean isBreastplate = false;
        boolean isShield = false;
        int count_of_chosen = e.get(ch_elem).getSize();
        for(int i = 0;i < e.get(ch_elem).getSize();i++)
        {
            for(int j = 0;j < 1000;j++)
            {
                if(e.get(ch_elem).getElem(i) == list.getElem(j))
                {
                    if(j >= 0 && j < 250)
                    {
                        isHelmet = true;
                    }
                    if(j >= 250 && j < 500)
                    {
                        isBreastplate = true;
                    }
                    if(j >= 500 && j < 750)
                    {
                        isBoots = true;
                    }
                    if(j >= 750)
                    {
                        isShield = true;
                    }
                }
            }
        }
        int ch1 = 1;
        int ch_el;
        while(ch1 != 0 && money > 0)
        {
            System.out.println("Enter what equipment do you want to add for your knight:"
                    + "\nHelmet - 1" + "\nBreastplate - 2" + "\nBoots - 3" + "\nShield - 4" + "\nNext knight or exit - 0");
            ch1 = scan.nextInt();
            if(ch1 == 1 && !isHelmet)
            {
                list.Filter(0,250);
                //list.FilterParam(0,250);
                System.out.println("Enter the number of element that you want to buy:");
                ch_el = scan.nextInt();
                ch_el -= 1;
                while (ch_el > 249 || ch_el < 0)
                {
                    ch_el = scan.nextInt();
                    ch_el -= 1;
                }
                if (money - list.getElem(ch_el).getCost() > 0)
                {
                    money -= list.getElem(ch_el).getCost();
                    e.get(ch_elem).addElem(list.getElem(ch_el),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightHelmet(new Helmet(list.getElem(ch_el).getCost(),list.getElem(ch_el).getWeight(),list.getElem(ch_el).getMaterial(),list.getElem(ch_el).getStrength(),"Closed"),ch_elem);
                    isHelmet = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            if(ch1 == 2 && !isBreastplate)
            {
                list.Filter(250,500);
                //list.FilterParam(250,500);
                System.out.println("Enter the number of element that you want to buy:");
                ch_el = scan.nextInt();
                ch_el -= 1;
                while (ch_el > 499 || ch_el < 250)
                {
                    ch_el = scan.nextInt();
                    ch_el -= 1;
                }
                if (money - list.getElem(ch_el).getCost() > 0) {
                    money -= list.getElem(ch_el).getCost();
                    e.get(ch_elem).addElem(list.getElem(ch_el),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightBreastplate(new Breastplate(list.getElem(ch_el).getCost(),list.getElem(ch_el).getWeight(),list.getElem(ch_el).getMaterial(),list.getElem(ch_el).getStrength(),"HardPlate"),ch_elem);
                    isBreastplate = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            if(ch1 == 3 && !isBoots)
            {
                list.Filter(500,750);
                //list.FilterParam(500,750);
                System.out.println("Enter the number of element that you want to buy:");
                ch_el = scan.nextInt();
                ch_el -= 1;
                while (ch_el > 749 || ch_el < 500)
                {
                    ch_el = scan.nextInt();
                    ch_el -= 1;
                }
                if (money - list.getElem(ch_el).getCost() > 0) {
                    money -= list.getElem(ch_el).getCost();
                    e.get(ch_elem).addElem(list.getElem(ch_el),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightBoots(new Boots(list.getElem(ch_el).getCost(),list.getElem(ch_el).getWeight(),list.getElem(ch_el).getMaterial(),list.getElem(ch_el).getStrength(),true),ch_elem);
                    isBoots = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            if (ch1 == 4 && !isShield)
            {
                list.Filter(750,1000);
                //list.FilterParam(750,1000);
                System.out.println("Enter the number of element that you want to buy:");
                ch_el = scan.nextInt();
                ch_el -= 1;
                while (ch_el > 999 || ch_el < 750)
                {
                    ch_el = scan.nextInt();
                    ch_el -= 1;
                }
                if (money - list.getElem(ch_el).getCost() > 0) {
                    money -= list.getElem(ch_el).getCost();
                    e.get(ch_elem).addElem(list.getElem(ch_el),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightShield(new Shield(list.getElem(ch_el).getCost(),list.getElem(ch_el).getWeight(),list.getElem(ch_el).getMaterial(),list.getElem(ch_el).getStrength(),true,50.0),ch_elem);
                    isShield = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            System.out.println("Available money is:" + money);
            elem1.getElem(ch_elem).setAvailable_money(money);
            Update update = new Update();
            update.UpdateKnight(elem1.getElem(ch_elem));
            Select select = new Select();
            select.SelectKnights();
        }
        e.get(ch_elem).printList();
        return true;
    }
    public boolean addWeapon()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter for what knight do you want to add equipment?");
        int ch_elem = scan.nextInt();
        ch_elem -= 1;
        while (ch_elem >= elem1.getSize() || ch_elem < 0)
        {
            System.out.println("Enter again for what knight do you want to add equipment?");
            ch_elem = scan.nextInt();
        }
        double money = elem1.getElem(ch_elem).getAvailable_money();
        if(w.isEmpty())
        {
            return true;
        }
        w.get(ch_elem).printList();
        boolean isBow = false;
        boolean isSpear = false;
        boolean isHeavy = false;
        boolean isSword = false;
        int count_of_chosen = w.get(ch_elem).getSize();
        for(int i = 0;i < w.get(ch_elem).getSize();i++)
        {
            for(int j = 0;j < 1000;j++)
            {
                if(w.get(ch_elem).getElem(i) == wlist.getElem(j))
                {
                    if(j >= 0 && j < 250)
                    {
                        isBow = true;
                    }
                    if(j >= 250 && j < 500)
                    {
                        isHeavy = true;
                    }
                    if(j >= 500 && j < 750)
                    {
                        isSpear = true;
                    }
                    if(j >= 750)
                    {
                        isSword = true;
                    }
                }
            }
        }
        int ch1 = 1;
        int ch_el;
        while(ch1 != 0 && money > 0)
        {
            System.out.println("Enter what equipment do you want to add for your knight:"
                    + "\nBow - 1" + "\nHeavyWeapon - 2" + "\nSpear - 3" + "\nSword - 4" + "\nNext knight or exit - 0");
            ch1 = scan.nextInt();
            if(ch1 == 1 && !isBow)
            {
                wlist.filtrList(0,250);
                //wlist.FilterParam(0,250);
                System.out.println("Enter the number of element that you want to buy:");
                ch_el = scan.nextInt();
                ch_el -= 1;
                while (ch_el > 249 || ch_el < 0)
                {
                    ch_el = scan.nextInt();
                    ch_el -= 1;
                }
                if (money - wlist.getElem(ch_el).getCost() > 0)
                {
                    money -= wlist.getElem(ch_el).getCost();
                    w.get(ch_elem).addElem(wlist.getElem(ch_el),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightBow(new Bow(wlist.getElem(ch_el).getCost(),wlist.getElem(ch_el).getWeight(),wlist.getElem(ch_el).getType(),wlist.getElem(ch_el).getStrength(),10,true),ch_elem);
                    isBow = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            if(ch1 == 2 && !isHeavy)
            {
                wlist.filtrList(250,500);
                //wlist.FilterParam(250,500);
                System.out.println("Enter the number of element that you want to buy:");
                ch_el = scan.nextInt();
                ch_el -= 1;
                while (ch_el > 499 || ch_el < 250)
                {
                    ch_el = scan.nextInt();
                    ch_el -= 1;
                }
                if (money - wlist.getElem(ch_el).getCost() > 0) {
                    money -= wlist.getElem(ch_el).getCost();
                    w.get(ch_elem).addElem(wlist.getElem(ch_el),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightHeavyWeapon(new HeavyWeapon(wlist.getElem(ch_el).getCost(),wlist.getElem(ch_el).getWeight(),wlist.getElem(ch_el).getType(),wlist.getElem(ch_el).getStrength(),true),ch_elem);
                    isHeavy = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            if(ch1 == 3 && !isSpear)
            {
                wlist.filtrList(500,750);
                //wlist.FilterParam(500,750);
                System.out.println("Enter the number of element that you want to buy:");
                ch_el = scan.nextInt();
                ch_el -= 1;
                while (ch_el > 749 || ch_el < 500)
                {
                    ch_el = scan.nextInt();
                    ch_el -= 1;
                }
                if (money - wlist.getElem(ch_el).getCost() > 0) {
                    money -= wlist.getElem(ch_el).getCost();
                    w.get(ch_elem).addElem(wlist.getElem(ch_el),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightSpear(new Spear(wlist.getElem(ch_el).getCost(),wlist.getElem(ch_el).getWeight(),wlist.getElem(ch_el).getType(),wlist.getElem(ch_el).getStrength(),50.0),ch_elem);
                    isSpear = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            if (ch1 == 4 && !isSword)
            {
                wlist.filtrList(750,1000);
                //wlist.FilterParam(750,1000);
                System.out.println("Enter the number of element that you want to buy:");
                ch_el = scan.nextInt();
                ch_el -= 1;
                while (ch_el > 999 || ch_el < 750)
                {
                    ch_el = scan.nextInt();
                    ch_el -= 1;
                }
                if (money - wlist.getElem(ch_el).getCost() > 0) {
                    money -= wlist.getElem(ch_el).getCost();
                    w.get(ch_elem).addElem(wlist.getElem(ch_el),count_of_chosen);
                    Insert insert = new Insert();
                    insert.InsertKnightSword(new Sword(wlist.getElem(ch_el).getCost(),wlist.getElem(ch_el).getWeight(),wlist.getElem(ch_el).getType(),wlist.getElem(ch_el).getStrength(),true,50.0),ch_elem);
                    isSword = true;
                    count_of_chosen++;
                }
                else
                {
                    System.out.println("You have not enough money , try to choose another equipment");
                }
            }
            System.out.println("Available money is:" + money);
            elem1.getElem(ch_elem).setAvailable_money(money);
            Update update = new Update();
            update.UpdateKnight(elem1.getElem(ch_elem));
            Select select = new Select();
            select.SelectKnights();
        }
        w.get(ch_elem).printList();
        return true;
    }
}


