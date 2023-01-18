package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.Examination;
import hu.sutetamas.showcase.Entity.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;

    @Test
    public void checkIfOwnerIsCreated() {

        LocalDate date = LocalDate.of(2023, 1, 18);

        Owner oExpected = new Owner();
        oExpected.setId(1);
        oExpected.setFirstName("Kovács");
        oExpected.setLastName("János");
        oExpected.setBirthDate(date);

        Owner oActual = ownerService.addOwner(1, "Kovács", "János", date);

        assertEquals(oExpected, oActual);

    }

    @Test
    public void checkIfOwnerClassIsUpdated() {

        LocalDate date = LocalDate.of(2023, 1, 18);
        LocalDate date2 = LocalDate.of(2023, 1, 19);

        Owner oOriginal = ownerService.addOwner(1, "Kovács", "János", date);

        Owner oExpected = ownerService.addOwner(2, "Horváth", "Béla", date2);

        oOriginal.update(2, "Horváth", "Béla", date2);

        assertEquals(oOriginal, oExpected);

    }

}