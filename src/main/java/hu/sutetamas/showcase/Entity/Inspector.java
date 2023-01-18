package hu.sutetamas.showcase.Entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Inspector {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private Workplace workplace;

    //----------------------------

    // getters, setters

    public void addWorkplace(Workplace workplace) {
        this.setWorkplace(workplace);
    }

    public void removeWorkplace() {
        this.setWorkplace(null);
    }

    public void update(long id, String firstName, String lastName, LocalDate birthDate) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBirthDate(birthDate);
    }
}