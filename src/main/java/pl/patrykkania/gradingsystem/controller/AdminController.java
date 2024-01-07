package pl.patrykkania.gradingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.patrykkania.gradingsystem.model.Student;
import pl.patrykkania.gradingsystem.model.StudentClass;
import pl.patrykkania.gradingsystem.model.Teacher;
import pl.patrykkania.gradingsystem.service.StudentClassService;
import pl.patrykkania.gradingsystem.service.StudentService;
import pl.patrykkania.gradingsystem.service.TeacherService;

import java.util.List;


@Controller
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentClassService studentClassService;
    @GetMapping("/admin")
    String Home() {
        return "home";
    }


    @GetMapping("/admin/add-student")
    String AddStudent(Model model) {

        Student student = new Student();
        List<StudentClass> availableClasses = studentClassService.getAllClasses();

        model.addAttribute("student", student);
        model.addAttribute("availableClasses", availableClasses);
        return "admin/add-student";
    }

    @GetMapping("/admin/add-teacher")
    String AddTeacher() {
        return "admin/add-teacher";
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

    @PostMapping("admin/add-teacher")
    public void addTeacher(@ModelAttribute Teacher teacher, ModelMap model) {
        try {
            teacherService.save(teacher);
            model.addAttribute("message", "Student został pomyślnie dodany");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        } catch (Exception e) {
            model.addAttribute("error", "Wystąpił nieoczekiwany błąd.");
        }
    }


}
