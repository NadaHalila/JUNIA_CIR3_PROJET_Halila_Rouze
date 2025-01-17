import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

interface unite_type{
    String unite_get_type_name();
}

public class Armee {

    static Groupe creation_armee() {
        List<Unite> New_army_groupe= new ArrayList<>() ;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nom de l'armée : ");
        String nom = sc.nextLine();
        System.out.print("Points maximum de l'armée : ");
        int pointsMax = sc.nextInt();
        System.out.println(BLEU+"============================================================================"+RESET);
        System.out.println("Votre armee "+VERT+nom+RESET+" avec "+VERT+pointsMax+RESET+" points a été cree avec succes");
        System.out.println(BLEU+"============================================================================"+RESET);

        return new Groupe(New_army_groupe,nom,pointsMax);
    }

    static Groupe ajout_unite(Groupe army_groupe,int nb) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nom de l'unité : ");
        String nom = sc.nextLine();
        System.out.print("Le coût de l'unité : ");
        int cout = sc.nextInt();
        if (army_groupe.getCout()-cout <=0){

            System.out.println("Le coût de l'uniter est elever ");
            System.out.print("Le coût de l'unité doit etre inferieur au cout de l'armée : ");
            cout = sc.nextInt();

        }
        if (nb==1){
            System.out.print("Type de l'unite d'infanterie:   " + '\n');
            int i =1;
            for( TypeInfanterie type : TypeInfanterie.values()){
                System.out.println( VERT+i+RESET+ "- Type : " + type);
                i++;
            }
            int index = sc.nextInt();
            Infanterie new_Unite=new Infanterie(army_groupe.getUnites(),army_groupe.getNom(), army_groupe.getCout(), nom, cout,TypeInfanterie.values()[index-1]);
            //System.out.println( new_Unite.toString());
            army_groupe.add_unite(new_Unite);
            System.out.println("Unité ajoutée : " + new_Unite);
            army_groupe.setCout(army_groupe.getCout()-new_Unite.getCout());

        }
        if (nb==2){

            System.out.print("type de l'unité de vehicule:  \n");
            int i =1;
            for( TypeVehicule type : TypeVehicule.values()){
                System.out.println( VERT+i+RESET+ "- Type : " + type);
                i++;
            }
            int index = sc.nextInt();
            // creation de la classe en fonction du choix de type :
            TypeVehicule typeVehicule = TypeVehicule.values()[index - 1];
            Vehicule newUnite = typeVehicule.createInstance(army_groupe,nom, cout);
            army_groupe.add_unite(newUnite);
            System.out.println("Unité ajoutée : " + newUnite);
        }
         return army_groupe;
    }

    static void afficher_unite(Groupe army_groupe) {
        System.out.println("Armée :"+army_groupe.getNom()+"\n"+
                "Coût lors de la création : "+army_groupe.getCout_lors_de_creation()+"\n"+
                "Coût restant: "+army_groupe.getCout());
        for (Unite unite : army_groupe.getUnites()) {
            if (unite instanceof Infanterie) {
                Infanterie infanterie = (Infanterie) unite;
                System.out.println("- Infanterie : " + infanterie.TypeInfanterie + " - " + infanterie.getNom() + " (" + infanterie.getCout() + " pts)");
            } else if (unite instanceof Transport) {
                Transport transport = (Transport) unite;
                System.out.println("- Transport : " + transport.type + " - " + transport.getNom() + " (" + transport.getCout() + " pts, capacité: " + transport.poid + ")");
            } else if (unite instanceof Vehicule) {
                Vehicule vehicule = (Vehicule) unite;
                System.out.println("- Véhicule : " + vehicule.type + " - " + vehicule.getNom() + " (" + vehicule.getCout() + " pts)");
            } else {
                // Pour d'autres types non définis explicitement
                System.out.println("- Unité : " + unite.getNom() + " (" + unite.getCout() + " pts)");
            }
        }
    }
    public static final String RESET = "\u001B[0m";  // Réinitialisation
    public static final String ROUGE = "\u001B[31m"; // Rouge
    public static final String VERT = "\u001B[32m";  // Vert
    public static final String JAUNE = "\u001B[33m"; // Jaune
    public static final String BLEU = "\u001B[34m";  // Bleu


    public static void main(String[] args) {

        int action;
        int uniter;
        int suppression;
        ArrayList<Groupe> armees = new ArrayList<>();

        System.out.println(BLEU+"Bienvenue dans l'éditeur de liste d'armée !" + '\n' +
        "Pour commencer vous allez crée votre première armée " + '\n' +
                "Un conseil passez en mode pleine ecran cela rendra votre experience de jeu plus agréable !! "+RESET);
        Groupe nouveau_armee=creation_armee();
        armees.add(nouveau_armee);

        do {
            System.out.println('\n' + "Que voulez vous faire maintenant ? ");
            System.out.println(VERT+"1-"+RESET +"Crée un nouveau groupe d'armée" + '\n'+
                    VERT+"2-"+RESET +" afficher le contenu des armée" + '\n' +
                    VERT+"3-"+RESET +"ajouter une untié dans une armée " + '\n' +
                    VERT+"4-"+RESET +"supprimer une untié  " + '\n'+
                    VERT+"0-"+RESET +" arreter le programme " + '\n'+
                    VERT+"Entrer le chiffre correspond à l'action souhaiter: "+RESET);
            Scanner sc = new Scanner(System.in);
            action = sc.nextInt();

            if (action == 1) {
                Groupe armee=creation_armee();
                armees.add(armee);
            }

            else if (action ==2 ){
                System.out.println(JAUNE+"Le contenue des armée");
                for (int k=0; k< armees.size();k++){
                    afficher_unite(armees.get(k));
                }
                System.out.println(RESET);
            }
            else if (action ==3) {
                System.out.println("A quelle armée voulez vous ajouter une unité ? ");
                System.out.println("Liste des armées :");
                for (int i = 0; i < armees.size(); i++) {
                    System.out.println(VERT+(i+1)+RESET + ". " + armees.get(i).getNom());
                }
                Scanner sc1= new Scanner (System.in);
                int choix_armee=sc1.nextInt();
                if (choix_armee<0 || choix_armee>armees.size()){
                    System.out.println("La saisie est incorect, veuillez choisir un nombre correspondant a une armee");

                }
                choix_armee=choix_armee-1;
                Groupe armee_choisi= armees.get(choix_armee);


                    System.out.println("Quelle unité souhaitez vous ajouter : " + '\n'
                    + VERT+"1"+RESET+ "- Infantrie" + '\n'
                    + VERT+"2"+RESET+  "- vehicule");
                    Scanner scan = new Scanner (System.in);
                    uniter = scan.nextInt();
                    nouveau_armee=ajout_unite(armee_choisi,uniter);
                }


            else if (action  ==4  ){
                System.out.println("A quelle armée voulez vous supprimer une unité ? ");
                System.out.println("Liste des armées :");
                for (int i = 0; i < armees.size(); i++) {
                    System.out.println(VERT+(i+1)+RESET + ". " + armees.get(i).getNom());
                }
                Scanner armee_unit=new Scanner(System.in);
                int armee_unite=armee_unit.nextInt()-1;
                Groupe armee_choisi_supp= armees.get(armee_unite);

                System.out.println("Quelle unité souhaitez vous supprimer ? ");
                for (int i=0; i<armee_choisi_supp.getUnites().size();i++){
                    System.out.println(VERT+(i+1)+RESET + "-" + armee_choisi_supp.getUnites().get(i));
                }
                Scanner sca = new Scanner(System.in);
                int sup = sca.nextInt()-1;
                nouveau_armee.remove_unite_index(sup);
                System.out.println("unitée supprimer");


            }

            if (action>4){
                System.out.println(ROUGE+"l'action n'existe pas veuiller choisire une autre action"+RESET);
            }
            System.out.println(BLEU+"============================================================================"+RESET);
            System.out.println(BLEU+"Retour au menu Principale"+RESET);
            System.out.println(BLEU+"============================================================================"+RESET);

        }while(action!=0);


    }
}