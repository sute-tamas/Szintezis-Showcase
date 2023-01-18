package hu.sutetamas.showcase.Entity;

import lombok.Data;

//@Entity
@Data
public class Vehicle {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String make;

    private String model;

    private String licensePlate;

    //@JsonManagedReference
    //@ManyToOne
    //@JoinColumn(name = "owner_id")
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

