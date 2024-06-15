package com.example.sesion15.controllers;

import com.example.sesion15.entities.Tarea;
import com.example.sesion15.services.TareaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    private TareaService tareaService;

    public TareaController(TareaService tareaService){
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> GetAll(){
        return tareaService.findAll();
    }

    @GetMapping(value="/{id}")
    public Tarea GetById(@PathVariable Long id){
        return tareaService.findById(id);
    }


    @PostMapping
    public void create( @Valid @RequestBody Tarea tarea){
        tareaService.create(tarea);
    }

    @PutMapping(value="/{id}")
    public void update (@PathVariable Long id,
                        @RequestBody Tarea tarea){
        tareaService.update(id, tarea);
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable Long id){
        tareaService.delete(id);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(
        MethodArgumentNotValidException ex
    ){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
