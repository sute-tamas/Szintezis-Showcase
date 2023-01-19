package hu.sutetamas.showcase.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    private String make;

    private String model;

    @Column(name = "license_plate")
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    // --------------------------------

    // getters, setters

    public void addOwner(Owner owner) {
        this.setOwner(owner);
    }

    public void update(long id, String make, String model, String licensePlate) {
        this.setId(id);
        this.setMake(make);
        this.setModel(model);
        this.setLicensePlate(licensePlate);
    }
}

