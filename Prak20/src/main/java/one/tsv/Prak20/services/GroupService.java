package one.tsv.Prak20.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import one.tsv.Prak20.models.Group;
import one.tsv.Prak20.repositories.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Slf4j
public class GroupService {
    private final GroupRepository repository;
    @Autowired
    public GroupService(GroupRepository repository) {
        this.repository = repository;
    }

    public List<Group> getAllGroups() {
        log.info("Get all groups");
        return repository.getAllBy().orElseThrow();
    }

    public void addGroup(Group group) {
        log.info("Add group: {}", group);
        repository.save(group);
    }

    public Integer deleteGroupById(Long id) {
        log.info("Delete group with ID: {}", id);
        return repository.deleteGroupById(id).orElseThrow();
    }
}

