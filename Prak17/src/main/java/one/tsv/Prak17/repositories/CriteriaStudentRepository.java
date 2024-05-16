package one.tsv.Prak17.repositories;

import one.tsv.Prak17.models.Student;

import java.util.List;

public interface CriteriaStudentRepository {
    List<Student> getStudentsByCriteria(String firstName, String lastName, String middleName);
}
