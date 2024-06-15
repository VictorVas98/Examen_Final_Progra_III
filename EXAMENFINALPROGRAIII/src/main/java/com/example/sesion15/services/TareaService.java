package com.example.sesion15.services;

import com.example.sesion15.entities.Tarea;

import java.util.List;


public interface TareaService {

    public List<Tarea> findAll();
    public Tarea findById(Long id);
    public void create(Tarea tarea);
    public void update(Long id, Tarea tarea);
    public void delete(Long id);
}
