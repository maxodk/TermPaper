package equipment;

public class Helmet extends Equipment {
    private String typeofarmoring;
    public Helmet(double cost, double weight, String material,double strength,String typeofarmoring) {
        super(cost, weight, material,strength);
        this.typeofarmoring = typeofarmoring;
    }
    public String getTypeofarmoring() {
        return typeofarmoring;
    }
    public void setTypeofarmoring(String typeofarmoring) {
        this.typeofarmoring = typeofarmoring;
    }

    @Override
    public String toString() {
        return "Helmet{" +
                "typeofarmoring='" + typeofarmoring + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", material='" + material + '\'' +
                ", strength=" + strength +
                '}';
    }
}


