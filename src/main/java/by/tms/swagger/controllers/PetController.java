package by.tms.swagger.controllers;
import by.tms.swagger.models.Pet;
import by.tms.swagger.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/pet")
public class PetController {
    @Autowired
    PetService petService;

    @PostMapping
    public ResponseEntity<Pet> newPet(@RequestBody @Valid Pet pet) {
        petService.save(pet);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> deleteById(@PathVariable("id") int id) {
        if (petService.deleteByIdd(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@PathVariable("id") int id) {
        Pet getById = petService.getById(id);
        if (getById != null) {
            return new ResponseEntity<>(getById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
