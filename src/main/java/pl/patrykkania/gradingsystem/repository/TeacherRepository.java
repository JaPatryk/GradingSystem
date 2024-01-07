package pl.patrykkania.gradingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykkania.gradingsystem.model.Teacher;

public interface TeacherRepository  extends JpaRepository<Teacher, Long> {
    boolean existsByPesel(String pesel);
}
