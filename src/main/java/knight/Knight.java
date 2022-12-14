package knight;

import java.util.Scanner;

public class Knight
{
    private String name;
    private int age;
    private double available_money;
    public Knight(String name, int age, double available_money) {
        this.name = name;
        this.age = age;
        this.available_money = available_money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAvailable_money() {
        return available_money;
    }

    public void setAvailable_money(double available_money) {
        this.available_money = available_money;
    }

    public String toString() {
        return "Knight{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", available_money=" + available_money +
                '}';
    }
}


