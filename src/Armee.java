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
                 System.out.print("type de l'unite d'infanterie:  ");
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
        System.out.println("Nom de group :"+army_groupe.getNom()+"\n"+
                "cout de groupe : "+army_groupe.getCout());
        for (int i=0; i<army_groupe.getUnites().size();i++){
            System.out.println(army_groupe.getUnites().get(i));
        }
    }


    public static void main(String[] args) {
        int action;
        do {
            System.out.println("Bienvenue dans l'éditeur de liste d'armée !"+
                    '\n'+ "1- Crée un nouveau groupe d'armée" +
                    '\n'+ "0- arreter le programme " +
                    '\n'+"entrer le chiffre correspond à l'action souhaiter: ");
            Scanner sc = new Scanner(System.in);
            action = sc.nextInt();
            do{
            if (action == 1) {
                Groupe nouveau_armee=creation_armee();
                nouveau_armee=ajout_unite(nouveau_armee,2);
                afficher_unite(nouveau_armee);
            }
            }while(action!=0);

        }while(action!=0);





    }
}