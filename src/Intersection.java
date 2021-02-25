import java.util.ArrayList;

public class Intersection {

    public int numero;
    public ArrayList<Rue> ruesIn;
    public ArrayList<Rue> ruesOut;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Rue> getRuesIn() {
        return ruesIn;
    }

    public void setRuesIn(ArrayList<Rue> ruesIn) {
        this.ruesIn = ruesIn;
    }

    public ArrayList<Rue> getRuesOut() {
        return ruesOut;
    }

    public void setRuesOut(ArrayList<Rue> ruesOut) {
        this.ruesOut = ruesOut;
    }
}
