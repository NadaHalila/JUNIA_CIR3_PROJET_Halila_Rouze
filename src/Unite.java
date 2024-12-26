import java.util.List;

public class Unite extends Groupe {
    protected String nom;
    protected int cout;


    public Unite(List<Unite> unites, String nom, int cout, String nom1, int cout1) {
        super(unites, nom, cout);
        this.nom = nom1;
        this.cout = cout1;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        
        this.nom = nom;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }
}
