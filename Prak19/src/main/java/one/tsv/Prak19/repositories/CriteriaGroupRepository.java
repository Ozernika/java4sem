package one.tsv.Prak19.repositories;

import one.tsv.Prak19.models.Group;

import java.util.List;

public interface CriteriaGroupRepository {
    List<Group> getGroupsByCriteria(String groupName);
}
