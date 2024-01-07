package pl.patrykkania.gradingsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String subjectName;

    private String leadingTeacher;//i tu kwestia chyba wlasnie czy robimy na sztywno nauczciela do przedmiotu bo jak tak to chyba tak zostaje
    // a jak nie to tu tez by byla relacja i juz obiekt teacher wtedy ale to faktycznie pierdoleia jak chuj

    public Subject() {
    }

    public Subject(String subjectName, String leadingTeacher) {
        this.subjectName = subjectName;
        this.leadingTeacher = leadingTeacher;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getLeadingTeacher() {
        return leadingTeacher;
    }

    public void setLeadingTeacher(String leadingTeacher) {
        this.leadingTeacher = leadingTeacher;
    }
}



