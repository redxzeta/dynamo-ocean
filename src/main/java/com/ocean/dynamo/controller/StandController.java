package com.ocean.dynamo.controller;

import com.ocean.dynamo.dtos.StandDTO;
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
    public Stands save(@RequestBody StandDTO standDTO) {
        Stands userStand = new Stands().dtoToEntity(standDTO);
        Stands savedStand = standsRepo.save(userStand);
        System.out.println(savedStand.toString());
        return savedStand;
    }

    @GetMapping("/{id}")
    public Stands findById(@PathVariable(value = "id") String id) {
        System.out.println(standsRepo.findById(id).toString());
        return standsRepo.findById(id);
    }

    @GetMapping
    public List<Stands> findAll() {
        return standsRepo.findAll();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable(value = "id") String id, @RequestBody StandDTO standDTO) {
        Stands currentStand = standsRepo.findById(id);
        currentStand.setName(standDTO.getName());
        currentStand.setAbility(standDTO.getAbility());
        currentStand.setPart(standDTO.getPart());
        return standsRepo.update(id, currentStand);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") String id) {
        return standsRepo.delete(id);
    }
}
