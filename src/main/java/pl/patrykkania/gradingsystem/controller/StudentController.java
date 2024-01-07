package pl.patrykkania.gradingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import pl.patrykkania.gradingsystem.model.Student;
import pl.patrykkania.gradingsystem.model.StudentClass;
import pl.patrykkania.gradingsystem.model.User;
import pl.patrykkania.gradingsystem.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/student")
    String Home() {

        return "student/student";
    }

    @GetMapping("/student/list")
    String List(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        List<Student> className = studentService.getStudentsInSameClass(userEmail);
        model.addAttribute("students",className);
        return "student/student-list";
    }




}
