package one.tsv.Prak22.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import one.tsv.Prak22.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class CriteriaStudentRepositoryImpl implements CriteriaStudentRepository {
    private EntityManager entityManager;

    @Override
    public List<Student> getStudentsByCriteria(String firstName, String lastName, String middleName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> student = cq.from(Student.class);
        List<Predicate> predicates = new ArrayList<>();

        if (firstName != null) {
            predicates.add(cb.equal(student.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicates.add(cb.equal(student.get("lastName"), lastName));
        }
        if (middleName != null) {
            predicates.add(cb.equal(student.get("middleName"), middleName));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
