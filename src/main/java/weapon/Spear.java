package weapon;

public class Spear extends Weapon{
    private double length;
    public Spear(double cost, double weight, String type, double strength,double length) {
        super(cost, weight, type, strength);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Spear{" +
                "length=" + length +
                ", cost=" + cost +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                ", strength=" + strength +
                '}';
    }
}


