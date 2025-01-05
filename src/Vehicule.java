import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

// Classe pour les véhicules
class Vehicule extends Unite {
    protected String type;

    public Vehicule(List<Unite> unites, String nom, int cout, String nom1, int cout1, String type) {
        super(unites, nom, cout, nom1, cout1);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicule : " +
                 type + " - " +
                nom + " ( " +
                 cout +
                " pts ) ";
    }
}


// Enumération des types de véhicules
enum TypeVehicule {
    ATTAQUE(Attaque.class),
    TRANSPORT(Transport.class);

    private final Class<?> associatedClass; // Déclaration du champ

    TypeVehicule(Class<?> associatedClass) {
        this.associatedClass = associatedClass;
    }

    public Class<?> getAssociatedClass() {
        return associatedClass;
    }
    public Vehicule createInstance(Groupe army_groupe,String nom, int cout ) {
        Scanner sc = new Scanner(System.in);
        try {
            if (this == TRANSPORT) {
                System.out.print("Entrez le poids du véhicule de transport : ");
                int poids = sc.nextInt();
                return new Transport(army_groupe.getUnites(),army_groupe.getNom(), army_groupe.getCout(),nom, cout,"Transport", poids);//a changer
            }
            return new Attaque(army_groupe.getUnites(),army_groupe.getNom(), army_groupe.getCout(),nom, cout,"Attaque");
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la création du véhicule : " + e.getMessage(), e);
        }
    }
}

