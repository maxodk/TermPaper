package command;

import data.EquipmentData;
import data.KnightData;
import data.WeaponData;
import database.Delete;
import database.Select;
import database.Update;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteEquipment implements InterfaceConsole{
    private KnightData elem1;
    private EquipmentData list;
    private ArrayList<EquipmentData> e;
    private WeaponData wlist;
    private ArrayList<WeaponData> w;
    @Override
    public CommandResult<String> execute() throws Exception {
        Scanner scan = new Scanner(System.in);
        if(elem1.getSize() == 0)
        {
            System.out.println("Deleting failed!You dont have any knight for deleting");
            return new CommandResult<String>("Failed!!!!!","Deleting failed!You dont have any knight for deleting",true);
        }
        System.out.println("For what knight do you want to delete equipment?");
        int ch_elem = scan.nextInt();
        while (ch_elem >= elem1.getSize() || ch_elem < 0)
        {
            System.out.println("Enter again for what knight do you want to delete equipment?");
            ch_elem = scan.nextInt();
        }
        System.out.println("Choose what you want to delete:equipment or weapon?");
        int ch = scan.nextInt();
        if(ch == 0)
        {
            delEquip(ch_elem);
        }
        if (ch == 1)
        {
            delWeapon(ch_elem);
        }
        System.out.println("Deleting works!");
        CommandResult<String> result = new CommandResult<String>("Succeed!!!!!","Deleting works!",true);
        return result;
    }

    public DeleteEquipment(KnightData elem1, EquipmentData list, ArrayList<EquipmentData> e,WeaponData wlist,ArrayList<WeaponData> w) {

        this.elem1 = elem1;
        this.list = list;
        this.e = e;
        this.wlist = wlist;
        this.w = w;
    }
    public void delEquip(int ch_elem)
    {
        Scanner scan = new Scanner(System.in);
        e.get(ch_elem).printList();
        int ch = 1;
        int countofequip = e.get(ch_elem).getSize();
        while (ch != 0)
        {
            if (countofequip == 0)
            {
                break;
            }
            System.out.println("Enter the number of element that you want to delete?(0 - exit)");
            ch = scan.nextInt();
            if(ch > 0)
            {
                elem1.getElem(ch_elem).setAvailable_money(e.get(ch_elem).getElem(ch - 1).getCost() + elem1.getElem(ch_elem).getAvailable_money());
                Update update = new Update();
                update.UpdateKnight(elem1.getElem(ch_elem));
                Select select = new Select();
                select.SelectKnights();
                for(int i = 0;i < 1000;i++)
                {
                    if(e.get(ch_elem).getElem(ch - 1).getCost() == list.getElem(i).getCost())
                    {
                        Delete delete = new Delete();
                        delete.DeleteKnightEquipment(i,e.get(ch_elem).getElem(ch - 1).getCost());
                        break;
                    }
                }
                e.get(ch_elem).deleteElem(ch - 1);

                e.get(ch_elem).printList();
                countofequip -= 1;
            }
        }
        e.get(ch_elem).printList();
        System.out.println("Available money is " + elem1.getElem(ch_elem).getAvailable_money());
    }
    public void delWeapon(int ch_elem)
    {
        Scanner scan = new Scanner(System.in);
        w.get(ch_elem).printList();
        int ch = 1;
        int countofequip = w.get(ch_elem).getSize();
        while (ch != 0)
        {
            if (countofequip == 0)
            {
                break;
            }
            System.out.println("Enter the number of element that you want to delete?(0 - exit)");
            ch = scan.nextInt();
            if(ch > 0)
            {
                elem1.getElem(ch_elem).setAvailable_money(w.get(ch_elem).getElem(ch - 1).getCost() + elem1.getElem(ch_elem).getAvailable_money());
                Update update = new Update();
                update.UpdateKnight(elem1.getElem(ch_elem));
                Select select = new Select();
                select.SelectKnights();
                for(int i = 0;i < 1000;i++)
                {
                    if(w.get(ch_elem).getElem(ch - 1).getCost() == wlist.getElem(i).getCost())
                    {
                        Delete delete = new Delete();
                        delete.DeleteKnightWeapon(i,w.get(ch_elem).getElem(ch - 1).getCost());
                        break;
                    }
                }
                w.get(ch_elem).deleteElem(ch - 1);
                w.get(ch_elem).printList();
                countofequip -= 1;
            }
        }
        w.get(ch_elem).printList();
        System.out.println("Available money is " + elem1.getElem(ch_elem).getAvailable_money());
    }
}
