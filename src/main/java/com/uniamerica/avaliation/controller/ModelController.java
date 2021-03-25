package com.uniamerica.avaliation.controller;

import com.uniamerica.avaliation.model.Model;
import com.uniamerica.avaliation.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/models")
public class ModelController {
    private  final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public ResponseEntity<Model> save(@RequestBody Model model) {
        return ResponseEntity.ok(modelService.save(model));
    }

    @GetMapping
    public ResponseEntity<List<Model>> list(){
        return ResponseEntity.ok(modelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Model>> findById(@PathVariable Long id){
        return ResponseEntity.ok(modelService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> update(@RequestBody Model model){
        return ResponseEntity.ok(modelService.update(model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        modelService.delete(id);
        return ResponseEntity.ok(null);
    }
}
