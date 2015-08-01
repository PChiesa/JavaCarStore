package infnet.model;

/**
 * Created by Pedro on 31/07/15.
 */
public class Carro extends Veiculo {

    //Atributos
    private String tipo;
    private float motorizacao;


    //Gets e Sets
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(float motorizacao) {
        this.motorizacao = motorizacao;
    }
}
