package hu.sutetamas.showcase.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "inspectors")
@Data
public class Inspector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "workplace_id")
    private Workplace workplace;

    @JsonIgnore
    @OneToMany(mappedBy = "inspector", orphanRemoval = true)
    private List<Examination> examinations;

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