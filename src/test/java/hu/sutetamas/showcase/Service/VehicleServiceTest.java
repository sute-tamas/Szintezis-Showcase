package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Inspector;
import hu.sutetamas.showcase.Entity.Owner;
import hu.sutetamas.showcase.Entity.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleServiceTest {

    @Autowired
    private OwnerService ownerService;
    @Autowired
    private VehicleService vehicleService;

    @Test
    public void checkIfVehicleIsCreated() {

        Vehicle vExpected = new Vehicle();
        vExpected.setId(1);
        vExpected.setMake("Toyota");
        vExpected.setModel("Yaris");
        vExpected.setLicensePlate("ASD-123");

        Vehicle vActual = vehicleService.addVehicle(1, "Toyota", "Yaris", "ASD-123");

        assertEquals(vExpected, vActual);

    }

    @Test
    public void checkIfVehicleClassIsUpdated() {

        Vehicle vOriginal = vehicleService.addVehicle(1, "Toyota", "Yaris", "ASD-123");
        Vehicle vExpected = vehicleService.addVehicle(2, "Citroen", "C3", "DSA-321");

        vOriginal.update(2, "Citroen", "C3", "DSA-321");
        assertEquals(vOriginal, vExpected);

    }

    @Test
    public void checkIfOwnerIsAdded () {

        LocalDate date = LocalDate.of(2023, 1, 18);

        Owner o = new Owner();
        o.setId(1);
        o.setFirstName("Kovács");
        o.setLastName("János");
        o.setBirthDate(date);

        Vehicle vExpected = new Vehicle();
        vExpected.setId(1);
        vExpected.setMake("Toyota");
        vExpected.setModel("Yaris");
        vExpected.setLicensePlate("ASD-123");
        vExpected.setOwner(o);

        Vehicle vActual = vehicleService.addVehicle(1, "Toyota", "Yaris", "ASD-123");
        vActual.addOwner(o);

        assertEquals(vActual, vExpected);
    }
}