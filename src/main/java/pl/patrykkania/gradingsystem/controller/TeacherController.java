package pl.patrykkania.gradingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.patrykkania.gradingsystem.model.Student;
import pl.patrykkania.gradingsystem.model.StudentClass;
import pl.patrykkania.gradingsystem.model.Subject;
import pl.patrykkania.gradingsystem.model.Teacher;
import pl.patrykkania.gradingsystem.service.StudentClassService;
import pl.patrykkania.gradingsystem.service.StudentService;
import pl.patrykkania.gradingsystem.service.SubjectService;
import pl.patrykkania.gradingsystem.service.TeacherService;

import java.util.Collections;
import java.util.List;

@Controller
public class TeacherController {

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
        List<StudentClass> availablesStudentClass = subjectService.findClassesByTeacherId(TeacherId);
        model.addAttribute("availablesStudentClass", availablesStudentClass);
        model.addAttribute("email", TeacherId);
        return "teacher/add-grade";
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
            //int intValue = teacher;
            //Long teacherId= Long.valueOf(intValue);
            List<Subject> subjects = subjectService.getSubjectsByClassIdAndTeacherId(id,teacherId);
            return ResponseEntity.ok(subjects);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

}
