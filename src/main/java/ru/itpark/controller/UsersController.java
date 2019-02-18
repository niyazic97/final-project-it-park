package ru.itpark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.dto.UsersDto;
import ru.itpark.service.UsersService;

@Controller

public class UsersController {
    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }


    @GetMapping("/users")
    public String getAll(Model model) {
        model.addAttribute("items", service.getAll());
        return "users";
    }


    @GetMapping("/editUsers")
    public String gtAll(Model model) {
        return "EditUsers";
    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable int id, Model model) {
        model.addAttribute("item", service.getById(1));
        return "user";


    }

    @GetMapping("/{id}/editUsers")
    public String editUsers(@PathVariable int id, Model model) {
        model.addAttribute("item", service.getById(id));
        // страничка добавления/редактирования
        return "editUsers";
    }

    @PostMapping("/{id}/editUsers")
    public String editUsers(
            @PathVariable int id,
            @ModelAttribute UsersDto usersDto
    ) {
        service.updateUsers(usersDto, id);
        return "redirect:/user/"+id;
    }

    @GetMapping("/profile")
    public String userPost(){
       Integer id =1;
        service.getById(id);
        return "redirect:/user/"+id;
    }

}
