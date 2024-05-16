package one.tsv.Prak18.repositories;

import one.tsv.Prak18.models.Student;

import java.util.List;

public interface CriteriaStudentRepository {
    List<Student> getStudentsByCriteria(String firstName, String lastName, String middleName);
}
