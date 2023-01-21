package hu.sutetamas.showcase.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hu.sutetamas.showcase.Service.ExaminationService;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "examinations")
@Data
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "start_time")
    private Timestamp startTime;

    @ManyToOne()
    @JoinColumn(name = "inspector_id")
    private Inspector inspector;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
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