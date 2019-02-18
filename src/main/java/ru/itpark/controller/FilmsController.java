package ru.itpark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.dto.FilmsDto;
import ru.itpark.entity.FilmsEntity;
import ru.itpark.service.FilmApiService;
import ru.itpark.service.FilmsService;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
@RequestMapping("/")
public class FilmsController {
    private final FilmsService service;
    private final FilmApiService filmApiService;

    public FilmsController(FilmsService service, FilmApiService filmApiService) {

        this.service = service;
        this.filmApiService = filmApiService;
    }

    @GetMapping("/allFilms")
    public String getAll(Model model) {

        model.addAttribute("items", service.getAll());
        return "allFilms";
    }
 @GetMapping("/addFilms")
    public String gtAll(Model model) {
        return "addFilms";
    }


    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        model.addAttribute("item", service.getById(id));

        return "view";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("item", service.getById(id));
        // страничка добавления/редактирования
        return "edit";
    }

    @GetMapping(value = "/search", params = "name") // Mapping - определяет то, что должно быть в запросе
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("items", service.getByName(name));
        return "allFilms";
    }

    @GetMapping(value = "/search", params = "genre") // Mapping - определяет то, что должно быть в запросе
    public String searchGenre(@RequestParam String genre, Model model) {
        model.addAttribute("genre", genre);
        model.addAttribute("items", service.getByGenre(genre));
        return "allFilms";
    }

    @GetMapping("/{id}/remove") // страничка удаления
    public String remove(
            @PathVariable int id,
            Model model) {
        model.addAttribute("item", service.getById(id));
        return "remove";
    }

    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable int id,
            @ModelAttribute FilmsDto filmsDto
    ) {
        service.updateFilms(filmsDto, id);
        return "redirect:/allFilms";
    }

    @PostMapping("/{id}/remove")
        public String remove(@PathVariable int id){
        service.deleteFilms(id);
        return "redirect:/allFilms";

    }


    @PostMapping("/addFilms")
    public String addFilms(@ModelAttribute FilmsDto filmsDto) {
        service.saveFilms(filmsDto);
        return "redirect:/allFilms";
    }


    @PostMapping("/{id}/addFilms")
    public String addFilms(@PathVariable Integer id) {
        service.saveFilms(filmApiService.getFilmDtoById(id));
        return "redirect:/allFilms";
    }
}


