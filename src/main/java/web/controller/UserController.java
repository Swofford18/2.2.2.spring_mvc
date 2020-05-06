package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceInt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping(value = "/")
public class UserController {

    private UserServiceInt userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "user")
    public String helloUser(ModelMap model, Principal principal) {
        String username = principal.getName();
        User user = (User) userService.loadUserByUsername(username);
        model.addAttribute("user", user);
        return "user_page";
    }
}
