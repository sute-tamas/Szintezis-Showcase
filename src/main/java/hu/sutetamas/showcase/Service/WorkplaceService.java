package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Examination;
import hu.sutetamas.showcase.Entity.Inspector;
import hu.sutetamas.showcase.Entity.Owner;
import hu.sutetamas.showcase.Entity.Workplace;
import hu.sutetamas.showcase.Repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WorkplaceService {

    @Autowired
    private WorkplaceRepository workplaceRepository;

    public Workplace getWorkplace(long id) {
        return workplaceRepository.findById(id).orElseThrow();
    }

    public List<Workplace> getAllWorkplaces() {
        Iterable<Workplace> workplacesIterator = workplaceRepository.findAll();
        List<Workplace> workplaces = StreamSupport
                .stream(workplacesIterator.spliterator(), false)
                .collect(Collectors.toList());
        return workplaces;
    }

    public void addWorkplace(Workplace workplace) {
        workplaceRepository.save(workplace);
    }

    public void putWorkplace(long id, Workplace workplace) {
        Workplace w = workplaceRepository.findById(id).orElseThrow();
        w.setName(workplace.getName());
        workplaceRepository.save(w);
    }

    // ---- FELADAT S -----

    public Workplace addWorkplace(long id, String name) {
        Workplace w = new Workplace();
        w.setId(id);
        w.setName(name);
        return w;
    }

}
