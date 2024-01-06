package pl.patrykkania.gradingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykkania.gradingsystem.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByPesel(String pesel);
}
