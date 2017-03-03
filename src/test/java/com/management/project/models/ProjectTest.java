package java.com.management.project.models;

import com.management.project.models.Company;
import com.management.project.models.Customer;
import com.management.project.models.Project;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectTest {
    private Project project = new Project(1, "Android app", 3000, new Company(1, "Luxsoft"), new Customer(1, "Bayer"));

    @Test
    public void getId() throws Exception {
        assertTrue(project.getId() == 1);
    }

    @Test
    public void setId() throws Exception {
        project.setId(12);
        assertTrue(project.getId() == 12);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Android app", project.getName());
    }

    @Test
    public void setName() throws Exception {
        project.setName("Clear service");
        assertEquals("Clear service", project.getName());
        project.setName(null);
        assertEquals("", project.getName());
    }

    @Test
    public void getCost() throws Exception {
        assertTrue(project.getCost() == 3000);
    }

    @Test
    public void setCost() throws Exception {
        project.setCost(5000);
        assertTrue(project.getCost() == 5000);
    }

    @Test
    public void getCompany() throws Exception {
        assertEquals(new Company(1, "Luxsoft"), project.getCompany());
    }

    @Test
    public void setCompany() throws Exception {
        Company company = new Company(2, "Rozetka");
        project.setCompany(company);
        assertEquals(new Company(2, "Rozetka"), project.getCompany());
    }

    @Test
    public void getCustomer() throws Exception {
        assertEquals(new Customer(1, "Bayer"), project.getCustomer());
    }

    @Test
    public void setCustomer() throws Exception {
        Customer customer = new Customer(10, "Petrovi4");
        project.setCustomer(customer);
        assertEquals(new Customer(10, "Petrovi4"), project.getCustomer());
    }

    @Test
    public void equals() throws Exception {
        Project project2 = new Project(1, "Android app", 3000, new Company(1, "Luxsoft"), new Customer(1, "Bayer"));
        assertEquals(project2, project);
    }


}