package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    private static List<Vehicle> vehicles = new ArrayList<>();

    static {
        LocalDate date = LocalDate.of(2023, 1, 18);

        Owner o = new Owner();
        o.setId(1);
        o.setFirstName("Kovács");
        o.setLastName("József");
        o.setBirthDate(date);

        Vehicle v = new Vehicle();
        v.setId(1);
        v.setMake("Audi");
        v.setModel("A3");
        v.setLicensePlate("ASD-123");
        v.setOwner(o);

        vehicles.add(v);
    }

    public static Vehicle getVehicle(long id) {
        Vehicle v = new Vehicle();
        for (Vehicle temp : vehicles) {
            if (temp.getId() == id) {
                v = temp;
            }
        }
        return v;
    }

    public static void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public static void putVehicle(long id, Vehicle vehicle) {
        for (Vehicle temp : vehicles) {
            if (temp.getId() == id) {
                temp.setMake(vehicle.getMake());
                temp.setModel(vehicle.getModel());
                temp.setLicensePlate(vehicle.getLicensePlate());
                temp.setOwner(vehicle.getOwner());
                return;
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
