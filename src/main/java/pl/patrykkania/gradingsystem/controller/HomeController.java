package pl.patrykkania.gradingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HomeController {

    @GetMapping("/")
    String Home() {
        return "home";
    }
}
