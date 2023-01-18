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
        VehicleService.addVehicle(vehicle);
        return new ResponseEntity<String>("Vehicle added", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable long id) {
        return VehicleService.getVehicle(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable long id) {
        VehicleService.putVehicle(id, vehicle);
        return new ResponseEntity<String>("Vehicle put", HttpStatus.OK);
    }

}
