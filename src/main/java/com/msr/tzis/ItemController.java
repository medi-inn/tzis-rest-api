package com.msr.tzis;

import com.msr.tzis.model.ItemRepository;
import com.msr.tzis.model.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
    private final ItemRepository repository;

    public ItemController(ItemRepository repository){ this.repository = repository; }

    @GetMapping("/item")
    @CrossOrigin(origins = "*")
    List<Item> all(){
        return repository.findAll();
    }

    @PostMapping("/item")
    @CrossOrigin(origins = "*")
    Item newItem(@RequestBody Item newItem){
        return repository.save(newItem);
    }

    @GetMapping("/item/{id}")
    @CrossOrigin(origins = "*")
    Item one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/item/{id}")
    @CrossOrigin(origins = "*")
    Item replaceItem(@RequestBody Item newItem, @PathVariable Long id){
        return repository.findById(id)
                .map(item -> {
                    item.setName(newItem.getName());
                    item.setLagerort(newItem.getLagerort());
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repository.save(newItem);
                });
    }


    @DeleteMapping("/item/{id}")
    @CrossOrigin(origins = "*")
    void deleteItem(@PathVariable Long id){
        repository.deleteById(id);
    }

}
