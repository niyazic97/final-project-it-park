package ru.itpark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.dto.UsersDto;
import ru.itpark.entity.FilmsEntity;
import ru.itpark.entity.UsersEntity;
import ru.itpark.service.FilmsService;
import ru.itpark.service.SubscriptionService;

@Controller
@RequestMapping("/film")

public class SubscriptionController {
    private final SubscriptionService service;
    private final FilmsService filmsService;

    public SubscriptionController(SubscriptionService service, FilmsService filmsService) {
        this.service = service;
        this.filmsService = filmsService;
    }

    @GetMapping("/{id}/allFilms")
    public String subscription(@PathVariable int id, Model model) {
        model.addAttribute("items", filmsService.getBySubscriptions(service.getSubscriptionByUserId(id)));
        return "allFilms";
    }

    @GetMapping("/{filmId}/subscribe")
    public String subPost(@PathVariable Integer filmId) {
        service.save(1, filmId);
        return "redirect:/allFilms";
    }

    @GetMapping("/{filmId}/unSubscribe")
    public String deleteSubscription(@PathVariable Integer filmId) {
        service.removeByUserIdAndFilmId(1, filmId);
        return "redirect:/allFilms";
    }

}
