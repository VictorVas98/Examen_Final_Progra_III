package com.example.sesion15.services;

import com.example.sesion15.entities.Tarea;
import com.example.sesion15.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository repository;

    public List<Tarea> findAll(){
        return repository.findAll();
    };
    public Tarea findById(Long id){
        return repository.findById(id).orElse(null);
    };
    public void create(Tarea tarea){
        repository.save(tarea);
    };
    public void update(Long id, Tarea tarea){
        if (repository.existsById(id)){
            tarea.setId(id);
            repository.save(tarea);
        }

    };
    public void delete(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    };
}
