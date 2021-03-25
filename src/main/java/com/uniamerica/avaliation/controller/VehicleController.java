package com.uniamerica.avaliation.controller;

import com.uniamerica.avaliation.model.Vehicle;
import com.uniamerica.avaliation.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private  final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.save(vehicle));
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> list(){
        return ResponseEntity.ok(vehicleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vehicle>> findById(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle){
        return ResponseEntity.ok(vehicleService.update(vehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        vehicleService.delete(id);
        return ResponseEntity.ok(null);
    }

}
