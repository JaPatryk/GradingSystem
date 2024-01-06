package pl.patrykkania.gradingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.patrykkania.gradingsystem.model.Student;
import pl.patrykkania.gradingsystem.service.StudentService;



@Controller
public class AdminController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/admin")
    String Home() {
        return "home";
    }


    @GetMapping("/admin/add-student")
    String AddStudent() {
        return "admin/add-student";
    }

    @PostMapping("admin/add-student")
    public void addStudent(@ModelAttribute Student student, ModelMap model) {
        try {
            studentService.save(student);
            model.addAttribute("message", "Student został pomyślnie dodany");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        } catch (Exception e) {
            model.addAttribute("error", "Wystąpił nieoczekiwany błąd.");
        }

//        return "redirect:/admin/add-student";

    }


}
