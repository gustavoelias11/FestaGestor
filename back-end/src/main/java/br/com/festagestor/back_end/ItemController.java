package br.com.festagestor.back_end;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}