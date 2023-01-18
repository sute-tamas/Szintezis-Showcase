package hu.sutetamas.showcase.Entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Examination {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Timestamp startTime;

    private Inspector inspector;

    private Vehicle vehicle;

    //---------------------------------

    // getters, setters

    public void addInspector(Inspector inspector) {
        this.setInspector(inspector);
    }

    public void addVehicle(Vehicle vehicle) {
        this.setVehicle(vehicle);
    }

    public void update(long id, Timestamp startTime) {
        this.setId(id);
        this.setStartTime(startTime);
    }
}