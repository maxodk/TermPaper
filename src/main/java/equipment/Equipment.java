package equipment;

public class Equipment {
    protected double cost;
    protected double weight;
    protected String material;
    protected double strength;

    public Equipment(double cost, double weight, String material, double strength) {
        this.cost = cost;
        this.weight = weight;
        this.material = material;
        this.strength = strength;
        if (this.strength > 1.0)
        {
            this.strength = 1.0;
        }
    }
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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
                "\nMaterial='" + material + '\'' +
                "\nStrength=" + strength + "\n";
    }
}


