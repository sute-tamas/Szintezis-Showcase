package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.*;
import hu.sutetamas.showcase.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle getVehicle(long id) {
        return vehicleRepository.findById(id).orElseThrow();
    }

    public List<Vehicle> getAllVehicles() {
        Iterable<Vehicle> vehiclesIterator = vehicleRepository.findAll();
        List<Vehicle> vehicles = StreamSupport
                .stream(vehiclesIterator.spliterator(), false)
                .collect(Collectors.toList());
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public void putVehicle(long id, Vehicle vehicle) {
        Vehicle v = vehicleRepository.findById(id).orElseThrow();
        v.setMake(vehicle.getMake());
        v.setModel(vehicle.getModel());
        v.setLicensePlate(vehicle.getLicensePlate());
        vehicleRepository.save(v);
    }

    // ---- FELADAT S -----

    public Vehicle addVehicle(long id, String make, String model, String licensePlate) {
        Vehicle v = new Vehicle();
        v.setId(id);
        v.setMake(make);
        v.setModel(model);
        v.setLicensePlate(licensePlate);
        return v;
    }

}
