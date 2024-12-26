import java.util.List;

class Infanterie extends Unite  {
    protected String type;

    public Infanterie(List<Unite> unites, String nom, int cout, String nom1, int cout1, String type) {
        super(unites, nom, cout, nom1, cout1);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Infanterie{" +
                "type='" + type + '\'' +
                ", nom='" + nom + '\'' +
                ", cout=" + cout +
                '}';
    }
}