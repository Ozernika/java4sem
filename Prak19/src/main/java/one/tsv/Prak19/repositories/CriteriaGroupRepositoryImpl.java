package one.tsv.Prak19.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import one.tsv.Prak19.models.Group;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class CriteriaGroupRepositoryImpl implements CriteriaGroupRepository {
    private EntityManager entityManager;

    @Override
    public List<Group> getGroupsByCriteria(String groupName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> cq = cb.createQuery(Group.class);

        Root<Group> group = cq.from(Group.class);
        List<Predicate> predicates = new ArrayList<>();

        if (groupName != null) {
            predicates.add(cb.equal(group.get("groupName"), groupName));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
