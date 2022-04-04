package com.msr.tzis;

import com.msr.tzis.model.Kabine;
import com.msr.tzis.model.KabineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class KabineController {
    private final KabineRepository repository;

    public KabineController(KabineRepository repository){
        this.repository = repository;
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
        repository.deleteById(id);
    }

}
