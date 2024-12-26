import java.util.List;

class Transport extends Vehicule  {
    protected int cout;

    public Transport(List<Unite> unites, String nom, int cout, String nom1, int cout1, String type, int cout2) {
        super(unites, nom, cout, nom1, cout1, type);
        this.cout = cout2;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "cout=" + cout +
                ", type='" + type + '\'' +
                ", nom='" + nom + '\'' +
                ", cout=" + cout +
                '}';
    }
}
