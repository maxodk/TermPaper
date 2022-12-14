package command;

import data.EquipmentData;
import data.KnightData;
import data.WeaponData;
import database.Select;
import equipment.Equipment;

import java.util.ArrayList;

public class CalculateData implements InterfaceConsole {
    private KnightData elem1;
    private ArrayList<EquipmentData> e;
    private ArrayList<WeaponData> w;
    @Override
    public CommandResult<String> execute() throws Exception {
        for(int i = 0;i < elem1.getSize();i++)
        {
            System.out.println("The " + (i + 1) + "knight is\n" +elem1.getElem(i));
            System.out.println("Equipment of knight:");
            if(e.size() > i)
            {
                e.get(i).sortAndPrint();
            }
            else
            {
                e.add(i,new EquipmentData());
                e.get(i).sortAndPrint();
            }
            Select select = new Select();
            select.SelectKnightEquip((i + 1));
            System.out.println("Weapons of knight:");
            if(w.size() > i)
            {
                w.get(i).sortAndPrint();
            }
            else
            {
                w.add(i,new WeaponData());
                w.get(i).sortAndPrint();
            }
            System.out.println("\n----------------------------\n");
        }
        System.out.println("Calculating data works!");
        CommandResult<String> result = new CommandResult<String>("Succeed!!!!!","Calculating data works!",true);
        return result;
    }

    public CalculateData(KnightData elem1,  ArrayList<EquipmentData> e,  ArrayList<WeaponData> w) {
        this.elem1 = elem1;
        this.e = e;
        this.w = w;
    }
}


