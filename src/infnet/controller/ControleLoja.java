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
 * Classe responsavel pelas alteracoes no estoque da loja
 */
public class ControleLoja {
    //Atributos
    private Loja loja;


    //Construtor
    public ControleLoja(Loja loja) {
        this.loja = loja;
    }

    /*
    *****************************************************
    * Metodos publicos
    *****************************************************
    * */

    /**
     * Adiciona um carro ao estoque de carros
     *
     * @return true ou false
     */
    public boolean adicionarCarro(Carro c) {
        try {
            this.loja.getEstoqueCarros().add(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Adiciona uma motocicleta ao estoque de motos
     *
     * @return true ou false
     */
    public boolean adicionarMoto(Motocicleta m) {
        try {
            this.loja.getEstoqueMotocicletas().add(m);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Pesquisa um carro pelo numero do chassi
     *
     * @return Carro procurado ou null
     */
    public Carro pesquisarCarroPorChassi(String chassi) {
        Optional<Carro> c = loja.getEstoqueCarros()
                .stream()
                .filter(x -> x.getChassi().equals(chassi))
                .findFirst();

        if (c != null)
            return c.get(); //Carro encontrado
        else
            return null; //Nenhum carro encontrado
    }

    /**
     * Pesquisa uma motocicleta pelo numero do chassi
     *
     * @return Motocicleta procurada ou null
     */
    public Motocicleta pesquisarMotoPorChassi(String chassi) {
        Optional<Motocicleta> m = loja.getEstoqueMotocicletas()
                .stream()
                .filter(x -> x.getChassi().equals(chassi))
                .findFirst();

        if (m != null)
            return m.get(); // Moto encontrada
        else
            return null; // Nenhuma moto encontrada
    }

    /**
     * Retorna o estoque de carros
     *
     * @return Estoque de carros
     */
    public ArrayList<Carro> listarEstoqueCarros() {
        return this.getLoja().getEstoqueCarros();
    }

    /**
     * Retorna o estoque de motos
     *
     * @return Estoque de motos
     */
    public ArrayList<Motocicleta> listarEstoqueMotos() {
        return this.getLoja().getEstoqueMotocicletas();
    }

    /**
     * Salva em um arquivo texto o estoque de motos
     *
     * @return true ou false
     */
    public boolean salvarEstoqueMotos(Loja l) {
        Path path = Paths.get("src/estoqueMotos.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            l.getEstoqueMotocicletas()
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

    /**
     * Carrega na memoria o estoque de motos
     *
     * @return true ou false
     */
    public boolean recuperarEstoqueMotos(Loja l) {
        ArrayList<String> estoque = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("src/estoqueMotos.txt"))) {
            stream
                    .filter(x -> !x.contains("-"))// "-" faz a separacao das motos no arquivo .txt
                    .forEach(estoque::add); // Adiciona cada linha do arquivo .txt ao ArrayList<String> estoque

        } catch (IOException e) {
            System.out.println("Arquivo de estoque nao encontrado");
            return false;
        }
        l.getEstoqueMotocicletas().clear();// Limpa o estoque em memoria para substitui-lo pelo estoque do arquivo .txt
        this.converterEstoqueMotos(estoque);//Chamada do metodo privado converterEstoqueMotos()
        return true;
    }

    /**
     * Salva em um arquivo texto o estoque de carros
     *
     * @return true ou false
     */
    public boolean salvarEstoqueCarros(Loja l) {
        Path path = Paths.get("src/estoqueCarros.txt");
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

    /**
     * Carrega na memoria o estoque de carros
     *
     * @return true ou false
     */
    public boolean recuperarEstoqueCarros(Loja l) {
        ArrayList<String> estoque = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("src/estoqueCarros.txt"))) {
            stream
                    .filter(x -> !x.contains("-"))// "-" faz a separacao dos carros no arquivo .txt
                    .forEach(estoque::add); // Adiciona cada linha do arquivo .txt ao ArrayList<String> estoque

        } catch (IOException e) {
            System.out.println("Arquivo de estoque nao encontrado");
            return false;
        }
        l.getEstoqueCarros().clear();// Limpa o estoque em memoria para substitui-lo pelo estoque do arquivo .txt
        this.converterEstoqueCarros(estoque);//Chamada do metodo privado converterEstoqueCarros()
        return true;
    }


    /*
    *****************************************************
    * Metodos privados
    *****************************************************
    * */

    /**
     * Faz a conversao de um ArrayList de String para um ArrayList de Moto
     *
     * @return void
     */
    private void converterEstoqueMotos(ArrayList<String> e) {

        /*
        * Como cada moto possui 9 atributos, podemos saber o numero de
        * motos no ArrayList<String> dividindo o tamanho dele por 9 e
        * entao passar por cada item convertendo a String para a
        * determinada classe do atributo.
        * */
        for (int i = 0; i < e.size() / 9; i++) {
            int z = i * 9;
            //Remocao do \n de cada linha
            int id = Integer.parseInt(e.get(0 + z).replace("\n", ""));
            String chassi = e.get(1 + z).replace("\n", "");
            String modelo = e.get(2 + z).replace("\n", "");
            String cor = e.get(3 + z).replace("\n", "");
            String montadora = e.get(4 + z).replace("\n", "");
            String cambio = e.get(5 + z).replace("\n", "");
            Float preco = Float.parseFloat(e.get(6 + z).replace("\n", ""));
            String cilindrada = e.get(7 + z).replace("\n", "");
            int tanque = Integer.parseInt(e.get(8 + z).replace("\n", ""));

            //Populando o estoque
            this.getLoja().getEstoqueMotocicletas()
                    .add(
                            new Motocicleta(
                                    id,
                                    chassi,
                                    modelo,
                                    cor,
                                    montadora,
                                    cambio,
                                    preco,
                                    cilindrada,
                                    tanque));
        }
    }

    /**
     * Faz a conversao de um ArrayList de String para um ArrayList de Carro
     *
     * @return void
     */
    private void converterEstoqueCarros(ArrayList<String> e) {

        /*
        * Como cada carro possui 9 atributos, podemos saber o numero de
        * carros no ArrayList<String> dividindo o tamanho dele por 9 e
        * entao passar por cada item convertendo a String para a
        * determinada classe do atributo.
        * */
        for (int i = 0; i < e.size() / 9; i++) {
            int z = i * 9;
            //Remocao do \n de cada linha
            int id = Integer.parseInt(e.get(0 + z).replace("\n", ""));
            String chassi = e.get(1 + z).replace("\n", "");
            String modelo = e.get(2 + z).replace("\n", "");
            String cor = e.get(3 + z).replace("\n", "");
            String montadora = e.get(4 + z).replace("\n", "");
            String cambio = e.get(5 + z).replace("\n", "");
            Float preco = Float.parseFloat(e.get(6 + z).replace("\n", ""));
            String tipo = e.get(7 + z).replace("\n", "");
            Float motorizacao = Float.parseFloat(e.get(8 + z).replace("\n", ""));

            //Populando o estoque
            this.getLoja().getEstoqueCarros()
                    .add(
                            new Carro(
                                    id,
                                    chassi,
                                    modelo,
                                    cor,
                                    montadora,
                                    cambio,
                                    preco,
                                    tipo,
                                    motorizacao));
        }
    }


    /*
    *****************************************************
    * Gets e Sets
    *****************************************************
    * */

    /**
     * Retorna a loja da instancia do ControleLoja
     *
     * @return loja
     */
    public Loja getLoja() {
        return loja;
    }

}
