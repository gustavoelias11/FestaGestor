package service;

import model.Aluguel;
import repository.AluguelRepository;

import java.util.List;

public class CadastraAluguelService {
    private AluguelRepository repository = new AluguelRepository();

    public void cadastrar(Aluguel aluguel) {
        repository.salvarAluguel(aluguel);
    }

    public List<Aluguel> listarTodosAlugueis() {
        return repository.buscarAlugueis();
    }
}
