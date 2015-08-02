package infnet.controller;

import infnet.model.Carro;
import infnet.model.Loja;
import infnet.model.Motocicleta;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

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

    public Motocicleta pesquisarMoto(String cilindrada, int tanque) {
        Optional<Motocicleta> m = loja.getEstoqueMotocicletas()
                .stream()
                .filter(x -> x.getCilindrada().equalsIgnoreCase(cilindrada) && x.getTanque() == tanque)
                .findFirst();
        return m.get();
    }

    public ArrayList<Carro> listarEstoqueCarros() {
        return this.getLoja().getEstoqueCarros();
    }

    public ArrayList<Motocicleta> listarEstoqueMotos() {
        return this.getLoja().getEstoqueMotocicletas();
    }

    public boolean salvarEstoque(Loja l) {
        Path path = Paths.get("src/estoque.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            l.getEstoqueCarros()
                    .stream()
                    .forEach(x -> {
                        try {
                            writer.write(x.toString());
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar o estoque");
                        }
                    });
        } catch (Exception e) {
            System.out.println("Arquivo de estoque nao encontrado");
            return false;
        }
        return true;
    }

    public ArrayList<String> recuperarEstoque(Loja l) {
        ArrayList<String> estoque = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("src/estoque.txt"))) {
            stream
                    .filter(x-> !x.contains("-"))
                    .forEach(estoque::add);
                return estoque;
        }catch (IOException e){
            System.out.println("Arquivo de estoque nao encontrado");
        }
        return null;
    }

    //Gets
    public Loja getLoja() {
        return loja;
    }

}
