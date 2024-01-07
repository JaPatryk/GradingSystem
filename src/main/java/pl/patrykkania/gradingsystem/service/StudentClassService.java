package pl.patrykkania.gradingsystem.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patrykkania.gradingsystem.model.Grade;
import pl.patrykkania.gradingsystem.model.Student;
import pl.patrykkania.gradingsystem.model.StudentClass;
import pl.patrykkania.gradingsystem.repository.GradeRepository;
import pl.patrykkania.gradingsystem.repository.StudentClassRepository;

import java.util.Collections;
import java.util.List;

@Service
public class StudentClassService {

    @Autowired
    private StudentClassRepository studentClassRepository;


    public List<StudentClass> getAllClasses() {
        return studentClassRepository.findAll();
    }


    public StudentClass getClassById(Long id) {
        return studentClassRepository.findById(id).orElse(null);
    }


    public void saveClass(StudentClass studentClass) {
        studentClassRepository.save(studentClass);
    }


    // zmiany

}
