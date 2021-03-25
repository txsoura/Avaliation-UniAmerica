package com.uniamerica.avaliation.service;

import com.uniamerica.avaliation.model.Model;
import com.uniamerica.avaliation.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
     private final ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public Model save(Model model){
        return modelRepository.save(model);
    }

    public List<Model> findAll(){
        return modelRepository.findAll();
    }

    public Optional<Model> findOne(long id){
        return  modelRepository.findById(id);
    }

    public Model update(Model model) {
        Optional<Model> optionalModel = this.findOne(model.getId());

        if (optionalModel.isPresent()){
            return this.save(model);
        }else {
            return null;
        }
    }

    public void delete(Long id) {
        Optional<Model> optionalModel = this.findOne(id);

        if (optionalModel.isPresent()){
            modelRepository.deleteById(id);
        }
    }
}
