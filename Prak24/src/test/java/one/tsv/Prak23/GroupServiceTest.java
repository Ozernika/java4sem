package one.tsv.Prak23;


import one.tsv.Prak23.models.Group;
import one.tsv.Prak23.repositories.GroupRepository;
import one.tsv.Prak23.services.GroupService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;


import java.util.Collections;


@ExtendWith(MockitoExtension.class)
public class GroupServiceTest {

    @Mock
    private GroupRepository repository;

    @InjectMocks
    private GroupService service;

    @Test
    void testGetAllGroups() {
        Group group1 = new Group();
        group1.setId(1L);
        group1.setGroupName("Group 1");

        List<Group> groupList = Collections.singletonList(group1);

        Mockito.when(repository.getAllBy()).thenReturn(Optional.of(groupList));
        List<Group> result = service.getAllGroups();

        Mockito.verify(repository, Mockito.times(1)).getAllBy();
        System.out.println("Groups retrieved: " + result.size());
    }

    @Test
    void testAddGroup() {
        Group group = new Group();
        group.setId(1L);
        group.setGroupName("New Group");

        service.addGroup(group);

        Mockito.verify(repository, Mockito.times(1)).save(group);
        System.out.println("Group added: " + group.getGroupName());
    }

    @Test
    void testDeleteGroupById() {
        Long groupId = 1L;

        Mockito.when(repository.deleteGroupById(groupId)).thenReturn(Optional.of(1));
        Integer result = service.deleteGroupById(groupId);

        Mockito.verify(repository, Mockito.times(1)).deleteGroupById(groupId);
        System.out.println("Group deleted with ID: " + groupId + ", Result: " + result);
    }
}

