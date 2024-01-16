package pl.patrykkania.gradingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykkania.gradingsystem.model.Student;
import pl.patrykkania.gradingsystem.model.StudentClass;
import pl.patrykkania.gradingsystem.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByTeacherId(Long teacherId);

    List<Subject> findByStudentClassIdAndTeacherId(Long studentClassId, Long teacherId);

    List<Subject> findByStudentClass_Id(Long classId);


    List<Subject> findByStudentClass(Optional<StudentClass> studentClass);

}

