package by.tms.swagger.service;
import by.tms.swagger.models.Pet;
import by.tms.swagger.storage.InMemoryPetStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    InMemoryPetStorage inMemoryPetStorage;

    public Pet getById(long id){
        return inMemoryPetStorage.getById(id);
    }

    public boolean save(Pet pet){
        return inMemoryPetStorage.add(pet);
    }
    public boolean deleteByIdd(int id){
        return inMemoryPetStorage.deleteById(id);
    }
}
