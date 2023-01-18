package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Examination;
import hu.sutetamas.showcase.Entity.Inspector;
import hu.sutetamas.showcase.Entity.Vehicle;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ExaminationService {

    public Examination addExamination(long id, Timestamp startTime) {
        Examination e = new Examination();
        e.setStartTime(startTime);
        e.setId(id);
        return e;
    }

}
