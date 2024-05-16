package one.tsv.Prak23.repositories;

import one.tsv.Prak23.models.Group;

import java.util.List;

public interface CriteriaGroupRepository {
    List<Group> getGroupsByCriteria(String groupName);
}
