package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Owner;
import hu.sutetamas.showcase.Entity.Workplace;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorkplaceServiceTest {

    @Autowired
    private WorkplaceService workplaceService;

    @Test
    public void checkIfWorkplaceIsCreated() {

        Workplace wExpected = new Workplace();
        wExpected.setId(1);
        wExpected.setName("Név");

        Workplace wActual = workplaceService.addWorkplace(1, "Név");

        assertEquals(wExpected, wActual);

    }

    @Test
    public void checkIfWorkplaceClassIsUpdated() {

        Workplace wOriginal = workplaceService.addWorkplace(1, "Első");

        Workplace wExpected = workplaceService.addWorkplace(2, "Második");

        wOriginal.update(2, "Második");

        assertEquals(wOriginal, wExpected);

    }

}