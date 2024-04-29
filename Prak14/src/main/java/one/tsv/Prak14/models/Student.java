package one.tsv.Prak14.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    private String firstName;
    private String lastName;
    private String middleName;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}
