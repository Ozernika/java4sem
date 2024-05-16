package one.tsv.Prak22.repositories;

import one.tsv.Prak22.models.Group;

import java.util.List;

public interface CriteriaGroupRepository {
    List<Group> getGroupsByCriteria(String groupName);
}
