package infnet.gads;

import infnet.controller.ControleLoja;
import infnet.model.Carro;
import infnet.model.Loja;
import infnet.model.Motocicleta;


public class Main {

    public static void main(String[] args) {
        Loja l = new Loja("Loja JavaMotors", "Rua Java 12");
        ControleLoja c = new ControleLoja(l);

        c.adicionarCarro(new Carro(1, "chassi1", "Gol", "Branco", "Volkswagen", "Manual", 35.000F, "Hatch", 1.0F));
        c.adicionarCarro(new Carro(2, "chassi2", "Fox", "Preto", "Volkswagen", "Manual", 40.000F, "Hatch", 1.0F));
        c.adicionarMoto(new Motocicleta(3, "chassi3", "CG 500", "Preto", "Honda", "Manual", 50.000F, "500cc", 20));
        c.adicionarMoto(new Motocicleta(4, "chassi4", "CG 100", "Vermelho", "Honda", "Manual", 25.000F, "100cc", 10));
        c.mostrarCarros()
                .stream()
                .forEach(x -> System.out.println(x.toString()+"\n"));


    }
}
