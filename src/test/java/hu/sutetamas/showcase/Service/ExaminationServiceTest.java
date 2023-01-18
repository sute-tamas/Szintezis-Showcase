package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Examination;
import hu.sutetamas.showcase.Entity.Inspector;
import hu.sutetamas.showcase.Entity.Vehicle;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExaminationServiceTest {

    @Autowired
    private ExaminationService examinationService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private InspectorService inspectorService;

    @Test
    public void checkIfExaminationIsCreated() {

        Timestamp time = new Timestamp(System.currentTimeMillis());

        Examination eExpected = new Examination();
        eExpected.setId(1);
        eExpected.setStartTime(time);

        Examination eActual = examinationService.addExamination(1, time);

        assertEquals(eExpected, eActual);

    }

    @Test
    public void checkIfExaminationClassIsUpdated() {

        Timestamp time = new Timestamp(System.currentTimeMillis());
        Timestamp time2 = new Timestamp(System.currentTimeMillis());

        Examination eOriginal = new Examination();
        eOriginal.setId(1);
        eOriginal.setStartTime(time);

        Examination eExpected = new Examination();
        eExpected.setId(2);
        eExpected.setStartTime(time2);

        Examination eActual = new Examination();
        eActual.setId(1);
        eActual.setStartTime(time);

        eActual.update(2, time2);

        assertEquals(eExpected, eActual);

    }

    @Test
    public void checkIfInspectorIsAdded() {

        Timestamp time = new Timestamp(System.currentTimeMillis());
        LocalDate date = LocalDate.of(2023, 1, 18);

        Inspector i = inspectorService.addInspector(1, "Kovács", "Béla", date);

        Examination eExpected = new Examination();
        eExpected.setId(1);
        eExpected.setStartTime(time);
        eExpected.setInspector(i);

        Examination eActual = examinationService.addExamination(1, time);
        eActual.addInspector(i);

        assertEquals(eExpected, eActual);
    }

    @Test
    public void checkIfVehicleIsAdded() {

        Vehicle v = vehicleService.addVehicle(1, "Volkswagen", "Golf", "ABC-123");
    }
}