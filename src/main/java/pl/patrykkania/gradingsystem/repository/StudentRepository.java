package pl.patrykkania.gradingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykkania.gradingsystem.model.Student;
import pl.patrykkania.gradingsystem.model.StudentClass;
import pl.patrykkania.gradingsystem.model.User;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByPesel(String pesel);

//zmiany
Optional<Student> findByEmail(String email);

    List<Student> findByStudentClass_Name(String className);
}
