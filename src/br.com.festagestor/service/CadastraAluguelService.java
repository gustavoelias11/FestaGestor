package service;

import model.Aluguel;
import model.Item;
import repository.AluguelRepository;

import java.util.List;

public class CadastraAluguelService {
    private AluguelRepository repository = new AluguelRepository();

    public void cadastrar(Aluguel aluguel) {
        repository.salvarAluguel(aluguel);

        for (Item item : aluguel.getItens()) {
            item.reservarItem(1);
        }
    }

    public void devolver(Aluguel aluguel) {
        aluguel.setStatus("Finalizado");
        for (Item item : aluguel.getItens()) {
            item.devolverItem(1);
        }
    }

    public List<Aluguel> listarTodosAlugueis() {
        return repository.buscarAlugueis();
    }
}
