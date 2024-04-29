package one.tsv.Prak14.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Group {
    private String groupName;

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
