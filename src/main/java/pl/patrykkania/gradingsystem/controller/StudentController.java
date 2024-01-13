package pl.patrykkania.gradingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import pl.patrykkania.gradingsystem.model.*;
import pl.patrykkania.gradingsystem.service.GradeService;
import pl.patrykkania.gradingsystem.service.StudentService;
import pl.patrykkania.gradingsystem.service.SubjectService;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    GradeService gradeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;
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

    @GetMapping("/student/oceny")
    String Grade(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        Optional<Student> studentOptional = studentService.getStudentByEmail(userEmail);
        if (studentOptional.isPresent()) {
            StudentClass studentClass = studentOptional.get().getClassName();
            Long studentClassId = studentClass.getId();
            List<Subject> subjects = subjectService.getSubjectsByClassId(studentClassId);
            List<Grade> grades = gradeService.getGradesByStudentId(studentOptional.get().getId());


            //List<Subject> subjects = subjectService.getSubjectsByStudentClass(studentClass);
            model.addAttribute("subjects",subjects);
            model.addAttribute("grades",grades);
            // Teraz możesz używać studentId do czegoś, co chcesz zrobić z identyfikatorem studenta
        }



        return "student/student-grade";
    }



}
