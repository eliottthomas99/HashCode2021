import java.util.ArrayList;

public class Qualif {


    public static void main(String[] args){

        int D;
        int I;
        int S;
        int V;
        int F;

        ArrayList<Intersection> intersections = new ArrayList<Intersection>();
        ArrayList<Voiture> voitures = new ArrayList<Voiture>();


        // entree





        // traitement


        toFeuVert1(intersections);


        ArrayList<Sortie> sorties = toSorties(intersections);





        // sortie






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
