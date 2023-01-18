package hu.sutetamas.showcase.Entity;


import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Workplace {

    private long id;

    private String name;

    // private Set<Inspector> inspectors;

    //--------------------------------------

    // getter, setters

    public void update(long id, String name) {
        this.setId(id);
        this.setName(name);
    }
}
