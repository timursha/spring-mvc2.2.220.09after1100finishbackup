package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private static int STATIC_COUNT;
    private List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User(++STATIC_COUNT, "Ivan", "abc@mail.ru"));
        users.add(new User(++STATIC_COUNT, "Fedya", "deg@mail.ru"));
        users.add(new User(++STATIC_COUNT, "Vasya", "ign@mail.ru"));
    }

    public List<User> index(){
        return users;
    }
    public User show(int id){
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user){
        user.setId(++STATIC_COUNT);
        users.add(user);
    }
    public void changeUser(User user){

    }

}
