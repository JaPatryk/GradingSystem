package pl.patrykkania.gradingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykkania.gradingsystem.model.Teacher;
import pl.patrykkania.gradingsystem.model.User;

import java.util.Optional;

public interface TeacherRepository  extends JpaRepository<Teacher, Long> {
    boolean existsByPesel(String pesel);

    Optional<Teacher> findTeacherById(Long id);

}
