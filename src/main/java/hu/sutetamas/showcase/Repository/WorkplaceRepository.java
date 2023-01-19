package hu.sutetamas.showcase.Repository;

import hu.sutetamas.showcase.Entity.Workplace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplaceRepository extends CrudRepository<Workplace, Long> {
}
