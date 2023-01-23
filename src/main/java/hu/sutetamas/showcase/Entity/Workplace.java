package hu.sutetamas.showcase.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "workplaces")
@Data
public class Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "workplace", orphanRemoval = true)
    private List<Inspector> inspectors;

    //--------------------------------------

    // getter, setters

    public void update(long id, String name) {
        this.setId(id);
        this.setName(name);
    }
}
