package pl.patrykkania.gradingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykkania.gradingsystem.model.Grade;
import pl.patrykkania.gradingsystem.model.StudentClass;

import java.util.List;

public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {

}

