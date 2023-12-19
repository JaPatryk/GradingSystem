package pl.patrykkania.gradingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.patrykkania.gradingsystem.model.Student;
import pl.patrykkania.gradingsystem.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public Student save(Student student) {
        String hashedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(hashedPassword);
        student.setRoles(1);
        validatePeselUniqueness(student.getPesel());
        return studentRepository.save(student);
    }

    private void validatePeselUniqueness(String pesel) {
        if (studentRepository.existsByPesel(pesel)) {
            throw new IllegalArgumentException("Numer PESEL już istnieje w bazie danych.");
        }
    }
}
