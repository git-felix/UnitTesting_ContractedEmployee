package Employee;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.Assert.*;


public class ContractedEmployeeTest {

    private static final ArrayList<ContractedEmployee> employees = new ArrayList<ContractedEmployee>();

    @Before
    public void initializeALl(){
        ContractedEmployee employee1 = new ContractedEmployee("John", "Brown",
                LocalDate.of(2000, 1, 30), LocalDate.of(2021, 1, 3));
        ContractedEmployee employee2 = new ContractedEmployee("John", "Yellow",
                LocalDate.of(2010, 1, 1), LocalDate.of(2018, 2, 12));
        ContractedEmployee employee3 = new ContractedEmployee("John", "Green",
                LocalDate.of(1955, 2, 1), LocalDate.of(2016, 4, 3));
        ContractedEmployee employee4 = new ContractedEmployee("John", "Blue",
                LocalDate.of(1995, 6, 10), LocalDate.of(2010, 11, 25));

        employees.add(0, employee1);
        employees.add(1, employee2);
        employees.add(2, employee3);
        employees.add(3, employee4);
    }

    @Test
    @DisplayName("Is Employable Method Test")
    public void testIsEmployable() {
        assertTrue(employees.get(0).isEmployable());
        assertFalse(employees.get(1).isEmployable());
        assertFalse(employees.get(2).isEmployable());
    }

    @Test
    @DisplayName("Get Display Name Method Test")
    public void testGetDisplayName() {
        String displayName = employees.get(0).getDisplayName();
        assertEquals("John Brown", displayName);
    }

    @Test
    public void testExperienceLevel() {
        /*
        employees[0] for level 1
        employees[1] for level 2
        employees[2] for level 3
        employees[3] for level 4
         */
        for(int i = 0; i < 4; ++i) {
            short level = employees.get(i).experienceLevel();
            assertEquals(i + 1, level);
        }
    }

    @Test
    public void testSetFirstName() {
        // try change employee first name and check changes
        try{
            employees.get(0).setFirstName("Jostar");
            assertEquals("Jostar Brown", employees.get(0).getDisplayName());
        } catch (IOException e) {
            assertEquals("employee's new first name cannot be empty", e.getMessage());
        }
        // try insert first name as 'null'
        try{
            employees.get(0).setFirstName(null);
        } catch (IOException e) {
            assertEquals("employee's new first name cannot be empty", e.getMessage());
        }
        // try insert first name as empty string ""
        try{
            employees.get(0).setFirstName("");
        } catch (IOException e) {
            assertEquals("employee's new first name cannot be empty", e.getMessage());
        }
    }

    @Test
    public void testSetLastName() {
        // try change employee last name and check changes
        try{
            employees.get(1).setLastName("Purple");
            assertEquals("John Purple", employees.get(1).getDisplayName());
        } catch (IOException e) {
            assertEquals("employee's new last name cannot be empty", e.getMessage());
        }
        // try insert first name as 'null'
        try{
            employees.get(1).setLastName(null);
        } catch (IOException e) {
            assertEquals("employee's new last name cannot be empty", e.getMessage());
        }
        // try insert first name as empty string ""
        try{
            employees.get(1).setLastName("");
        } catch (IOException e) {
            assertEquals("employee's new last name cannot be empty", e.getMessage());
        }
    }

    @Test
    public void testFireEmployee() {
        // make sure employee didn't finish working in the company
        assertTrue(employees.get(2).getEmploymentEndDate() == null);
        // fire the employee and make sure he/she finished working in the company
        employees.get(2).fireEmployee();
        assertEquals(LocalDate.now(), employees.get(2).getEmploymentEndDate());
        // make sure firing fired employee does not generate any changes
        employees.get(2).fireEmployee();
        assertEquals(LocalDate.now(), employees.get(2).getEmploymentEndDate());


    }

    @Test
    public void testIsCurrentEmployee() {
        assertTrue(employees.get(0).isCurrentEmployee());
        employees.get(2).fireEmployee();
        assertFalse(employees.get(2).isCurrentEmployee());
    }


}