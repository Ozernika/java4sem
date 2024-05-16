package one.tsv.Prak19.repositories;

import one.tsv.Prak19.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    Optional<List<Student>> getAllBy();
    Optional<Integer> deleteStudentById(Long id);
}
