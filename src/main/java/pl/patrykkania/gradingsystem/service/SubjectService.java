package pl.patrykkania.gradingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.patrykkania.gradingsystem.model.Subject;
import pl.patrykkania.gradingsystem.model.Subject;
import pl.patrykkania.gradingsystem.repository.SubjectRepository;
import pl.patrykkania.gradingsystem.repository.SubjectRepository;
import pl.patrykkania.gradingsystem.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    

    
    public Subject save(Subject subject) {

        return subjectRepository.save(subject);
    }

 
}
