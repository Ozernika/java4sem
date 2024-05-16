package one.tsv.Prak21.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import one.tsv.Prak21.models.Group;
import one.tsv.Prak21.repositories.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupService {
    private final GroupRepository repository;

    @Transactional
    public List<Group> getAllGroups() {
        log.info("Get all groups");
        return repository.getAllBy().orElseThrow();
    }
    @Transactional
    public void addGroup(Group group) {
        log.info("Add group: {}", group);
        repository.save(group);
    }
    @Transactional
    public Integer deleteGroupById(Long id) {
        log.info("Delete group with ID: {}", id);
        return repository.deleteGroupById(id).orElseThrow();
    }
}

