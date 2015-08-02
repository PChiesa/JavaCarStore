package infnet.model;

/**
 * Created by Pedro on 31/07/15.
 */
public class Motocicleta extends Veiculo {

    //Atributos
    private String cilindrada;
    private int tanque;


    //Construtor
    public Motocicleta(int id, String chassi, String modelo, String cor, String montadora, String cambio, float preco, String cilindrada, int tanque) {
        this.setTipoVeiculo(TipoVeiculo.MOTOCICLETA);
        this.setId(id);
        this.setChassi(chassi);
        this.setModelo(modelo);
        this.setCor(cor);
        this.setMontadora(montadora);
        this.setCambio(cambio);
        this.setPreco(preco);
        this.cilindrada = cilindrada;
        this.tanque = tanque;
    }

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
