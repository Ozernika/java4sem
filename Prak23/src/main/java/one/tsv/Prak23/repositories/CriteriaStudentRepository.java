package one.tsv.Prak23.repositories;

import one.tsv.Prak23.models.Student;

import java.util.List;

public interface CriteriaStudentRepository {
    List<Student> getStudentsByCriteria(String firstName, String lastName, String middleName);
}
