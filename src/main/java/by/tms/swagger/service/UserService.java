package by.tms.swagger.service;
import by.tms.swagger.models.User;
import by.tms.swagger.storage.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    InMemoryUserStorage inMemoryUserStorage;

    public boolean save(User user){
        return inMemoryUserStorage.add(user);
    }

   public void addAll(List<User> users){
        for(User user:users){
            inMemoryUserStorage.add(user);
        }
   }

    public User getByUserName(String userName){
        return inMemoryUserStorage.getByUserName(userName);
    }

    public boolean deleteByUserName(String userName){
        return inMemoryUserStorage.deleteUser(userName);
    }


}
