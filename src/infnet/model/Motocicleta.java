package infnet.model;

/**
 * Created by Pedro on 31/07/15.
 */
public class Motocicleta extends Veiculo {

    //Atributos
    private String cilindrada;
    private int tanque;


    //Gets e Sets
    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getTanque() {
        return tanque;
    }

    public void setTanque(int tanque) {
        this.tanque = tanque;
    }
}
