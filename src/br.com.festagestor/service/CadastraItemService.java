package service;

import model.Item;
import repository.ItemRepository;

import java.util.List;

public class CadastraItemService {
    private ItemRepository repository = new ItemRepository();

    public void cadastrar(Item item) {
        if (item.getPreco() < 0) {
            System.out.println("Erro: O preço não pode ser negativo!");
            return;
        }
        repository.salvar(item);
    }

    public List<Item> listarTodos() {
        return repository.buscarTodos();
    }
}
