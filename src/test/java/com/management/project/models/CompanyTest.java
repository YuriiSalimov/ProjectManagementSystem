package com.management.project.models;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    private Company some = new Company(4566, "Hair Fair");

    @Test
    public void getId() {
        assertTrue(some.getId() == 4566);
    }

    @Test
    public void setId() {
        some.setId(5555);
        assertTrue(some.getId() == 5555);
    }

    @Test
    public void getName() {
        assertTrue(some.getName() == "Hair Fair");
    }

    @Test
    public void setName() {
        some.setName("British Airlines");
        assertTrue(some.getName() == "British Airlines");
    }

    @Test
    public void setNullName() {
        some.setName(null);
        assertNotNull(some.getName());
    }

    @Test
    public void equals() {
        Company some2 = new Company(4566, "Hair Fair");
        assertEquals(some2, some);
    }

}
