package com.msr.tzis;

import com.msr.tzis.model.Desktop;
import com.msr.tzis.model.DesktopRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DesktopController {
    private final DesktopRepository repository;

    public DesktopController(DesktopRepository repository){
        this.repository = repository;
    }

    @GetMapping("/desktop")
    @CrossOrigin(origins = "*")
    List<Desktop> all(){
        return repository.findAll();
    }

    @PostMapping("/desktop")
    @CrossOrigin(origins = "*")
    Desktop newDesktop(@RequestBody Desktop newDesktop){
        return repository.save(newDesktop);
    }

    @GetMapping("/desktop/{id}")
    @CrossOrigin(origins = "*")
    Desktop one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new DesktopNotFoundException(id));
    }

    @PutMapping("/desktop/{id}")
    @CrossOrigin(origins = "*")
    Desktop replaceDesktop(@RequestBody Desktop newDesktop, @PathVariable Long id){
        return repository.findById(id)
                .map(desktop -> {
                    desktop.setName(newDesktop.getName());
                    desktop.setChanges_allowed(newDesktop.getChanges_allowed());
                    desktop.setReceives_demands(newDesktop.getReceives_demands());
                    return repository.save(desktop);
                })
                .orElseGet(() -> {
                    newDesktop.setId(id);
                    return repository.save(newDesktop);
                });
    }

    @DeleteMapping("/desktop/{id}")
    @CrossOrigin(origins = "*")
    void deleteDesktop(@PathVariable Long id){
        repository.deleteById(id);
    }
}
