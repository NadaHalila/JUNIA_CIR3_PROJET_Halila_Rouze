import java.util.List;

class Vehicule extends Unite {
    protected String type;

    public Vehicule(List<Unite> unites, String nom, int cout, String nom1, int cout1, String type) {
        super(unites, nom, cout, nom1, cout1);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "type='" + type + '\'' +
                ", nom='" + nom + '\'' +
                ", cout=" + cout +
                '}';
    }
}

