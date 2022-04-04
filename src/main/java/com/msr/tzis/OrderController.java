package com.msr.tzis;

import com.msr.tzis.model.Ordering;
import com.msr.tzis.model.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    private final OrderRepository repository;

    public OrderController(OrderRepository repository){
        this.repository = repository;
    }

    @GetMapping("/order")
    @CrossOrigin(origins = "*")
    List<Ordering> all(){
        return repository.findAll();
    }

    @PostMapping("/order")
    @CrossOrigin(origins = "*")
    Ordering newOrder(@RequestBody Ordering newOrdering){
        return repository.save(newOrdering);
    }

    @GetMapping("/order/{id}")
    @CrossOrigin(origins = "*")
    Ordering one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @GetMapping("/order/kabine/{id}")
    @CrossOrigin(origins = "*")
    List<Ordering> whereKabineId(@PathVariable Long id) {
        List<Ordering> all = repository.findAll();
        List<Ordering> res = new ArrayList<>();
        for (Ordering o : all){
            if (o.getKabine().getId() == id){
                res.add(o);
            }
        }
        return res;
    }

    @PutMapping("/order/{id}")
    @CrossOrigin(origins = "*")
    Ordering replaceDesktop(@RequestBody Ordering newOrdering, @PathVariable Long id){
        return repository.findById(id)
                .map(ordering -> {
                    if (newOrdering.getDatum() != null) {ordering.setDatum(newOrdering.getDatum());}
                    if (newOrdering.getMessage() != null) {ordering.setMessage(newOrdering.getMessage());}
                    if (newOrdering.getKabine() != null) {ordering.setKabine(newOrdering.getKabine());}
                    if (newOrdering.getItems() != null) {ordering.setItems(newOrdering.getItems());}
                    if (newOrdering.getDesktop() != null) {ordering.setDesktop(newOrdering.getDesktop());}
                    ordering.setStatus(newOrdering.getStatus());
                    return repository.save(ordering);
                })
                .orElseGet(() -> {
                    newOrdering.setId(id);
                    return repository.save(newOrdering);
                });
    }

    @DeleteMapping("/order/{id}")
    @CrossOrigin(origins = "*")
    void deleteOrder(@PathVariable Long id){
        repository.deleteById(id);
    }

}
