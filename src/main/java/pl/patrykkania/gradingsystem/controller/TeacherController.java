package pl.patrykkania.gradingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import pl.patrykkania.gradingsystem.model.*;
import pl.patrykkania.gradingsystem.repository.StudentClassRepository;
import pl.patrykkania.gradingsystem.service.*;

import java.util.*;

@Controller
public class TeacherController {


    @Autowired
    StudentClassRepository studentClassRepository;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentClassService studentClassService;

    @Autowired
    private SubjectService subjectService;
    @GetMapping("/teacher")
    String Home() {


        return "teacher/teacher";
    }

    @GetMapping("/teacher/list")
    String List(ModelMap model) {

        List<StudentClass> availableClasses = studentClassService.getAllClasses();
        model.addAttribute("availableClasses", availableClasses);

        return "teacher/student-list";
    }

    @GetMapping("/teacher/add-grade")
    String addGrade(ModelMap model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String teacherEmail = authentication.getName();
        Teacher teacher = teacherService.getTeachersByEmail(teacherEmail);
        Long TeacherId = teacher.getId();
        String email = teacher.getEmail();
        List<StudentClass> availablesStudentClass = subjectService.findClassesByTeacherId(TeacherId);
        model.addAttribute("availablesStudentClass", availablesStudentClass);
        model.addAttribute("email", email);
        model.addAttribute("teacherId", TeacherId);
        return "/teacher/add-grade";
    }



    @PostMapping("/teacher/add-grade")
    public String addGrade(@ModelAttribute Grade grade) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String teacherEmail = authentication.getName();
//        System.out.println(teacherEmail);
//        Long id = grade.getTeacher().getId();
  //      System.out.println(id);
//        Teacher teacher = teacherService.getTeachersByEmail(teacherEmail);

        Grade newGrade = new Grade();
        newGrade.setTeacher(grade.getTeacher());
        newGrade.setDate(new Date());
        newGrade.setSubject(grade.getSubject());
        newGrade.setStudent(grade.getStudent());
        newGrade.setGrade(grade.getGrade());

        gradeService.createGrade(newGrade);
        System.out.println("Dodao"+ newGrade.getId());
        return "redirect:/teacher/add-grade";
    }


    @GetMapping("/teacher/listStudents")
    public ResponseEntity<List<Student>> listStudents(@RequestParam String className) {
        try {
            List<Student> students = studentService.getStudentsByClassName(className);
            return ResponseEntity.ok(students);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }


    @GetMapping("/teacher/listSubject")
    public ResponseEntity<List<Subject>> listSubject(@RequestParam String className, @RequestParam Long teacherId) {
        try {
            Long id= studentClassService.getClassByName(className);
            List<Subject> subjects = subjectService.getSubjectsByClassIdAndTeacherId(id,teacherId);
            return ResponseEntity.ok(subjects);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

}




