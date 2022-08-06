package com.example.Ejerciciossesiones789.controller;

import com.example.Ejerciciossesiones789.entities.Laptop;
import com.example.Ejerciciossesiones789.repository.LaptopRepository;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    //atributos
    private LaptopRepository laptopRepository;


    //constructor
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //Los métodos CRUD:

    //findAll()
    //Desde LaptopController crear un método que devuelva una lista de objetos Laptop.
    @GetMapping("/ordenadores")
    //@GetMapping("/")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    //findOneById()
    // Buscar un solo libro  por su id
    @GetMapping("/ordenadores/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if (laptopOpt.isPresent())
           return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();
       }

    // create()
    // Crear un método en LaptopController que reciba un objeto Laptop enviado en formato JSON desde Postman y persistirlo en la base de datos.
    @PostMapping("/ordenadores")
    public ResponseEntity<Laptop>  create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        // guardar laptop recibida por parametro en la BD
        if(laptop.getId() != null) {//Hay id no es creado
            log.warn("trying to create a laptop with id");
            System.out.println("trying to create a book with id");
            return ResponseEntity.badRequest().build();

        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //update()
    @PutMapping("/ordenadores")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {//si no tiene id quiere decir que si es una creación
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        } // El proceso de actualización
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //delete()
    // borrar una laptop en BD
    @DeleteMapping("/ordenadores/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {

        if (!laptopRepository.existsById(id)) {
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //deleteAll()
    @DeleteMapping("/ordenadores")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for delete all books");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
