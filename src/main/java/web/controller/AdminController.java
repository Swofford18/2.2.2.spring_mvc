package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceInt;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserServiceInt userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String printUsers(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/add")
    public String newUserPage() {
        return "new_user";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable("id") long id){
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @PostMapping(value = "/add")
    public String addUser(HttpServletRequest req) {

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        userService.add(new User(username, password, email));

        return "redirect:/admin";
    }

    @GetMapping(value = "/update/{id}")
    public String updateUserG(@PathVariable("id") long id, ModelMap model) {

        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping(value = "/update")
    public String updateUser(HttpServletRequest req) {

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        long id = Long.parseLong(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        userService.updateUser(new User(id, username, password, email));

        return "redirect:/admin";
    }


}
