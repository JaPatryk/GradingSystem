package pl.patrykkania.gradingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/")
    public String handleRequest() {
        // ... logika biznesowa

        return "redirect:/login";

    }
}
