package infnet.model;

/**
 * Entidade motocicleta
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

    @Override
    public String toString() {
        return  this.getId() + "\n" +
                this.getChassi() + "\n" +
                this.getModelo() + "\n" +
                this.getCor() + "\n" +
                this.getMontadora() + "\n" +
                this.getCambio() + "\n" +
                this.getPreco() + "\n" +
                this.getCilindrada() + "\n" +
                this.getTanque()+"\n-\n";
    }
}
