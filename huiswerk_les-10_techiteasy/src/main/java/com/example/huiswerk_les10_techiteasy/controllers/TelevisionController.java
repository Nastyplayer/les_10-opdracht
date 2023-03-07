package com.example.huiswerk_les10_techiteasy.controllers;

import com.example.huiswerk_les10_techiteasy.Repository.TelevisionRepository;
import com.example.huiswerk_les10_techiteasy.exceptions.RecordNotFoundException;
import com.example.huiswerk_les10_techiteasy.module.Television;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;

@RestController
    public class TelevisionController {

   @Autowired
   TelevisionRepository repo;
                     //  public static final List<String> televisionDatabase = new ArrayList<>();

 private ArrayList<Television> televisions;
                     //= new ArrayList<Television>();
 public TelevisionController() {
        //  ArrayList<Object>
   televisions = new ArrayList<>();
    Television television = new Television();
     {
      television.setName("SonyTV");
      television.setBrand("Sony");
     television.setPrice(700);

     }


     televisions.add(television);

    }


    @GetMapping("televisions")
    public ResponseEntity<Object> getTelevisions() {
     return ResponseEntity.ok(televisions);
    }


    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevisions(@PathVariable int id) {
                            //  if (id < televisions.size()) {
        if (id < 10) {
            return new ResponseEntity<>(televisions.get(id), HttpStatus.OK);
                            //  return new ResponseEntity<>("Televisions:  " + id + "!", HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("id not found");
                           //    return new ResponseEntity<>("invalid id", HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/televisions")
   // public ResponseEntity<Object> createTelevisions(@RequestBody(required = false) Television television) {
                         public ResponseEntity<Object> addTelevision(@RequestBody String television) {
                        Object televisions = null;
       // Television.add(television);

                         //return  ResponseEntity.ok("Sony, Samsung" );

        return ResponseEntity.created(URI.create("Television")).body(televisions);
                         // return new ResponseEntity<>("hola", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }



    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name) {
        repo.deleteByName(name);
        return ResponseEntity.noContent().build();
    }






    @PutMapping("/televisions/{id}")

    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String television) {
       if (id >= 0 && id < televisions.size() ) {
          Television.set(id, television);


         return ResponseEntity.noContent().build();
       } else {
           throw new RecordNotFoundException("no found", HttpStatus.NOT_FOUND);
       }}}



