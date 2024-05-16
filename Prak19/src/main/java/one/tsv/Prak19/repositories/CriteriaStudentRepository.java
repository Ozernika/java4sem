package one.tsv.Prak19.repositories;

import one.tsv.Prak19.models.Student;

import java.util.List;

public interface CriteriaStudentRepository {
    List<Student> getStudentsByCriteria(String firstName, String lastName, String middleName);
}
