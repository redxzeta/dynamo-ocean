package com.ocean.dynamo.controller;

import com.ocean.dynamo.entity.Stands;
import com.ocean.dynamo.repo.StandsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stands")
public class StandController {
    @Autowired
    private StandsRepo standsRepo;

    @PostMapping
    public Stands save(@RequestBody Stands stands) {
        return standsRepo.save(stands);
    }

    @GetMapping("/{id}")
    public Stands findById(@PathVariable(value = "id") String id) {
        return standsRepo.findById(id);
    }

    @GetMapping
    public List<Stands> findAll() {
        return standsRepo.findAll();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable(value = "id") String id, @RequestBody Stands stands) {
        return standsRepo.update(id, stands);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") String id) {
        return standsRepo.delete(id);
    }
}
