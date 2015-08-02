package infnet.controller;

import infnet.model.Carro;
import infnet.model.Loja;
import infnet.model.Motocicleta;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Pedro on 01/08/15.
 */
public class ControleLoja {
    //Atributos
    private Loja loja;


    //Construtor
    public ControleLoja(Loja loja) {
        this.loja = loja;
    }

    //Metodos
    public boolean adicionarCarro(Carro c) {
        try {
            this.loja.getEstoqueCarros().add(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean adicionarMoto(Motocicleta m) {
        try {
            this.loja.getEstoqueMotocicletas().add(m);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Carro pesquisarCarro(float motor, float preco) {
        Optional<Carro> c = loja.getEstoqueCarros()
                .stream()
                .filter(x -> x.getMotorizacao() == motor && x.getPreco() == preco)
                .findFirst();
        return c.get();
    }

    public Motocicleta pesquisarMoto(String cilindrada, int tanque){
        Optional<Motocicleta> m = loja.getEstoqueMotocicletas()
                .stream()
                .filter(x->x.getCilindrada().equalsIgnoreCase(cilindrada) && x.getTanque() == tanque)
                .findFirst();
        return m.get();
    }

    public ArrayList<Carro> mostrarCarros(){
        return this.getLoja().getEstoqueCarros();
    }

    public ArrayList<Motocicleta> mostrarMotos(){
        return this.getLoja().getEstoqueMotocicletas();
    }

    //Gets
    public Loja getLoja() {
        return loja;
    }

}
