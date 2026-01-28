package repository;

import model.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class AluguelRepository {
    private List<Aluguel> listaDeAlugueis = new ArrayList<>();

    public void salvarAluguel(Aluguel aluguel) {
        listaDeAlugueis.add(aluguel);
        System.out.println("Aluguel " + aluguel + " foi cadastrado com sucesso!");
    }

    public List<Aluguel> buscarAlugueis() {
        return listaDeAlugueis;
    }
}
