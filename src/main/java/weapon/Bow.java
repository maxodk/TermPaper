package weapon;

public class Bow extends Weapon{
    private int countofarrows;
    private boolean isLong;

    public Bow(double cost, double weight, String type, double strength,int countofarrows,boolean isLong) {
        super(cost, weight, type, strength);
        this.countofarrows = countofarrows;
        this.isLong = isLong;
    }

    public int getCountofarrows() {
        return countofarrows;
    }

    public void setCountofarrows(int countofarrows) {
        this.countofarrows = countofarrows;
    }

    public boolean getIsLong() {
        return isLong;
    }

    public void setLong(boolean aLong) {
        isLong = aLong;
    }

    @Override
    public String toString() {
        return "Bow{" +
                "countofarrows=" + countofarrows +
                ", isLong=" + isLong +
                ", cost=" + cost +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                ", strength=" + strength +
                '}';
    }
}

