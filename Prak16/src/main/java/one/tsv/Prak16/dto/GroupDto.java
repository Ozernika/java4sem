package one.tsv.Prak16.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    private Long id;
    private String groupName;

/*    public GroupDto(Long id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    } */
}
