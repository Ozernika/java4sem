package one.tsv.Prak18.services;

import lombok.RequiredArgsConstructor;
import one.tsv.Prak18.models.Student;
import one.tsv.Prak18.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.getAllBy().orElseThrow();
    }

    public void addStudent(Student student) {
        repository.save(student);
    }

    public Integer deleteStudentById(Long id) {
        return repository.deleteStudentById(id).orElseThrow();
    }
}
