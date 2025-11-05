package br.com.festagestor.back_end.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> listarTodosOsItens() {

        return itemRepository.findAll();
    }

    @PostMapping
    public Item criarItem(@RequestBody Item novoItem) {
        return itemRepository.save(novoItem);
    }

    @PutMapping("/{id}")
    public Item atualizarItem(@PathVariable Long id, @RequestBody Item itemComNovosDados) {
        itemComNovosDados.setId(id);
        return itemRepository.save(itemComNovosDados);
    }

    @DeleteMapping("/{id}")
    public void excluirItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }
}