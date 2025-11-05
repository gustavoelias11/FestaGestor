package br.com.festagestor.back_end;

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
}