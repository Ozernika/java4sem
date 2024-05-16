package one.tsv.Prak20.repositories;

import one.tsv.Prak20.models.Group;

import java.util.List;

public interface CriteriaGroupRepository {
    List<Group> getGroupsByCriteria(String groupName);
}
