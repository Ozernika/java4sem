package one.tsv.Prak17.repositories;

import one.tsv.Prak17.models.Group;

import java.util.List;

public interface CriteriaGroupRepository {
    List<Group> getGroupsByCriteria(String groupName);
}
