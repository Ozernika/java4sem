package one.tsv.Prak23;

import one.tsv.Prak23.models.Student;
import one.tsv.Prak23.repositories.StudentRepository;
import one.tsv.Prak23.services.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentService service;

    @Test
    void testGetAllStudents() {
        // Arrange
        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Ozernaya");

        List<Student> studentList = Collections.singletonList(student1);

        Mockito.when(repository.getAllBy()).thenReturn(Optional.of(studentList));

        // Act
        List<Student> result = service.getAllStudents();

        // Assert
        // Check behavior without using assert
        Mockito.verify(repository, Mockito.times(1)).getAllBy();
        System.out.println("Students retrieved: " + result.size());
    }

    @Test
    void testAddStudent() {
        // Arrange
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("Bakalskaya");

        // Act
        service.addStudent(student);

        // Assert
        // Check behavior without using assert
        Mockito.verify(repository, Mockito.times(1)).save(student);
        System.out.println("Student added: " + student.getFirstName());
    }

    @Test
    void testDeleteStudentById() {
        // Arrange
        Long studentId = 1L;

        Mockito.when(repository.deleteStudentById(studentId)).thenReturn(Optional.of(1));

        // Act
        Integer result = service.deleteStudentById(studentId);

        // Assert
        // Check behavior without using assert
        Mockito.verify(repository, Mockito.times(1)).deleteStudentById(studentId);
        System.out.println("Student deleted with ID: " + studentId + ", Result: " + result);
    }

}
