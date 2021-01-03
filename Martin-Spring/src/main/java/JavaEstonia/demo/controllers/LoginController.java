package JavaEstonia.demo.controllers;

import JavaEstonia.demo.entities.User;
import JavaEstonia.demo.services.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LoginController {

  /*  @GetMapping("response-text")
    public @ResponseBody String getResponse() {
        return "Hello Text";
    }*/

    final RegisterService registerService;

    @GetMapping("/login")
    String login() {return "login"; }

    @GetMapping("/register")
    String register() {
        return "register";
    }
/*
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser2(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {

        String firstName = user.getFirstname();
        System.out.println("BP eesnimi: " + firstName+" 2:"+user.firstname);
       // model.addAttribute("firstname", firstName);

        return "created-user";
    }
*/
    @PostMapping("/register")
    String createUser(@ModelAttribute User user, Model model) {
        registerService.createUser(user);
       // model.addAttribute("user", registerService.createUser(user));
        return "created-user";
    }
}
