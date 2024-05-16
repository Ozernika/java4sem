package one.tsv.Prak22.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.tsv.Prak22.models.Student;
import one.tsv.Prak22.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository repository;

    @Transactional
    public List<Student> getAllStudents() {
        log.info("Getting all students");
        return repository.getAllBy().orElseThrow();
    }
    @Transactional
    public void addStudent(Student student) {
        log.info("Adding student: {}", student);
        repository.save(student);
    }
    @Transactional
    public Integer deleteStudentById(Long id) {
        log.info("Deleting student with ID: {}", id);
        return repository.deleteStudentById(id).orElseThrow();
    }
}
