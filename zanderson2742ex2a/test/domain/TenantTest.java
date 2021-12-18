package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TenantTest {
    Tenant tenant = null;

    @BeforeEach
    void setup(){
        this.tenant = new Tenant(101, "Zenessa", "Anderson", "za1", LocalDateTime.of(2002,9,25,0,0,0), "111-11-1111",
                "507-111-1111", "Buisness", "Buisnessman", 10000.0, LocalDateTime.of(2010, 10,15,0,0,0)) ;
    }
    @Test
    void testToString() {
        String result = "personId=101, firstName='Zenessa', lastName='AndersonTenant{birthdate=2002-09-25T00:00, ssn='111-11-1111', phone='507-111-1111', employer='Buisness', occupation='Buisnessman', grossPay=10000.0, employmentStartDate=2010-10-15T00:00}"; //add in result
        assertEquals(result, tenant.toString());
    }
}