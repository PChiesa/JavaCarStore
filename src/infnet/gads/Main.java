package infnet.gads;

import infnet.controller.ControleLoja;
import infnet.model.Carro;
import infnet.model.Loja;
import infnet.model.Motocicleta;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Loja l = new Loja("Loja JavaMotors", "Rua Java 12");
        ControleLoja c = new ControleLoja(l);

        c.adicionarCarro(new Carro(3, "chassi1", "Gol", "Branco", "Volkswagen", "Manual", 35000.00F, "Hatch", 1.0F));
        c.adicionarCarro(new Carro(4, "chassi2", "Fox", "Preto", "Volkswagen", "Manual", 40000.00F, "Hatch", 1.0F));
        /*c.adicionarMoto(new Motocicleta(3, "chassi3", "CG 500", "Preto", "Honda", "Manual", 50000.00F, "500cc", 20));
        c.adicionarMoto(new Motocicleta(4, "chassi4", "CG 100", "Vermelho", "Honda", "Manual", 15000.00F, "100cc", 10));*/

        /*c.listarEstoqueMotos()
                .stream()
                .forEach(x -> System.out.println(x.toString() + "\n"));*/

        if (c.salvarEstoque(l)){
            System.out.println("Estoque salvo com sucesso");
        }
        if (c.recuperarEstoqueCarros(l)){
            System.out.println("Estoque recuperado com sucesso");
        }

        c.listarEstoqueCarros()
                .stream()
                .forEach(x -> System.out.println(x.getModelo()));

    }
}
