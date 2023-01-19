package hu.sutetamas.showcase.Repository;

import hu.sutetamas.showcase.Entity.Examination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExaminationRepository extends CrudRepository<Examination, Long> {
    Optional<Examination> findById(long id);
}
