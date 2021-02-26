package by.tms.swagger.storage;

import by.tms.swagger.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryUserStorage {
    private static List<User> users = new ArrayList<>();

    public boolean add(User user) {
        if (users.contains(user)) {
            return false;
        }
        users.add(user);
        return true;
    }

    public User getByUserName(String userName){
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(String userName){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(userName)) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }
}
