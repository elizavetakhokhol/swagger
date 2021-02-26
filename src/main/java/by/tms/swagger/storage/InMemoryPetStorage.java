package by.tms.swagger.storage;

import by.tms.swagger.models.Pet;
import by.tms.swagger.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryPetStorage {
    private static List<Pet> pets = new ArrayList<>();

    public Pet getById(long id){
        for (Pet pet : pets) {
            if (pet.getId()==id) {
                return pet;
            }
        }
        return null;
    }

    public boolean add(Pet pet) {
        if (pets.contains(pet)) {
            return false;
        }
        pets.add(pet);
        return true;
    }

    public boolean deleteById(int id){
        for (Pet pet : pets) {
            if (pet.getId()==id) {
                pets.remove(pet);
                return true;
            }
        }
        return false;
    }
}


