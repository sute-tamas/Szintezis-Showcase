package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Owner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OwnerService {

    public Owner addOwner(long id, String firstName, String lastName, LocalDate birthDate){
        Owner o = new Owner();
        o.setId(id);
        o.setFirstName(firstName);
        o.setLastName(lastName);
        o.setBirthDate(birthDate);
        return o;
    }
}
