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
         if (nb==1){
             System.out.print("type de l'unite d'infanterie: ");
             String type = sc.nextLine();
             Infanterie new_Unite=new Infanterie(army_groupe.getUnites(),army_groupe.getNom(), army_groupe.getCout(), nom, cout,type);
         }
         if (nb==2){

             System.out.print("type de l'unite de véhicule: \n 1- Attaque\n 2-Transport ");
             int type = sc.nextInt();
             if(type==1){
                 Attaque new_Unite=new Attaque(army_groupe.getUnites(),army_groupe.getNom(), army_groupe.getCout(), nom, cout,"attaque")

             }
         }
    }


    public static void main(String[] args) {
        System.out.println("Bienvenue dans l'éditeur de liste d'armée !"+'\n'+ "1- Crée un nouveau groupe d'armée" +'\n'+"entrer le chiffre correspond à l'action souhaiter: ");
        Scanner sc = new Scanner(System.in);
        int action = sc.nextInt();
        if (action == 1) {
            Groupe nouveau_armee=creation_armee();
        }





        //Unite U = new Unite("Boo",10000){};
        //Infanterie I = new Infanterie("I_Boo",20,"type_1") {};

        //System.out.println("Nom: "+I.getNom());
        //System.out.println("Cout: "+I.getCout());
        //System.out.println(I.toString());


    }
}