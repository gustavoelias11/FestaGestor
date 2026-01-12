package repository;

import model.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    private static List<Item> listaDeItens = new ArrayList<>();

    public void salvar(Item item) {
        listaDeItens.add(item);
        System.out.println("O item: " + item.getDescricao() + " foi cadastrado com sucesso!");
    }

    public List<Item> buscarTodos() {
        return listaDeItens;
    }
}
