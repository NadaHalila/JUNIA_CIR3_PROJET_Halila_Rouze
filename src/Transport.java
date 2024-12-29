import java.util.List;

class Transport extends Vehicule  {
    protected int poid;

    public Transport(List<Unite> unites, String nom, int cout, String nom1, int cout1, String type, int poid) {
        super(unites, nom, cout, nom1, cout1, type);
        this.poid = poid;
    }


    @Override
    public String toString() {
        return "Transport{" +
                "poid=" + poid +
                ", type='" + type + '\'' +
                ", nom='" + nom + '\'' +
                ", cout=" + cout +
                ", nom='" + nom + '\'' +
                ", cout=" + cout +
                '}';
    }
}
