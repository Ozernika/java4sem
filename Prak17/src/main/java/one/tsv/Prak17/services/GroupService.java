package one.tsv.Prak17.services;

import lombok.RequiredArgsConstructor;
import one.tsv.Prak17.models.Group;
import one.tsv.Prak17.repositories.GroupRepository;
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
