package equipment;

public class Boots extends Equipment {
    private Boolean isGaiters;
    public Boots(double cost, double weight, String material, double strength,boolean isGaiters) {
        super(cost, weight, material, strength);
        this.isGaiters = isGaiters;
    }

    public boolean getIsGaiters() {
        return isGaiters;
    }

    public void setGaiters(boolean gaiters) {
        isGaiters = gaiters;
    }

    @Override
    public String toString() {
        return "Boots{" +
                "getIsGaiters=" + isGaiters +
                ", cost=" + cost +
                ", weight=" + weight +
                ", material='" + material + '\'' +
                ", strength=" + strength +
                '}';
    }
}

