package pl.patrykkania.gradingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykkania.gradingsystem.model.Grade;
import pl.patrykkania.gradingsystem.model.StudentClass;
import pl.patrykkania.gradingsystem.model.Subject;

import java.util.List;
import java.util.Optional;

public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {




    Optional<StudentClass> findByName(String name);
}

