package hu.sutetamas.showcase.Entity;

import lombok.Data;

import java.time.LocalDate;


//@Entity
@Data
public class Owner {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    //@JsonBackReference
    //@OneToMany(mappedBy = "owner", orphanRemoval = true)
    //private List<Vehicle> vehicles;

    // ----------------------------------------

    // getters, setters

    public void update(long id, String firstName, String lastName, LocalDate birthDate) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBirthDate(birthDate);
    }
}
