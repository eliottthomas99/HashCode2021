import java.io.File;
import java.lang.reflect.Array;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static String filename = "a_example";



    public static ArrayList<ArrayList<Integer>> generateOutput(int nb, int nb2, int nb3, int nb4,ArrayList<ArrayList<String>> listePizza ){
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>(); // Create an ArrayList object

        int reste = listePizza.size();
        int level = Math.min(4,reste); //quelle taille d'équipe on traite
        int progression = 0;

        int reste2 = nb2;
        int reste3 = nb3;
        int reste4 = nb4;


        while(level>=2 && reste>0  ){


            if(reste>=level){
                ArrayList<Integer> element = new ArrayList<Integer>();
                element.add(level);
                for(int indice=progression;indice<progression+level;indice++ ){


                    element.add(indice);
                    //System.out.println(indice+" "+listePizza.size());
                    if(indice>=listePizza.size()-1){
                        break;
                    }

                }
                progression+=level;
                reste-=level;

                switch (level){
                    case 4:
                        reste4-=1;
                        break;
                    case 3:
                        reste3-=1;
                        break;
                    case 2:
                        reste2-=1;
                        break;
                }





                if(reste<level || (level==4 && reste4==0) || (level==3 && reste3==0) || (level==2 && reste2==0) ){
                    level--;
                }
                out.add(element);
            }
            else{ //pas assez pour donner tout ce quil faut à une equipe
                level--;
            }



        }

        return out;

    }
    

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

        ArrayList<ArrayList<String>> out = new ArrayList<ArrayList<String>>(); // Create an ArrayList object
        String a[] = new String[]{"onion","pepper","olive"};
        ArrayList arlista = new ArrayList(Arrays.asList(a));

        String b[] = new String[]{"mushroom","tomato","basil"};
        ArrayList arlistb = new ArrayList(Arrays.asList(b));

        String c[] = new String[]{"chicken","mushroom","pepper"};
        ArrayList arlistc = new ArrayList(Arrays.asList(c));

        String d[] = new String[]{"tomato","mushroom","basil"};
        ArrayList arlistd = new ArrayList(Arrays.asList(d));

        String e[] = new String[]{"chicken","basil"};
        ArrayList arliste = new ArrayList(Arrays.asList(e));


        out.add(arlista);
        out.add(arlistb);
        out.add(arlistc);
        out.add(arlistd);
        out.add(arliste);


        System.out.println(generateOutput(5,1,2,1,out));


    }
}
