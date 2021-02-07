import java.io.File;
import java.lang.reflect.Array;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {

    private static String filename = "a_example";

    public static void main(String[] args) throws FileNotFoundException {

        // recuperer les donnees
        // objets ?
        // - nb pizzas
        // - nb equipes de 2
        // - nb equipes de 3
        // - nb equipes de 4
        // - liste de pizzas
                // pizzas :
                //          - liste ingredients (string)


        /* DECLARATION VARIABLES */

        int nbPizzas;
        int nbEquipesDe2;
        int nbEquipesDe3;
        int nbEquipesDe4;
        ArrayList<ArrayList<String>> pizzasAr = new ArrayList<ArrayList<String>>();


        /* RECUPERATION DES DONNEES */

        File fileEntree = Paths.get(".", "in", filename).normalize().toFile();

        if (fileEntree.exists()) {
            // log
            System.out.println("*** Ouverture du fichier ***");
            Scanner scannerEntree = new Scanner(fileEntree);

            nbPizzas = scannerEntree.nextInt();
            nbEquipesDe2 = scannerEntree.nextInt();
            nbEquipesDe3 = scannerEntree.nextInt();
            nbEquipesDe4 = scannerEntree.nextInt();


            System.out.println("*** Recuperation des pizzas - debut ***");

            for (int i = 0;i < nbPizzas; ++i){
                int nbIngredients = scannerEntree.nextInt();

                ArrayList<String> pizza = new ArrayList<String>();

                for (int j = 0; j < nbIngredients; ++j){
                    String ingredient = scannerEntree.next();
                    // System.out.println("ingredient " + j + " = " + ingredient); // print de debug
                    pizza.add(ingredient);
                }

                pizzasAr.add(pizza);
                // System.out.println(pizza); // print de debug
            }

            System.out.println("*** Recuperation des pizzas - fin ***");

        } else {
            System.out.println("Erreur ouverture du fichier, fichier non trouve");
        }


        // traitement







        // renvoyer les donnees

        // liste des livraisons
        //      livraison : liste des pizzas

    }
}
