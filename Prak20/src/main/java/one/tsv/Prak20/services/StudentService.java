package one.tsv.Prak20.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.tsv.Prak20.models.Student;
import one.tsv.Prak20.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Slf4j
public class StudentService {
    private final StudentRepository repository;
    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    private static final Logger log = LoggerFactory.getLogger(StudentService.class);

    public List<Student> getAllStudents() {
        log.info("Getting all students");
        return repository.getAllBy().orElseThrow();
    }

    public void addStudent(Student student) {
        log.info("Adding student: {}", student);
        repository.save(student);
    }

    public Integer deleteStudentById(Long id) {
        log.info("Deleting student with ID: {}", id);
        return repository.deleteStudentById(id).orElseThrow();
    }
}
