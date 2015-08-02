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

        c.adicionarCarro(new Carro(1, "chassi1", "Gol", "Branco", "Volkswagen", "Manual", 35000.00F, "Hatch", 1.0F));
        c.adicionarCarro(new Carro(2, "chassi2", "Fox", "Preto", "Volkswagen", "Manual", 40000.00F, "Hatch", 1.0F));
        c.adicionarMoto(new Motocicleta(3, "chassi3", "CG 500", "Preto", "Honda", "Manual", 50000.00F, "500cc", 20));
        c.adicionarMoto(new Motocicleta(4, "chassi4", "CG 100", "Vermelho", "Honda", "Manual", 15000.00F, "100cc", 10));
        c.listarEstoqueCarros()
                .stream()
                .forEach(x -> System.out.println(x.toString() + "\n"));
        /*c.listarEstoqueMotos()
                .stream()
                .forEach(x -> System.out.println(x.toString() + "\n"));*/
/*
        if (c.salvarEstoque(l)){
            System.out.println("Estoque salvo com sucesso");
        }*/
        ArrayList<String> e = c.recuperarEstoque(l);
        for (int i = 0; i < e.size() / 9; i++) {
            int z = i * 9;
            int id = Integer.parseInt(e.get(0 + z).replace("\n", ""));
            String chassi = e.get(1 + z).replace("\n", "");
            String modelo = e.get(2 + z).replace("\n", "");
            String cor = e.get(3 + z).replace("\n", "");
            String montadora = e.get(4 + z).replace("\n", "");
            String cambio = e.get(5 + z).replace("\n", "");
            Float preco = Float.parseFloat(e.get(6 + z).replace("\n", ""));
            String tipo = e.get(7 + z).replace("\n", "");
            Float motorizacao = Float.parseFloat(e.get(8 + z).replace("\n", ""));
            c.getLoja().getEstoqueCarros()
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

        c.listarEstoqueCarros()
                .stream()
                .forEach(x -> System.out.println(x.toString() + "\n"));

    }
}
