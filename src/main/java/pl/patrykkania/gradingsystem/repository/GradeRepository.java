package pl.patrykkania.gradingsystem.repository;

import pl.patrykkania.gradingsystem.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    // Tu można dodać dodatkowe metody związane z operacjami na ocenach, np.:
    List<Grade> findByTeacherId(Long teacherId);
    List<Grade> findBySubjectIdAndTeacherId(Long subjectId, Long teacherId);
    // ...
}

//tutaj to w sumie trzeba wykminic jakie konkretnie chcemy i taki stworzyc bo mozna tu kobinacji wymyslic od chuja

