package weapon;

public class Weapon {
    protected double cost;
    protected double weight;
    protected String type;
    protected double strength;

    public Weapon(double cost, double weight, String type, double strength) {
        this.cost = cost;
        this.weight = weight;
        this.type = type;
        this.strength = strength;
        if (this.strength > 1.0)
        {
            this.strength = 1.0;
        }
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getStrength() {
        return strength;
    }


    public void setStrength(double strength) {
        this.strength = strength;
    }
    public double ReturnCost()
    {
        return this.cost * this.strength;
    }

    public String toString() {
        return "\nEquipment "  + ":\n" +
                "Cost=" + cost +
                "\nWeight=" + weight +
                "\nType='" + type + '\'' +
                "\nStrength=" + strength + "\n";
    }
}

