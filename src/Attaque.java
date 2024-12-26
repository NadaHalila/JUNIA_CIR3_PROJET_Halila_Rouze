import java.util.List;

class Attaque extends Vehicule {

    public Attaque(List<Unite> unites, String nom, int cout, String nom1, int cout1, String type) {
        super(unites, nom, cout, nom1, cout1, type);
    }

    @Override
    public String toString() {
        return "Attaque{" +
                "type='" + type + '\'' +
                ", nom='" + nom + '\'' +
                ", cout=" + cout +
                '}';
    }

}
