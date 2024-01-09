package pl.patrykkania.gradingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.patrykkania.gradingsystem.model.Student;
import pl.patrykkania.gradingsystem.model.StudentClass;
import pl.patrykkania.gradingsystem.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
//    @Query("SELECT s.studentClass FROM Subject s WHERE s.teacher = :teacherId")
//    List<StudentClass> findClassesByTeacherId(@Param("teacherId") Long teacherId);
List<Subject> findByTeacherId(Long teacherId);

//    List<Subject> findByStudentClassId(Long id);
    List<Subject> findByStudentClassIdAndTeacherId(Long studentClassId, Long teacherId);

}

