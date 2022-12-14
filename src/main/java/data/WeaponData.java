package data;

import database.Insert;
import equipment.Equipment;
import equipment.Helmet;
import weapon.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WeaponData {
    private ArrayList<Weapon> list = new ArrayList<>();
    public void addElem(Weapon elem,int i)
    {
        this.list.add(i,elem);
    }
    public Weapon getElem(int i)
    {
        return this.list.get(i);
    }
    public void choseBow(Weapon elem,int i)
    {
        list.add(i,new Bow(elem.getCost(),elem.getWeight(), elem.getType(), elem.getStrength(),10,true ));
        //System.out.println(list.get(i));
        Insert insert = new Insert();
        insert.InsertBow(new Bow(elem.getCost(),elem.getWeight(), elem.getType(), elem.getStrength(),10,true ));
    }
    public void choseHeavyWeapon(Weapon elem,int i)
    {
        list.add(i,new HeavyWeapon(elem.getCost(),elem.getWeight(), elem.getType(), elem.getStrength(),true ));
        //System.out.println(list.get(i));
        Insert insert = new Insert();
        insert.InsertHeavyWeapon(new HeavyWeapon(elem.getCost(),elem.getWeight(), elem.getType(), elem.getStrength(),true ));
    }
    public void choseSpear(Weapon elem,int i)
    {
        list.add(i,new Spear(elem.getCost(),elem.getWeight(), elem.getType(), elem.getStrength(),50.0 ));
        //System.out.println(list.get(i));
        Insert insert = new Insert();
        insert.InsertSpear(new Spear(elem.getCost(),elem.getWeight(), elem.getType(), elem.getStrength(),50.0 ));
    }
    public void choseSword(Weapon elem,int i)
    {
        list.add(i,new Sword(elem.getCost(),elem.getWeight(), elem.getType(), elem.getStrength(),true ,50.0));
        //System.out.println(list.get(i));
        Insert insert = new Insert();
        insert.InsertSword(new Sword(elem.getCost(),elem.getWeight(), elem.getType(), elem.getStrength(),true ,50.0));
    }
    public ArrayList<Weapon> fillList()
    {
        Random rand = new Random();
        for(int i = 0;i < 1000;i++)
        {
            double cost = rand.nextDouble(1000.0) + 1.0;
            double weight = rand.nextDouble(50.0) + 1.0;
            int mat = rand.nextInt(5) + 1;
            String type = null;
            switch (mat)
            {
                case 1:
                    type = "Steel";
                    break;
                case 2:
                    type = "Silver";
                    break;
                case 3:
                    type = "Gold";
                    break;
                case 4:
                    type = "Titan";
                    break;
                case 5:
                    type = "Wolfram";
                    break;
                default:
                    break;
            }
            double strength = rand.nextDouble(1.0);
            Weapon e = new Weapon(cost,weight,type,strength);
            if(i < 250)
            {
                choseBow(e,i);
            }
            if(i >= 250 && i < 500)
            {
                choseHeavyWeapon(e,i);
            }
            if(i >= 500 && i < 750)
            {
                choseSpear(e,i);
            }
            if(i >= 750) {
                choseSword(e,i);
            }
        }
        return this.list;
    }
    public void printList()
    {
        for(int i = 0;i < list.size();i++)
        {
            System.out.println((i+1) + "\n" + list.get(i).toString());
        }
    }
    public void filtrList(int limit1,int limit2)
    {
        for(int i = limit1;i < limit2;i++)
        {
            System.out.println((i+1) + "\n" + list.get(i).toString());
        }
    }
    public int getSize()
    {
        return this.list.size();
    }
    public void deleteElem(int i)
    {
        list.remove(i);
    }
    public double getSummaryCost()
    {
        double sum = 0.0;
        for(int i = 0;i < this.list.size();i++)
        {
            sum += list.get(i).getCost();
        }
        return sum;
    }
    public void sortAndPrint()
    {
        Comparator<Weapon> ByWeight = Comparator.comparing(Weapon::getWeight);
        list.sort(ByWeight);
        for(int i = 0;i < list.size();i++)
        {
            System.out.println((i+1) + "\n" + list.get(i).toString());
        }
    }
    public void FilterParam(int limit1,int limit2)
    {
        Scanner scan = new Scanner(System.in);
        boolean isCost = false;
        boolean isWeight = false;
        boolean isType = false;
        boolean isStr = false;
        int ch = 1;
        while(ch != 0)
        {
            System.out.println("What param you want to filter:\ncost - 1\nweight - 2\nmaterial-3\nstrength - 4\nexit - 0");
            ch = scan.nextInt();
            switch (ch)
            {
                case 1:
                    isCost = true;
                    break;
                case 2:
                    isWeight = true;
                    break;
                case 3:
                    isType = true;
                    break;
                case 4:
                    isStr = true;
                    break;
            }
        }
        double cost,weight,strength;
        String type;
        int is;
        if(isCost)
        {
            System.out.println("Enter what is limit of cost:");
            cost = scan.nextDouble();
            System.out.println("Enter its must more than cost or less?(1 or 0)");
            is = scan.nextInt();
            if(is == 0)
            {
                ArrayList<Weapon> Filtr = (ArrayList<Weapon>) list.stream().filter(n -> n.getCost() < cost).collect(Collectors.toList());

                for (int i = 0;i < Filtr.size();i++)
                {
                    for(int j = limit1;j < limit2;j++)
                    {
                        if(Filtr.get(i) == list.get(j))
                        {
                            System.out.println((j+1) + "\n" + list.get(j).toString());
                        }
                    }
                }
            }
            else
            {
                ArrayList<Weapon> Filtr = (ArrayList<Weapon>) list.stream().filter(n -> n.getCost() > cost).collect(Collectors.toList());

                for (int i = 0;i < Filtr.size();i++)
                {
                    for(int j = limit1;j < limit2;j++)
                    {
                        if(Filtr.get(i) == list.get(j))
                        {
                            System.out.println((j+1) + "\n" + list.get(j).toString());
                        }
                    }
                }
            }
        }
        if(isWeight)
        {
            System.out.println("Enter what is limit of weight:");
            weight = scan.nextDouble();
            System.out.println("Enter its must more than cost or less?(1 or 0)");
            is = scan.nextInt();
            if (is == 0)
            {
                ArrayList<Weapon> Filtr = (ArrayList<Weapon>) list.stream().filter(n -> n.getWeight() < weight).collect(Collectors.toList());
                for (int i = 0; i < Filtr.size(); i++)
                {
                    for (int j = limit1; j < limit2; j++)
                    {
                        if (Filtr.get(i) == list.get(j))
                        {
                            System.out.println((j + 1) + "\n" + list.get(j).toString());
                        }
                    }
                }
            }
            else
            {
                ArrayList<Weapon> Filtr = (ArrayList<Weapon>) list.stream().filter(n -> n.getWeight() > weight).collect(Collectors.toList());
                for (int i = 0; i < Filtr.size(); i++)
                {
                    for (int j = limit1; j < limit2; j++)
                    {
                        if (Filtr.get(i) == list.get(j))
                        {
                            System.out.println((j + 1) + "\n" + list.get(j).toString());
                        }
                    }
                }
            }
        }
        if(isType)
        {
            System.out.println("Enter what is type:");
            type = scan.next();
            ArrayList<Weapon> Filtr = (ArrayList<Weapon>) list.stream().filter(n -> n.getType().equals(type)).collect(Collectors.toList());
            for (int i = 0; i < Filtr.size(); i++)
            {
                for (int j = limit1; j < limit2; j++)
                {
                    if (Filtr.get(i) == list.get(j))
                    {
                        System.out.println((j + 1) + "\n" + list.get(j).toString());
                    }
                }
            }
        }
        if(isStr)
        {
            System.out.println("Enter what is limit of strength:");
            strength = scan.nextDouble();
            System.out.println("Enter its must more than cost or less?(1 or 0)");
            is = scan.nextInt();
            if(is == 0)
            {
                ArrayList<Weapon> Filtr = (ArrayList<Weapon>) list.stream().filter(n -> n.getStrength() < strength).collect(Collectors.toList());

                for (int i = 0;i < Filtr.size();i++)
                {
                    for(int j = limit1;j < limit2;j++)
                    {
                        if(Filtr.get(i) == list.get(j))
                        {
                            System.out.println((j+1) + "\n" + list.get(j).toString());
                        }
                    }
                }
            }
            else
            {
                ArrayList<Weapon> Filtr = (ArrayList<Weapon>) list.stream().filter(n -> n.getStrength() > strength).collect(Collectors.toList());

                for (int i = 0;i < Filtr.size();i++)
                {
                    for(int j = limit1;j < limit2;j++)
                    {
                        if(Filtr.get(i) == list.get(j))
                        {
                            System.out.println((j+1) + "\n" + list.get(j).toString());
                        }
                    }
                }
            }
        }
    }
}


