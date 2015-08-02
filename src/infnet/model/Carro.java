package infnet.model;


/**
 * Created by Pedro on 31/07/15.
 */
public class Carro extends Veiculo {

    //Atributos
    private String tipo;
    private float motorizacao;

    //Construtor
    public Carro(int id, String chassi, String modelo, String cor, String montadora, String cambio, float preco, String tipo, float motorizacao) {
        this.setTipoVeiculo(TipoVeiculo.CARRO);
        this.setId(id);
        this.setChassi(chassi);
        this.setModelo(modelo);
        this.setCor(cor);
        this.setMontadora(montadora);
        this.setCambio(cambio);
        this.setPreco(preco);
        this.tipo = tipo;
        this.motorizacao = motorizacao;
    }

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

    @Override
    public String toString() {
        return  this.getId() + "\n" +
                this.getChassi() + "\n" +
                this.getModelo() + "\n" +
                this.getCor() + "\n" +
                this.getMontadora() + "\n" +
                this.getCambio() + "\n" +
                this.getPreco() + "\n" +
                this.getTipo() + "\n" +
                this.getMotorizacao()+"\n-\n";
        /*return "Carro=" + this.getId() + "\n" +
                "Chassi=" + this.getChassi() + "\n" +
                "Modelo=" + this.getModelo() + "\n" +
                "Cor=" + this.getCor() + "\n" +
                "Montadora=" + this.getMontadora() + "\n" +
                "Cambio=" + this.getCambio() + "\n" +
                "Preco=" + this.getPreco() + "\n" +
                "Tipo=" + this.getTipo() + "\n" +
                "Motorizacao=" + this.getMotorizacao()+"\n\n";*/
    }
}
