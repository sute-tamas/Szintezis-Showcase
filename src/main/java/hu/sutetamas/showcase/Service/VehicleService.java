package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Owner;
import hu.sutetamas.showcase.Entity.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    public Vehicle addVehicle(long id, String make, String model, String licensePlate) {
        Vehicle v = new Vehicle();
        v.setId(id);
        v.setMake(make);
        v.setModel(model);
        v.setLicensePlate(licensePlate);
        return v;
    }

}
