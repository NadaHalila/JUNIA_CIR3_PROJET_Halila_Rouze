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
        System.out.println("votre armee "+nom+" avec "+pointsMax+" points a été cree avec succes");

        return new Groupe(New_army_groupe,nom,pointsMax);
    }
    static Groupe ajout_unite(Groupe army_groupe,int nb) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nom de l'uniter : ");
        String nom = sc.nextLine();
        System.out.print("le coût de l'uniter : ");
        int cout = sc.nextInt();
        if (army_groupe.getCout()-cout >=0){
             if (nb==1){
                 System.out.print("type de l'unite d'infanterie:   " + '\n');
                 int i =1;
                 for( TypeInfanterie type : TypeInfanterie.values()){
                     System.out.println( i + "- Type : " + type);
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

                 System.out.print("type de l'unite de vehicule:  \n");
                 int i =1;
                 for( TypeVehicule type : TypeVehicule.values()){
                     System.out.println( i + "- Type : " + type);
                     i++;
                 }
                 int index = sc.nextInt();
                // creation de la classe en fonction du choix de type :
                 TypeVehicule typeVehicule = TypeVehicule.values()[index - 1];
                 Vehicule newUnite = typeVehicule.createInstance(army_groupe,nom, cout);
                 army_groupe.add_unite(newUnite);
                 System.out.println("Unité ajoutée : " + newUnite);
             }
        }
        else{
            System.out.println("le cout de l'uniter est elever ");
        }
         return army_groupe;
    }
    static void afficher_unite(Groupe army_groupe) {
        System.out.println("Armée :"+army_groupe.getNom()+"\n"+
                "cout : "+army_groupe.getCout());
        for (int i=0; i<army_groupe.getUnites().size();i++){
            System.out.println("Groupe : " + army_groupe.getUnites());
        }
    }

//    static void afficher_armee( Groupe armee){
//        System.out.println("Nom de l'armee : " + armee.getNom() + '\n' );
//        for (int j=0; j< armee.getUnites().size();j++){
//            afficher_unite((armee.getUnites().get(j).getNom()));
//        }
//
//    }

    public static void main(String[] args) {
        int action;
        int uniter;
        int suppression;
//        ArrayList<Groupe> armees = new ArrayList<>();

        System.out.println("Bienvenue dans l'éditeur de liste d'armée !" + '\n' +
        "pour commencer vous allez crée votre première armée " + '\n' +
                " un conseil passez en mode pleine ecran cela rendra votre experience de jeu plus agréable !! ");
        Groupe nouveau_armee=creation_armee();
//        armees.add(nouveau_armee);
        System.out.println('\n' + '\n'+ "Que voulez vous faire maintenant ? ");
        do {
            System.out.println("1- Crée un nouveau groupe d'armée" + '\n'
                             + "2- afficher le contenu des armée" + '\n' +
                             "3- ajouter une untié dans une armée " + '\n'
                             + "4- modifier une unité" + '\n' +
                            "5- supprime une untié ou une armée " +
                    '\n'+ "0- arreter le programme " +
                    '\n'+"entrer le chiffre correspond à l'action souhaiter: ");
            Scanner sc = new Scanner(System.in);
            action = sc.nextInt();

            if (action == 1) {
                Groupe armee=creation_armee();
//                armees.add(armee);
            }

            else if (action ==2 ){
//                for (int k=0; k< armees.size();k++){
//                    afficher_unite(armees.get(k));
//                }
                afficher_unite(nouveau_armee);
            }
            else if (action ==3) {
//                System.out.println("A quelle armée voulez vous ajouter une unité ? ");
//                System.out.println("Liste des armées :");
//                for (int i = 0; i < armees.size(); i++) {
//                    System.out.println((i+1) + ". " + armees.get(i).getNom());
//                }
//                Scanner sc1= new Scanner (System.in);
//                int choix_armee=sc1.nextInt();
//                if (choix_armee<0 || choix_armee>armees.size()){
//                    System.out.println("la saisie est incorect, veuillez choisir un nombre correspondant a une armee");
//
//                }
//                choix_armee=choix_armee-1;
//                Groupe armee_choisi= armees.get(choix_armee);


                    System.out.println("quelle unité souhaitez vous ajouter : " + '\n'
                    + "1- Infantrie" + '\n'
                    + "2 - vehicule");
                    Scanner scan = new Scanner (System.in);
                    uniter = scan.nextInt();
                    nouveau_armee=ajout_unite(nouveau_armee,uniter);
                }
                else if (action ==4){
                    System.out.println("Que voulez vous modifiez ? " + '\n' +
                            "1- modifiez le nom de l'armée " + '\n' +
                            "2- modifiez le cout de l'armée " + '\n'+
                            "3- modifiez les unitées" );
                    Scanner modif= new Scanner(System.in);
                    int modification =modif.nextInt();
                    switch (modification) {
                        case 1 :
                            System.out.println("Comment voulez vous renomez votre armée ");
                            Scanner nouveau_nom=new Scanner(System.in);
                            String new_armee=nouveau_nom.nextLine();
                            // enregistrer changement de nom
                            break;
                        case 2:
                            System.out.println("quelle est la valeur du nouveau cout de l'armée ?");
                            Scanner nouveau_cout=new Scanner(System.in);
                            int new_cout=nouveau_cout.nextInt();
                            // enregistrer changement cout
                            break;
                        case 3 :
                            System.out.println("quelle unité voulez vous modifiez : ");
                            for (int i=0; i<nouveau_armee.getUnites().size();i++){
                                System.out.println(i+1 + "-" + nouveau_armee.getUnites().get(i));
                            }
                            Scanner modif_unite=new Scanner((System.in));
                            int modification_unite=modif_unite.nextInt();
                            switch (modification_unite){
                                case 1 :
                                    System.out.println("que souhaitez vous modifiez : " + '\n' +
                                            "1- le nom " + '\n' +
                                            "2- le cout " );
                                    Scanner modif_unit1=new Scanner(System.in);
                                    int modication_unit1=modif_unit1.nextInt();
                                    // enregistrer modif
                                    break;
                            }

                    }


                }

                else if (action  == 5 ){
//                    System.out.println("quelle groupe souhaitez vous supprimer ? ");
//                    for (int i = 0; i < armees.size(); i++) {
//                        System.out.println((i+1) + ". " + armees.get(i).getNom());
//                    }
//                    Scanner scann = new Scanner(System.in);
//                    suppression = scann.nextInt();
//                    suppression=suppression-1;
//                    nouveau_armee.remove_unite_index(suppression);
//                    System.out.println("le groupe numero " + suppression + " à été supprimer avec succès");

                    System.out.println("souhiatez vous supprimer un groupe d'uniter (1) ou seulement une unitée (2) ? ");
                    Scanner scann= new Scanner(System.in);
                    suppression=scann.nextInt();
                    switch (suppression) {
                        case 2:
                            System.out.println("quelle unité souhaitez vous supprimer ? ");
                            for (int i=0; i<nouveau_armee.getUnites().size();i++){
                                System.out.println(i+1 + "-" + nouveau_armee.getUnites().get(i));
                            }
                            Scanner sca = new Scanner(System.in);
                            int sup = sca.nextInt()-1;
                            nouveau_armee.remove_unite_index(sup);
                            System.out.println("unitée supprimer");
                            break;

                    }
                }


        }while(action!=0);


    }
}