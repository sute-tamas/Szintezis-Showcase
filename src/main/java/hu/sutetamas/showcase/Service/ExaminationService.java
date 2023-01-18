package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminationService {

    private static List<Examination> examinations = new ArrayList<>();

    static {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        LocalDate date = LocalDate.of(2023, 1, 18);

        Owner o = new Owner();
        o.setId(1);
        o.setFirstName("Kovács");
        o.setLastName("József");
        o.setBirthDate(date);

        Workplace w = new Workplace();
        w.setId(1);
        w.setName("Győr");

        Inspector i = new Inspector();
        i.setId(1);
        i.setFirstName("Horváth");
        i.setLastName("István");
        i.setBirthDate(date);
        i.setWorkplace(w);

        Vehicle v = new Vehicle();
        v.setId(1);
        v.setMake("Audi");
        v.setModel("A3");
        v.setLicensePlate("ASD-123");
        v.setOwner(o);

        Examination examination1 = new Examination();
        examination1.setId(1);
        examination1.setStartTime(time);
        examination1.setInspector(i);
        examination1.setVehicle(v);

        examinations.add(examination1);
    }

    public static Examination getExamination(long id) {
        Examination e = new Examination();
        for (Examination temp : examinations) {
            if (temp.getId() == id) {
                e = temp;
            }
        }
        return e;
    }

    public static void addExamination(Examination examination) {
        examinations.add(examination);
    }

    public static void putExamination(long id, Examination examination) {
        for (Examination temp : examinations) {
            if (temp.getId() == id) {
                temp.setStartTime(examination.getStartTime());
                temp.setInspector(examination.getInspector());
                temp.setVehicle(examination.getVehicle());
                return;
            }
        }
    }

    // ---- FELADAT-S ----

    public Examination addExamination(long id, Timestamp startTime) {
        Examination e = new Examination();
        e.setStartTime(startTime);
        e.setId(id);
        return e;
    }


}
