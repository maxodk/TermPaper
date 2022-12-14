package weapon;

public class HeavyWeapon extends Weapon{
    private boolean isSpiked;

    public HeavyWeapon(double cost, double weight, String type, double strength,boolean isSpiked) {
        super(cost, weight, type, strength);
        this.isSpiked = isSpiked;
    }

    public boolean getIsSpiked() {
        return isSpiked;
    }

    public void setSpiked(boolean spiked) {
        isSpiked = spiked;
    }

    @Override
    public String toString() {
        return "HeavyWeapon{" +
                "isSpiked=" + isSpiked +
                ", cost=" + cost +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                ", strength=" + strength +
                '}';
    }
}

