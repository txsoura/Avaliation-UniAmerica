package com.uniamerica.avaliation.controller;

import com.uniamerica.avaliation.model.Brand;
import com.uniamerica.avaliation.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brands")
public class BrandController {
    private  final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<Brand> save(@RequestBody Brand brand) {
        return ResponseEntity.ok(brandService.save(brand));
    }

    @GetMapping
    public ResponseEntity<List<Brand>> list(){
        return ResponseEntity.ok(brandService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Brand>> findById(@PathVariable Long id){
        return ResponseEntity.ok(brandService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> update(@RequestBody Brand brand){
        return ResponseEntity.ok(brandService.update(brand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        brandService.delete(id);
        return ResponseEntity.ok(null);
    }
}
