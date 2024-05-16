package one.tsv.Prak15.services;

import lombok.RequiredArgsConstructor;
import one.tsv.Prak15.models.Group;
import one.tsv.Prak15.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private GroupRepository repository;

    public List<Group> getAllGroups() {
        return repository.getAllBy().orElseThrow();
    }

    public void addGroup(Group group) {
        repository.save(group);
    }

    public Integer deleteGroupById(Long id) {
        return repository.deleteGroupById(id).orElseThrow();
    }
}
