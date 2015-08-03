package infnet.gads;

import infnet.controller.ControleLoja;
import infnet.model.Carro;
import infnet.model.Loja;
import infnet.model.Motocicleta;


public class Main {

    public static void main(String[] args) {
        //Instanciando a loja
        Loja l = new Loja("Loja JavaMotors", "Rua Java 12");

        //Instanciando o controle passando a loja
        ControleLoja c = new ControleLoja(l);

        //Adicionando carros e motos aos respectivos estoques
        c.adicionarCarro(new Carro(1, "chassi1", "Gol", "Branco", "Volkswagen", "Manual", 35000.00F, "Hatch", 1.0F));
        c.adicionarCarro(new Carro(2, "chassi2", "Fox", "Preto", "Volkswagen", "Manual", 40000.00F, "Hatch", 1.0F));
        c.adicionarMoto(new Motocicleta(3, "chassi3", "CG 500", "Preto", "Honda", "Manual", 50000.00F, "500cc", 20));
        c.adicionarMoto(new Motocicleta(4, "chassi4", "CG 100", "Vermelho", "Honda", "Manual", 15000.00F, "100cc", 10));


        //Salvando os estoques em arquivos de texto
        if (c.salvarEstoqueCarros(l)){
            System.out.println("Estoque de carros salvo com sucesso");
        }
        if (c.salvarEstoqueMotos(l)){
            System.out.println("Estoque de motos salvo com sucesso");
        }

        //Recuperando os estoques dos arquivos de texto
        if (c.recuperarEstoqueCarros(l)){
            System.out.println("Estoque de carros recuperado com sucesso");
        }
        if (c.recuperarEstoqueMotos(l)){
            System.out.println("Estoque de motos recuperado com sucesso");
        }

        //Imprimindo a lista dos estoques
        System.out.println("Carros");
        c.listarEstoqueCarros()
                .stream()
                .forEach(x -> System.out.println(x.getModelo()));

        System.out.println("Motos");
        c.listarEstoqueMotos()
                .stream()
                .forEach(x -> System.out.println(x.getModelo()));

    }
}
