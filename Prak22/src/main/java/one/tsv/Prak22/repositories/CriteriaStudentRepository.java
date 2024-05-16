package one.tsv.Prak22.repositories;

import one.tsv.Prak22.models.Student;

import java.util.List;

public interface CriteriaStudentRepository {
    List<Student> getStudentsByCriteria(String firstName, String lastName, String middleName);
}
