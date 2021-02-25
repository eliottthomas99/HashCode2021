import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Qualif {

    private static String filenameIn = "a.txt";
    private static String filenameOut = "a.out";


    public static void main(String[] args) throws FileNotFoundException {

        int D;
        int I;
        int S;
        int V;
        int F;

        ArrayList<Intersection> intersections;
        ArrayList<Voiture> voitures;


        // entree

        File fileEntree = Paths.get(".", "in2", filenameIn).normalize().toFile();

        if (fileEntree.exists()){
            // log
            System.out.println("*** Ouverture du fichier entree ***");
            Scanner scannerEntree = new Scanner(fileEntree);

            D = scannerEntree.nextInt();
            I = scannerEntree.nextInt();
            S = scannerEntree.nextInt();
            V = scannerEntree.nextInt();
            F = scannerEntree.nextInt();

            intersections = new ArrayList<Intersection>(I);
            for (int i = 0; i < I; ++i){
                intersections.add(new Intersection());
                intersections.get(i).numero = i;
            }

            voitures = new ArrayList<Voiture>(V);
            for (int i = 0; i < I; ++i){
                voitures.add(new Voiture());
            }

            // log
            System.out.println("-- traitement rues --");
            for (int i = 0; i < S; ++i){
                int B = scannerEntree.nextInt();
                int E = scannerEntree.nextInt();
                String nom = scannerEntree.next();
                int L = scannerEntree.nextInt();

                Rue rue = new Rue(nom, L);

                intersections.get(B).ruesOut.add(rue);
                intersections.get(E).ruesIn.add(rue);
            }

            // log
            System.out.println("-- traitement voitures --");
            for (int i = 0; i < V; ++i){
                int nbRues = scannerEntree.nextInt();

                for (int j = 0; j < nbRues; ++j){

                }

            }



        }



        // traitement



        // sortie



    }
}
