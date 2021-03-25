package com.uniamerica.avaliation.service;

import com.uniamerica.avaliation.model.Vehicle;
import com.uniamerica.avaliation.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle save(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findAll(){
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> findOne(long id){
        return  vehicleRepository.findById(id);
    }

    public Vehicle update(Vehicle vehicle) {
        Optional<Vehicle> optionalVehicle = this.findOne(vehicle.getId());

        if (optionalVehicle.isPresent()){
            return this.save(vehicle);
        }else {
            return null;
        }
    }

    public void delete(Long id) {
        Optional<Vehicle> optionalVehicle = this.findOne(id);

        if (optionalVehicle.isPresent()){
            vehicleRepository.deleteById(id);
        }
    }
}
