package pl.patrykkania.gradingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.patrykkania.gradingsystem.model.Student;
import pl.patrykkania.gradingsystem.model.StudentClass;
import pl.patrykkania.gradingsystem.model.Subject;
import pl.patrykkania.gradingsystem.model.Teacher;
import pl.patrykkania.gradingsystem.service.StudentClassService;
import pl.patrykkania.gradingsystem.service.StudentService;
import pl.patrykkania.gradingsystem.service.SubjectService;
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

    @Autowired
    private SubjectService subjectService;

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
    public void addStudent(@ModelAttribute Student student, ModelMap model, @RequestParam("studentClass.id") Long studentClassId) {
        try {
            StudentClass studentClass = studentClassService.getClassById(studentClassId);
            student.setStudentClass(studentClass);
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




    //Przedmioty
    @GetMapping("/admin/add-subject")
    String AddSubject(Model model) {
        List<StudentClass> availableClasses = studentClassService.getAllClasses();
        List<Teacher> availableTeachers = teacherService.getAllTeacherss();


        model.addAttribute("availableClasses", availableClasses);
        model.addAttribute("availableTeachers", availableTeachers);

        return "admin/add-subject";
    }

    @PostMapping("admin/add-subject")
    public void addStudent(@ModelAttribute Subject subject, ModelMap model, @RequestParam("studentClass.id") Long studentClassId,@RequestParam("teacher") Long teacherId) {
        try {
            StudentClass studentClass = studentClassService.getClassById(studentClassId);
            Teacher teacher = teacherService.getTeachersById(teacherId);
            subject.setStudentClass(studentClass);
            subject.setTeacher(teacher);

            subjectService.save(subject);
            model.addAttribute("message", "Przedmiot został pomyślnie dodany");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        } catch (Exception e) {
            model.addAttribute("error", "Wystąpił nieoczekiwany błąd.");
        }



//        return "redirect:/admin/add-student";

    }
}
