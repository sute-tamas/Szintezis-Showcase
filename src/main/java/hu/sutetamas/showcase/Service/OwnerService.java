package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {

    private static List<Owner> owners = new ArrayList<>();

    static {
        LocalDate date = LocalDate.of(2023, 1, 18);

        Owner o = new Owner();
        o.setId(1);
        o.setFirstName("Kovács");
        o.setLastName("József");
        o.setBirthDate(date);

        owners.add(o);
    }

    public static Owner getOwner(long id) {
        Owner e = new Owner();
        for (Owner temp : owners) {
            if (temp.getId() == id) {
                e = temp;
            }
        }
        return e;
    }

    public static void addOwner(Owner owner) {
        owners.add(owner);
    }

    public static void putOwner(long id, Owner owner) {
        for (Owner temp : owners) {
            if (temp.getId() == id) {
                temp.setFirstName(owner.getFirstName());
                temp.setLastName(owner.getLastName());
                temp.setBirthDate(owner.getBirthDate());
                return;
            }
        }
    }

    // ---- FELADAT S -----

    public Owner addOwner(long id, String firstName, String lastName, LocalDate birthDate){
        Owner o = new Owner();
        o.setId(id);
        o.setFirstName(firstName);
        o.setLastName(lastName);
        o.setBirthDate(birthDate);
        return o;
    }
}
