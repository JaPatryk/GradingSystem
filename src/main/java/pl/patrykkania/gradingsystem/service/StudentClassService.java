package pl.patrykkania.gradingsystem.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patrykkania.gradingsystem.model.Grade;
import pl.patrykkania.gradingsystem.model.Student;
import pl.patrykkania.gradingsystem.model.StudentClass;
import pl.patrykkania.gradingsystem.model.Subject;
import pl.patrykkania.gradingsystem.repository.GradeRepository;
import pl.patrykkania.gradingsystem.repository.StudentClassRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

public Long getClassByName(String name) {
    Optional<StudentClass> studentClassOptional = studentClassRepository.findByName(name);

    if (studentClassOptional.isPresent()) {
        return studentClassOptional.get().getId();
    } else {
        return null;
    }
}
    public void saveClass(StudentClass studentClass) {
        studentClassRepository.save(studentClass);
    }




}

