package equipment;

public class Shield extends Equipment{
    private Boolean isCrooked;
    private Double protection;
    public Shield(double cost, double weight, String material, double strength,boolean isCrooked,double protection) {
        super(cost, weight, material, strength);
        this.isCrooked = isCrooked;
        this.protection = protection;
    }
    public boolean getIsCrooked() {
        return isCrooked;
    }

    public void setCrooked(boolean crooked) {
        isCrooked = crooked;
    }

    public Double getProtection() {
        return protection;
    }

    public void setProtection(Double protection) {
        this.protection = protection;
    }

    @Override
    public String toString() {
        return "Shield{" +
                "isCrooked=" + isCrooked +
                ", protection=" + protection +
                ", cost=" + cost +
                ", weight=" + weight +
                ", material='" + material + '\'' +
                ", strength=" + strength +
                '}';
    }
}


