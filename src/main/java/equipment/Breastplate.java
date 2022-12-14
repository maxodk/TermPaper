package equipment;

public class Breastplate extends Equipment {
    private String armor;
    public Breastplate(double cost, double weight, String material, double strength,String armor) {
        super(cost, weight, material, strength);
        this.armor = armor;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "Breastplate{" +
                "armor='" + armor + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", material='" + material + '\'' +
                ", strength=" + strength +
                '}';
    }
}

