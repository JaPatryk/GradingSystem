package pl.patrykkania.gradingsystem.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patrykkania.gradingsystem.model.Grade;
import pl.patrykkania.gradingsystem.repository.GradeRepository;

import java.util.List;
    @Service
    public class GradeService {

        private final GradeRepository gradeRepository;

        @Autowired
        public GradeService(GradeRepository gradeRepository) {
            this.gradeRepository = gradeRepository;
        }

        public List<Grade> getAllGrades() {
            return gradeRepository.findAll();
        }

        public Grade getGradeById(Long id) {
            return gradeRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Ocena o takim id nie została znaleziona"));
        }

        public Grade createGrade(Grade grade) {
            //tutaj cos mozna dorzucic zeby nie dalo sie innego niz 1-6 czy tam 2-5 jak tam bdmy robic wkoncu
            return gradeRepository.save(grade);
        }

        public Grade updateGrade(Long id, Grade grade) {
            Grade existingGrade = gradeRepository.findById(grade.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Ocena o takim id nie została znaleziona"));
            existingGrade.setGrade(grade.getGrade());
            existingGrade.setDate(grade.getDate());
            return gradeRepository.save(existingGrade);
        }

        public void deleteGrade(Long id) {
            gradeRepository.deleteById(id);
        }
        //no i chuj bo tutaj niby cos pododawac tez jeszcze mozna ale nw co


    }
