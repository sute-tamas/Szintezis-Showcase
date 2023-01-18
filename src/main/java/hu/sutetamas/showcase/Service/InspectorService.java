package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InspectorService {

    private static List<Inspector> inspectors = new ArrayList<>();

    static {
        LocalDate date = LocalDate.of(2023, 1, 18);

        Workplace w = new Workplace();
        w.setId(1);
        w.setName("Győr");

        Inspector i = new Inspector();
        i.setId(1);
        i.setFirstName("Horváth");
        i.setLastName("István");
        i.setBirthDate(date);
        i.setWorkplace(w);

        inspectors.add(i);
    }

    public static void addInspector(Inspector inspector) {
        inspectors.add(inspector);
    }

    public static Inspector getInspector(long id) {
        Inspector i = new Inspector();
        for (Inspector temp : inspectors) {
            if (temp.getId() == id) {
                i = temp;
            }
        }
        return i;
    }

    public static void putInspector(long id, Inspector inspector) {
        for (Inspector temp : inspectors) {
            if (temp.getId() == id) {
                temp.setFirstName(inspector.getFirstName());
                temp.setLastName(inspector.getLastName());
                temp.setBirthDate(inspector.getBirthDate());
                temp.setWorkplace(inspector.getWorkplace());
                return;
            }
        }
    }

    public Inspector addInspector(long id, String firstName, String lastName, LocalDate birthDate){
        Inspector i = new Inspector();
        i.setId(id);
        i.setFirstName(firstName);
        i.setLastName(lastName);
        i.setBirthDate(birthDate);
        return i;
    }

}
