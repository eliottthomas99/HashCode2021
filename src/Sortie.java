import java.util.ArrayList;

public class Sortie {

    private int idIntersection;

    private int nombreIncomingStreets;

    private ArrayList<Rue> rues;

    public Sortie(int idIntersection, int nombreIncomingStreets, ArrayList<Rue> rues) {
        this.idIntersection = idIntersection;
        this.nombreIncomingStreets = nombreIncomingStreets;
        this.rues = rues;
    }

    public int getIdIntersection() {
        return idIntersection;
    }

    public void setIdIntersection(int idIntersection) {
        this.idIntersection = idIntersection;
    }

    public int getNombreIncomingStreets() {
        return nombreIncomingStreets;
    }

    public void setNombreIncomingStreets(int nombreIncomingStreets) {
        this.nombreIncomingStreets = nombreIncomingStreets;
    }

    public ArrayList<Rue> getRues() {
        return rues;
    }

    public void setRues(ArrayList<Rue> rues) {
        this.rues = rues;
    }
}
