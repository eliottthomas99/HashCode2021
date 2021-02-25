import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Qualif {

    private static String filenameIn = "f.txt";
    private static String filenameOut = "f.out";


    public static void main(String[] args) throws IOException {

        int D;
        int I;
        int S;
        int V;
        int F;

        ArrayList<Rue> rues = null;
        ArrayList<Intersection> intersections = null;
        ArrayList<Voiture> voitures;


        // entree

        File fileEntree = Paths.get(".", "in2", filenameIn).normalize().toFile();

        if (fileEntree.exists()) {
            // log
            System.out.println("*** Ouverture du fichier entree ***");
            Scanner scannerEntree = new Scanner(fileEntree);

            D = scannerEntree.nextInt();
            I = scannerEntree.nextInt();
            S = scannerEntree.nextInt();
            V = scannerEntree.nextInt();
            F = scannerEntree.nextInt();

            rues = new ArrayList<Rue>(S);
            for (int i = 0; i < S; ++i) {
                rues.add(new Rue());
            }

            intersections = new ArrayList<Intersection>(I);
            for (int i = 0; i < I; ++i) {
                intersections.add(new Intersection());
                intersections.get(i).numero = i;
            }

            voitures = new ArrayList<Voiture>(V);
            for (int i = 0; i < V; ++i){
                voitures.add(new Voiture());
            }

            // log
            System.out.println("-- traitement rues --");
            for (int i = 0; i < S; ++i) {
                int B = scannerEntree.nextInt();
                int E = scannerEntree.nextInt();
                String nom = scannerEntree.next();
                int L = scannerEntree.nextInt();

                Rue rue = new Rue(nom, L);

                rues.add(rue);
                intersections.get(B).ruesOut.add(rue);
                intersections.get(E).ruesIn.add(rue);
            }

            // log
            System.out.println("-- traitement voitures --");
            for (int i = 0; i < V; ++i) {
                int nbRues = scannerEntree.nextInt();

                for (int j = 0; j < nbRues; ++j){

                }
            }

            // log
            System.out.println("*** Fermeture du fichier entree ***");



            //Version 1
            toFeuVert1(intersections);


            //Version 2






            ArrayList<Sortie> sorties = toSorties(intersections);


            // sortie


        }







    }


    public static void toFeuVert1(ArrayList<Intersection> intersections){
        //version naive
        // mettre 2 sec à chaque rue

        for (Intersection intersect:intersections
             ) {
            //boucler sur toutes les rues
            for (Rue rue:intersect.ruesIn
                 ) {
                rue.setTempsFeuVert(2);


            }

        }
    }

    public static void toFeuVert2(ArrayList<Intersection> intersections, ArrayList<Voiture> voitures){

        ArrayList<Rue> ruesNommees = new ArrayList<>();

        //On ajoute toutes les rues existantes
        for (Intersection intersect : intersections
        ) {

            // ajouter toutes les rues in
            for (Rue rue : intersect.ruesIn
            ) {
                ruesNommees.add(rue);
            }

        }

        //On mesure l'importance de chaque rue en terme de passage

        for (Voiture voiture : voitures
        ) {
            for (Rue rue: voiture.rues
            ) {

                for (Rue rueNommee: ruesNommees
                ) {

                    if(rueNommee.getNom().equals(rue.getNom())){
                        rueNommee.setDensite(rueNommee.getDensite() +1 );
                    }


                }

            }

        }


        for (Intersection intersect:intersections
             ) {

            for (:
                 ) {
                
            }
            
        }
        
        
        
        





    }








public static ArrayList<Sortie> toSorties(ArrayList<Intersection> intersections){

    ArrayList<Sortie> sorties = new ArrayList<>();

    for (Intersection intersect:intersections
         ) {

        sorties.add( new Sortie(intersect.getNumero(), intersect.ruesIn.size(), intersect.ruesIn));



    }




    return sorties;
}



}
