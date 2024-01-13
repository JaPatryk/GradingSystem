package pl.patrykkania.gradingsystem.repository;

import pl.patrykkania.gradingsystem.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
//    // Tu można dodać dodatkowe metody związane z operacjami na ocenach, np.:
//    List<Grade> findByTeacherId(Long teacherId);
//    List<Grade> findBySubjectIdAndTeacherId(Long subjectId, Long teacherId);
//
//    List<Grade> findBySubject_IdAndTeacher_Id(Long subjectId, Long teacherId);
//    // ...


    List<Grade> findBySubject_IdAndTeacher_Id(Long subjectId, Long teacherId);

    List<Grade> findByStudent_Id(Long studentId);


}





