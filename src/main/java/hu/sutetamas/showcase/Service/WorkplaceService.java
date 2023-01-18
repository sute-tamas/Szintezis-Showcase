package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Inspector;
import hu.sutetamas.showcase.Entity.Workplace;
import org.springframework.stereotype.Service;

@Service
public class WorkplaceService {

    public Workplace addWorkplace(long id, String name) {
        Workplace w = new Workplace();
        w.setId(id);
        w.setName(name);
        return w;
    }
}
