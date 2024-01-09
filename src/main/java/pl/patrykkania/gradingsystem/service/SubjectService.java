package pl.patrykkania.gradingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.patrykkania.gradingsystem.model.StudentClass;
import pl.patrykkania.gradingsystem.model.Subject;
import pl.patrykkania.gradingsystem.model.Subject;
import pl.patrykkania.gradingsystem.repository.SubjectRepository;
import pl.patrykkania.gradingsystem.repository.SubjectRepository;
import pl.patrykkania.gradingsystem.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    

    
    public Subject save(Subject subject) {

        return subjectRepository.save(subject);
    }

//    public List<Subject> getSubjectByClassId(Long id){
//
//        return subjectRepository.findByStudentClassId(id);
//    }





    public List<Subject> getSubjectsByClassIdAndTeacherId(Long classId, Long teacherId) {
        return subjectRepository.findByStudentClassIdAndTeacherId(classId, teacherId);
    }
//    public List<StudentClass> findClassesByTeacherId(Long teacherId) {
//        List<Subject> subjects = subjectRepository.findByTeacherId(teacherId);
//
//        // Przemapuj listę obiektów Subject na listę klas
//        return subjects.stream()
//                .map(Subject::getStudentClass)
//                .collect(Collectors.toList());
//    }
public List<StudentClass> findClassesByTeacherId(Long teacherId) {
    List<Subject> subjects = subjectRepository.findByTeacherId(teacherId);

    // Przemapuj listę obiektów Subject na listę klas, używając distinct
    return subjects.stream()
            .map(Subject::getStudentClass)
            .distinct()
            .collect(Collectors.toList());
}

}
