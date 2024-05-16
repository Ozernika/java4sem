package one.tsv.Prak20.repositories;

import one.tsv.Prak20.models.Student;

import java.util.List;

public interface CriteriaStudentRepository {
    List<Student> getStudentsByCriteria(String firstName, String lastName, String middleName);
}
