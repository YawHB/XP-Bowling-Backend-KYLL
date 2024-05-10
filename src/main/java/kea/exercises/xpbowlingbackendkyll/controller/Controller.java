package kea.exercises.xpbowlingbackendkyll.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class Controller {
    @GetMapping("/hello")
    public String index() {
    return "Hello World!";
}


}
