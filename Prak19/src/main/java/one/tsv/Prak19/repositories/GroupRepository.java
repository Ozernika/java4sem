package one.tsv.Prak19.repositories;

import one.tsv.Prak19.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
    Optional<List<Group>> getAllBy();
    Optional<Integer> deleteGroupById(Long id);
}
