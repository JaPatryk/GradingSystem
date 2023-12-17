package pl.patrykkania.gradingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class StudentController {

    @GetMapping("/student")
    String Home() {
        return "student/student";
    }
}
