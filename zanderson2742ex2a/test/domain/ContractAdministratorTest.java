package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ContractAdministratorTest {
    ContractAdministrator contractAdmin = null;

    @BeforeEach
    void setUp() {
        this.contractAdmin = new ContractAdministrator(101, "Zenessa", "Anderson", "za1", LocalDateTime.of(2000,10,10,0,0,0), "111-11-1111",
                "507-111-1111", LocalDateTime.of(2010,10,10,0,0,0), 400.1);
    }

    @Test
    void testToString() {
        String result = "personId=101, firstName='Zenessa', lastName='AndersonAdministrator{birthDate=2000-10-10T00:00, ssn='111-11-1111', phone='507-111-1111', employmentStartDate=2010-10-10T00:00}ContractAdministrator{monthlyRate= 400.1Gross Pay= 400.10}";
        assertEquals(result, this.contractAdmin.toString());
    }

    @Test
    void calcGrossPay() {
        assertEquals(400.10, this.contractAdmin.calcGrossPay());
    }
}