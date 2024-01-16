package pl.patrykkania.gradingsystem.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.patrykkania.gradingsystem.model.Teacher;
import pl.patrykkania.gradingsystem.repository.TeacherRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void testExistsByPesel() {

        String pesel = "1274578901";


        assertFalse(teacherRepository.existsByPesel(pesel));


        Teacher teacher = new Teacher();
        teacher.setPesel(pesel);
        teacherRepository.save(teacher);


        assertTrue(teacherRepository.existsByPesel(pesel));
    }


}
