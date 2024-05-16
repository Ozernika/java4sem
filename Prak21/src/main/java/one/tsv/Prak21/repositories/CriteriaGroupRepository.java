package one.tsv.Prak21.repositories;

import one.tsv.Prak21.models.Group;

import java.util.List;

public interface CriteriaGroupRepository {
    List<Group> getGroupsByCriteria(String groupName);
}
