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

    public void setEstoqueCarros(ArrayList<Carro> estoqueCarros) {
        this.estoqueCarros = estoqueCarros;
    }

    public ArrayList<Motocicleta> getEstoqueMotocicletas() {
        return estoqueMotocicletas;
    }

    public void setEstoqueMotocicletas(ArrayList<Motocicleta> estoqueMotocicletas) {
        this.estoqueMotocicletas = estoqueMotocicletas;
    }
}
