package one.tsv.Prak22.repositories;

import one.tsv.Prak22.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>{
    Optional<List<Student>> getAllBy();
    Optional<Integer> deleteStudentById(Long id);
}
