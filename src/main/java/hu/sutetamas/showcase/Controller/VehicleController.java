package hu.sutetamas.showcase.Controller;

import hu.sutetamas.showcase.Entity.Examination;
import hu.sutetamas.showcase.Entity.Vehicle;
import hu.sutetamas.showcase.Service.ExaminationService;
import hu.sutetamas.showcase.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping()
    public ResponseEntity<String> saveVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return new ResponseEntity<String>("Vehicle added", HttpStatus.OK);
    }

    @PostMapping("/{veId}/addowner/{owId}")
    public ResponseEntity<String> addOwner(@PathVariable long veId, @PathVariable long owId) {
        vehicleService.addOwner(veId, owId);
        return new ResponseEntity<String>("Owner added", HttpStatus.OK);
    }

    @GetMapping()
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable long id) {
        return vehicleService.getVehicle(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable long id) {
        vehicleService.putVehicle(id, vehicle);
        return new ResponseEntity<String>("Vehicle put", HttpStatus.OK);
    }

    @GetMapping("/valid/{id}")
    public ResponseEntity<String> checkIfLicenseIsValid(@PathVariable long id) {
        return vehicleService.checkIfLicenseIsValid(id);
    }

}
