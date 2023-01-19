package hu.sutetamas.showcase.Repository;

import hu.sutetamas.showcase.Entity.Inspector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectorRepository extends CrudRepository<Inspector, Long> {
}
