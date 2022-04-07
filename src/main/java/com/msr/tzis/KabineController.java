package com.msr.tzis;

import com.msr.tzis.model.Kabine;
import com.msr.tzis.model.KabineRepository;
import com.msr.tzis.model.OrderRepository;
import com.msr.tzis.model.Ordering;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class KabineController {
    private final KabineRepository repository;
    private final OrderRepository orderRepository;

    public KabineController(KabineRepository repository, OrderRepository orderRepository){
        this.repository = repository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/kabine")
    @CrossOrigin(origins = "*")
    List<Kabine> all(){
        return repository.findAll();
    }

    @PostMapping("/kabine")
    @CrossOrigin(origins = "*")
    Kabine newKabine(@RequestBody Kabine newKabine){
        return repository.save(newKabine);
    }

    @GetMapping("/kabine/{id}")
    @CrossOrigin(origins = "*")
    Kabine one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new KabineNotFoundException(id));
    }

    @PutMapping("/kabine/{id}")
    @CrossOrigin(origins = "*")
    Kabine replaceKabine(@RequestBody Kabine newKabine, @PathVariable Long id){
        return repository.findById(id)
                .map(kabine -> {
                    if (newKabine.getName() != null) { kabine.setName(newKabine.getName()); }
                    kabine.setOpen(newKabine.getOpen());
                    return repository.save(kabine);
                })
                .orElseGet(() -> {
                    newKabine.setId(id);
                    return repository.save(newKabine);
                });
    }


    @DeleteMapping("/kabine/{id}")
    @CrossOrigin(origins = "*")
    void deleteKabine(@PathVariable Long id){
        List<Ordering> orders = orderRepository.findAll();
        for (Ordering order : orders){
            if (id.equals(order.getKabine().getId())){
                orderRepository.delete(order);
            }
        }
        repository.deleteById(id);
    }

}
