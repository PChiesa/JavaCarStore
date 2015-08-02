package infnet.model;

import java.util.ArrayList;

/**
 * Created by Pedro on 31/07/15.
 */
public class Loja {

    //Atributos
    private String endereco;
    private String nome;
    private ArrayList<Carro> estoqueCarros;
    private ArrayList<Motocicleta> estoqueMotocicletas;

    //Construtor
    public Loja(String nome, String endereco) {
        this.endereco = endereco;
        this.nome = nome;
        this.estoqueCarros = new ArrayList<Carro>();
        this.estoqueMotocicletas = new ArrayList<Motocicleta>();
    }

    //Gets e Sets
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Carro> getEstoqueCarros() {
        return estoqueCarros;
    }

    public ArrayList<Motocicleta> getEstoqueMotocicletas() {
        return estoqueMotocicletas;
    }
}
