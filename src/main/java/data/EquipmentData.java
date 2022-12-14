package data;

import database.Insert;
import equipment.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class EquipmentData {

    private ArrayList<Equipment> list = new ArrayList<>();
    public void addElem(Equipment elem,int i){
        this.list.add(i,elem);
    }
    public void choseHelmet(Equipment elem,int i)
    {
        list.add(i,new Helmet(elem.getCost(),elem.getWeight(), elem.getMaterial(), elem.getStrength(),"Closed" ));
        //System.out.println(list.get(i));
        Insert insert = new Insert();
        insert.InsertHelmets(new Helmet(elem.getCost(),elem.getWeight(), elem.getMaterial(), elem.getStrength(),"Closed" ));
        //insert.HelmetsList(new Helmet(elem.getCost(),elem.getWeight(), elem.getMaterial(), elem.getStrength(),"Closed" ),i+1);
    }
    public void chooseBreastplate(Equipment elem,int i)
    {
        list.add(i,new Breastplate(elem.getCost(),elem.getWeight(), elem.getMaterial(), elem.getStrength(),"HardPlate" ));
        Insert insert = new Insert();
        insert.InsertBreastplate(new Breastplate(elem.getCost(),elem.getWeight(), elem.getMaterial(), elem.getStrength(),"HardPlate" ));
    }
    public void chooseBoots(Equipment elem,int i)
    {
        list.add(i,new Boots(elem.getCost(),elem.getWeight(), elem.getMaterial(), elem.getStrength(),true));
        Insert insert = new Insert();
        insert.InsertBoots(new Boots(elem.getCost(),elem.getWeight(), elem.getMaterial(), elem.getStrength(),true));
    }
    public void chooseShield(Equipment elem,int i)
    {
        list.add(i,new Shield(elem.getCost(),elem.getWeight(), elem.getMaterial(), elem.getStrength(),true,50.0));
        Insert insert = new Insert();
        insert.InsertShield(new Shield(elem.getCost(),elem.getWeight(), elem.getMaterial(), elem.getStrength(),true,50.0));
    }
    public ArrayList<Equipment> fillEquipment()
    {
        Random rand = new Random();
        for(int i = 0;i < 1000;i++)
        {
            double cost = rand.nextDouble(1000.0) + 1.0;
            double weight = rand.nextDouble(50.0) + 1.0;
            int mat = rand.nextInt(5) + 1;
            String material = null;
            switch (mat)
            {
                case 1:
                    material = "Steel";
                    break;
                case 2:
                    material = "Silver";
                    break;
                case 3:
                    material = "Gold";
                    break;
                case 4:
                    material = "Titan";
                    break;
                case 5:
                    material = "Wolfram";
                    break;
                default:
                    break;
            }
            double strength = rand.nextDouble(1.0);
            Equipment e = new Equipment(cost,weight,material,strength);
            if(i < 250)
            {
                choseHelmet(e,i);
            }
            if(i >= 250 && i < 500)
            {
                chooseBreastplate(e,i);
            }
            if(i >= 500 && i < 750)
            {
                chooseBoots(e,i);
            }
            if(i >= 750) {
                chooseShield(e,i);
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
    public void Filter(int limit1,int limit2)
    {
        for(int i = limit1;i < limit2;i++)
        {
            System.out.println((i+1) + "\n" + list.get(i).toString());
        }
    }
    public void FilterParam(int limit1,int limit2)
    {
        Scanner scan = new Scanner(System.in);
        boolean isCost = false;
        boolean isWeight = false;
        boolean isMat = false;
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
                    isMat = true;
                    break;
                case 4:
                    isStr = true;
                    break;
                default:
                    break;
            }
        }
        double cost,weight,strength;
        String material;
        int is;
        if(isCost)
        {
            System.out.println("Enter what is limit of cost:");
            cost = scan.nextDouble();
            System.out.println("Enter its must more than cost or less?(1 or 0)");
            is = scan.nextInt();
            if(is == 0)
            {
                ArrayList<Equipment> Filtr = (ArrayList<Equipment>) list.stream().filter(n -> n.getCost() < cost).collect(Collectors.toList());

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
                ArrayList<Equipment> Filtr = (ArrayList<Equipment>) list.stream().filter(n -> n.getCost() > cost).collect(Collectors.toList());

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
                ArrayList<Equipment> Filtr = (ArrayList<Equipment>) list.stream().filter(n -> n.getWeight() < weight).collect(Collectors.toList());
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
                ArrayList<Equipment> Filtr = (ArrayList<Equipment>) list.stream().filter(n -> n.getWeight() > weight).collect(Collectors.toList());
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
        if(isMat)
        {
            System.out.println("Enter what is material:");
            material = scan.next();
            ArrayList<Equipment> Filtr = (ArrayList<Equipment>) list.stream().filter(n -> n.getMaterial().equals(material)).collect(Collectors.toList());
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
                ArrayList<Equipment> Filtr = (ArrayList<Equipment>) list.stream().filter(n -> n.getStrength() < strength).collect(Collectors.toList());

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
                ArrayList<Equipment> Filtr = (ArrayList<Equipment>) list.stream().filter(n -> n.getStrength() > strength).collect(Collectors.toList());

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
    public Equipment getElem(int i)
    {
        return list.get(i);
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
        Comparator<Equipment> ByWeight = Comparator.comparing(Equipment::getWeight);
        list.sort(ByWeight);
        for(int i = 0;i < list.size();i++)
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
}


