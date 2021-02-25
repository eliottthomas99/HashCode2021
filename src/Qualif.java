import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Qualif {

    private static String filenameIn = "a.txt";
    private static String filenameOut = "a.out";


    public static void main(String[] args) throws IOException {

        int D;
        int I;
        int S;
        int V;
        int F;

        ArrayList<Intersection> intersections = null;
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
                    String rueNom = scannerEntree.next();
                    Rue rue = new Rue(rueNom, -1); /* = -1 car non initialise !! */
                    voitures.get(i).rues.add(rue);
                }
            }

            // log
            System.out.println("*** Fermeture du fichier entree ***");

            scannerEntree.close();

        }





        // traitement


        toFeuVert1(intersections);


        ArrayList<Sortie> sorties = toSorties(intersections);





        // sortie


        // log
        System.out.println("*** Creation du fichier sortie ***");
        FileOutputStream outputStream = new FileOutputStream("out2/" + filenameOut);

        // log
        System.out.println("*** Ecriture dans le fichier sortie ***");

        String taille = String.valueOf(sorties.size()) + '\n';
        byte[] tailleToBytes = taille.getBytes();
        outputStream.write(tailleToBytes);

        for (int i = 0; i< intersections.size(); ++i){
            // print idIntersection
            String idIntersection = String.valueOf(sorties.get(i).getIdIntersection()) + '\n';
            byte[] idToBytes = idIntersection.getBytes();
            outputStream.write(idToBytes);

            // print nombre rues
            String nbRues = String.valueOf(sorties.get(i).getRues().size()) + '\n';
            byte[] nbRuesToBytes = nbRues.getBytes();
            outputStream.write(nbRuesToBytes);

            for (int j = 0; j < sorties.get(i).getRues().size(); ++j){
                // print nom rue
                String nomRue = sorties.get(i).getRues().get(j).nom + ' ';
                byte[] nomRueToBytes = nomRue.getBytes();
                outputStream.write(nomRueToBytes);

                // print tempsFeuVert
                String tempsVert = String.valueOf(sorties.get(i).getRues().get(j).tempsFeuVert) + '\n';
                byte[] tempsVertToBytes = tempsVert.getBytes();
                outputStream.write(tempsVertToBytes);
            }


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

public static ArrayList<Sortie> toSorties(ArrayList<Intersection> intersections){

    ArrayList<Sortie> sorties = new ArrayList<>();

    for (Intersection intersect:intersections
         ) {

        sorties.add( new Sortie(intersect.getNumero(), intersect.ruesIn.size(), intersect.ruesIn));



    }




    return sorties;
}



}
