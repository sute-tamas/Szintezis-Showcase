package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.*;
import hu.sutetamas.showcase.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public ResponseEntity<String> checkIfLicenseIsValid(long id) {
        Vehicle v = vehicleRepository.findById(id).orElseThrow();
        LocalDate buyDatePlus4Year = v.getRegistrationDate().plusYears(4);
        if (buyDatePlus4Year.isAfter(LocalDate.now())) {
            return new ResponseEntity<String>("License is valid until " + buyDatePlus4Year.toString(), HttpStatus.OK);
        } else {
            if (v.getExaminations().isEmpty()) {
                return new ResponseEntity<String>("License is not valid", HttpStatus.OK);
            } else {
                List<Examination> examinations = v.getExaminations();
                Examination lastExam = examinations.get(0);
                for (Examination examination : examinations) {
                    if (examination.getStartTime().after(lastExam.getStartTime())) {
                        lastExam = examination;
                    }
                }
                LocalDate lastExamDate = lastExam.getStartTime().toLocalDateTime().toLocalDate();
                if (LocalDate.now().isBefore(lastExamDate.plusYears(2))) {
                    return new ResponseEntity<String>("License is valid until " + lastExamDate.plusYears(2), HttpStatus.OK);
                } else {
                    return new ResponseEntity<String>("License is not valid", HttpStatus.OK);
                }
            }
        }
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
