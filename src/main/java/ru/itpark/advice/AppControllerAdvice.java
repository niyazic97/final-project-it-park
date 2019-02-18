package ru.itpark.advice;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itpark.exception.FilmsNotFoundException;

@ControllerAdvice
public class AppControllerAdvice {
@ResponseStatus(HttpStatus.NOT_FOUND)
@ExceptionHandler(FilmsNotFoundException.class)
    public String handleFilmsNotFoundException(Model model){
    model.addAttribute("message","Данный фильм еще не был добавлен на сайт");
return "error";
}
}
