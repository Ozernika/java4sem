package one.tsv.Prak22.repositories;

import one.tsv.Prak22.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long>{
    Optional<List<Group>> getAllBy();
    Optional<Integer> deleteGroupById(Long id);
}
