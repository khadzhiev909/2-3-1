package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/save")
    public String addNew(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping()
    public String getAll(Model model) {
        List<User> users =  userService.getAll();
        model.addAttribute("allUsers", users);
        return "all-user";
    }

    @GetMapping("/update")
    public String updateNewForm(Model model,@RequestParam("id") int id) {
        model.addAttribute("user", userService.findById(id));
        return "update";
    }

    @PatchMapping("/update")
    public String update(@RequestParam("id") int id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

}