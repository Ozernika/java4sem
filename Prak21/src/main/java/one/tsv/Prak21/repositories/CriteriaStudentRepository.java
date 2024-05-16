package one.tsv.Prak21.repositories;

import one.tsv.Prak21.models.Student;

import java.util.List;

public interface CriteriaStudentRepository {
    List<Student> getStudentsByCriteria(String firstName, String lastName, String middleName);
}
