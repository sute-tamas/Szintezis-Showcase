package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Inspector;
import hu.sutetamas.showcase.Entity.Owner;
import hu.sutetamas.showcase.Entity.Workplace;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InspectorServiceTest {

    @Autowired
    private InspectorService inspectorService;
    @Autowired
    private WorkplaceService workplaceService;

    @Test
    public void checkIfInspectorIsCreated() {

        LocalDate date = LocalDate.of(2023, 1, 18);

        Inspector iExpected = new Inspector();
        iExpected.setId(1);
        iExpected.setFirstName("Kovács");
        iExpected.setLastName("János");
        iExpected.setBirthDate(date);

        Inspector iActual = inspectorService.addInspector(1, "Kovács", "János", date);

        assertEquals(iExpected, iActual);

    }

    @Test
    public void checkIfOwnerClassIsUpdated() {

        LocalDate date1 = LocalDate.of(2023, 1, 18);
        LocalDate date2 = LocalDate.of(2023, 1, 19);

        Inspector iOriginal = inspectorService.addInspector(1, "Kovács", "János", date1);

        Inspector iExpected = inspectorService.addInspector(2, "Horváth", "Béla", date2);

        iOriginal.update(2, "Horváth", "Béla", date2);

        assertEquals(iOriginal, iExpected);

    }

    @Test
    public void checkIfWorkplaceIsAdded() {

        LocalDate date = LocalDate.of(2023, 1, 18);

        Workplace w = workplaceService.addWorkplace(1, "Név");

        Inspector iExpected = new Inspector();
        iExpected.setId(1);
        iExpected.setFirstName("Kovács");
        iExpected.setLastName("János");
        iExpected.setBirthDate(date);
        iExpected.setWorkplace(w);

        Inspector iActual = new Inspector();
        iActual.setId(1);
        iActual.setFirstName("Kovács");
        iActual.setLastName("János");
        iActual.setBirthDate(date);
        iActual.setWorkplace(w);

        iActual.addWorkplace(w);

        assertEquals(iExpected, iActual);
    }

    @Test
    public void checkIfWorkplaceIsRemoved() {

        LocalDate date = LocalDate.of(2023, 1, 18);

        Workplace w = workplaceService.addWorkplace(1, "Név");

        Inspector iExpected = new Inspector();
        iExpected.setId(1);
        iExpected.setFirstName("Kovács");
        iExpected.setLastName("János");
        iExpected.setBirthDate(date);

        Inspector iActual = new Inspector();
        iActual.setId(1);
        iActual.setFirstName("Kovács");
        iActual.setLastName("János");
        iActual.setBirthDate(date);
        iActual.setWorkplace(w);

        iActual.removeWorkplace();

        assertEquals(iExpected, iActual);
    }

}