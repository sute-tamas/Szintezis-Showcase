package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Inspector;
import hu.sutetamas.showcase.Entity.Workplace;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InspectorService {

    public Inspector addInspector(long id, String firstName, String lastName, LocalDate birthDate){
        Inspector i = new Inspector();
        i.setId(id);
        i.setFirstName(firstName);
        i.setLastName(lastName);
        i.setBirthDate(birthDate);
        return i;
    }

}
