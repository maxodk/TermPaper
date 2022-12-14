package weapon;

public class Sword extends  Weapon{
    private boolean isCrooked;
    private double sharpness;
    public Sword(double cost, double weight, String type, double strength,boolean isCrooked,double sharpness) {
        super(cost, weight, type, strength);
        this.isCrooked = isCrooked;
        this.sharpness = sharpness;
    }

    public boolean getIsCrooked() {
        return isCrooked;
    }

    public void setCrooked(boolean crooked) {
        isCrooked = crooked;
    }

    public double getSharpness() {
        return sharpness;
    }

    public void setSharpness(double sharpness) {
        this.sharpness = sharpness;
    }

    @Override
    public String toString() {
        return "Sword{" +
                "isCrooked=" + isCrooked +
                ", sharpness=" + sharpness +
                ", cost=" + cost +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                ", strength=" + strength +
                '}';
    }
}


