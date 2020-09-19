package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.models.User;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @GetMapping
    public String index(Model model){
        //we will have a key "users" that give us an array of users
        model.addAttribute("users", userDao.index());
        // getting all users

        return "index_users";
    }
    @GetMapping("/{id}")
    //with {id} we'll get an id from url and will have access to this variable inside this method
    public String show(@PathVariable("id") int id, Model model){
        //getting one user from id dao and give this to the view
        model.addAttribute("user", userDao.show(id));
        return "show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user){
        return "new";
    }
    @PostMapping
    public String create(@ModelAttribute("user") User user){
        userDao.save(user);
        return "redirect:/users";
    }
}
