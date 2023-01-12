package com.example.demo;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.ErrorHandler;

@ControllerAdvice
class ErrorrHandlerController2 {

    @ResponseBody
    @ExceptionHandler(ErrorrHandler.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(ErrorrHandler ex) {
        return ex.getMessage();
    }
}

@RestController
public class ErrorrHandlerController  implements ErrorController {

    @GetMapping("/error")
    public String customError(ErrorrHandler ex) {
        return ex.getMessage();
    }


    public String getErrorPath() {
        return "/error";
    }
}