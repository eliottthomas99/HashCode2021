public class Rue {
    public String nom;
    public int T;
    public int tempsFeuVert;
    private int densite;

    public int getDensite() {
        return densite;
    }

    public void setDensite(int densite) {
        this.densite = densite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getT() {
        return T;
    }

    public void setT(int t) {
        T = t;
    }

    public int getTempsFeuVert() {
        return tempsFeuVert;
    }

    public void setTempsFeuVert(int tempsFeuVert) {
        this.tempsFeuVert = tempsFeuVert;
    }

    public Rue(String nom, int t) {
        this.nom = nom;
        T = t;
    }
}
