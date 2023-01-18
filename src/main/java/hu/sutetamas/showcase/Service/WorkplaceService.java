package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Inspector;
import hu.sutetamas.showcase.Entity.Owner;
import hu.sutetamas.showcase.Entity.Workplace;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkplaceService {

    private static List<Workplace> workplaces = new ArrayList<>();

    static {

        Workplace o = new Workplace();
        o.setId(1);
        o.setName("Győr");

        workplaces.add(o);
    }

    public static Workplace getWorkplace(long id) {
        Workplace e = new Workplace();
        for (Workplace temp : workplaces) {
            if (temp.getId() == id) {
                e = temp;
            }
        }
        return e;
    }

    public static void addWorkplace(Workplace workplace) {
        workplaces.add(workplace);
    }

    public static void putWorkplace(long id, Workplace workplace) {
        for (Workplace temp : workplaces) {
            if (temp.getId() == id) {
                temp.setName(workplace.getName());
                return;
            }
        }
    }

    // ---- FELADAT S -----

    public Workplace addWorkplace(long id, String name) {
        Workplace w = new Workplace();
        w.setId(id);
        w.setName(name);
        return w;
    }
}
