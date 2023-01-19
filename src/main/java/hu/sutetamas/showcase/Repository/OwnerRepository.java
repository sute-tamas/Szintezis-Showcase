package hu.sutetamas.showcase.Repository;

import hu.sutetamas.showcase.Entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
