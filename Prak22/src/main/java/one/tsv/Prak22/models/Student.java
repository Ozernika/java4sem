package one.tsv.Prak22.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import one.tsv.Prak22.dto.StudentDto;
import one.tsv.Prak22.dto.GroupDto;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="middleName")
    private String middleName;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
    public StudentDto toDto() {
        if (group == null) {
            return new StudentDto(id, firstName, lastName, middleName, null);
        }
        return new StudentDto(id, firstName, lastName, middleName, group.toDto());
    }
}
