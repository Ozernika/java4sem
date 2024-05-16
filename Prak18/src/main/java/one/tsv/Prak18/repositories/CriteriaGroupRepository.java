package one.tsv.Prak18.repositories;

import one.tsv.Prak18.models.Group;

import java.util.List;

public interface CriteriaGroupRepository {
    List<Group> getGroupsByCriteria(String groupName);
}
