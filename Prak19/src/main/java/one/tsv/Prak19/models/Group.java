package one.tsv.Prak19.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import one.tsv.Prak19.dto.GroupDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="groupName")
    private String groupName;

    @OneToMany(mappedBy = "group")
    private List<Student> students = new ArrayList<>();

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                '}';
    }

    public GroupDto toDto() {
        return new GroupDto(id, groupName);
    }
}
