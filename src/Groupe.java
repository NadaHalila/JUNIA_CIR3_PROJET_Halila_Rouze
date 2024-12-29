
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Groupe {
    private List<Unite> unites ;
    protected String nom;
    protected int cout;

    public Groupe(List<Unite> unites, String nom, int cout) {
        this.unites = unites;
        this.nom = nom;
        this.cout = cout;
    }

    public List<Unite> getUnites() {
        return unites;
    }

    public void setUnites(List<Unite> unites) {
        this.unites = unites;
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

    public void add_unite(Unite unite) {
        unites.add(unite);
    }
    public void remove_unite_index(int index) {
        if (index >= 0 && index < unites.size()) {
            unites.remove(index);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}
