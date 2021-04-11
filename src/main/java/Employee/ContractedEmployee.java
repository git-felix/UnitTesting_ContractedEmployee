package Employee;

//import jdk.vm.ci.meta.Local;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class ContractedEmployee {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private final LocalDate employmentStartDate;
    private LocalDate employmentEndDate;

    // Constructors
    ContractedEmployee(String firstName, String lastName, LocalDate DOB, LocalDate startDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = DOB;
        this.employmentStartDate = startDate;
        this.employmentEndDate = null;
    }

    // setters
    public void setFirstName(String firstName) throws IOException {     // if employee has changed his/her first name
        if(firstName != null && firstName != ""){
            this.firstName = firstName;
        }
        else {
            throw new IOException("employee's new first name cannot be empty");
        }
    }
    public void setLastName(String lastName) throws IOException {     // if employee has changed his/her last name
        if(lastName != null && lastName != ""){
            this.lastName = lastName;
        }
        else {
            throw new IOException("employee's new last name cannot be empty");
        }
    }
    public void fireEmployee() {
        if(isCurrentEmployee()) {
            this.employmentEndDate = LocalDate.now();
        }
    }
    // getters
    public String getDisplayName() {
        return this.firstName + " " + this.lastName;
    }
    public LocalDate getEmploymentEndDate() {
        return this.employmentEndDate;
    }

    /** utility functions **/
    // check if person is employable (age is appropriate for working)
    public boolean isEmployable() {
        Period period = Period.between(this.dateOfBirth, LocalDate.now());
        return period.getYears() >= 16 && period.getYears() <= 62;

        /*
        // check for person being employable, i.e. from 16 to 65 (not included) years old.
        if(currentDate.getYear() - employee.dateOfBirth.getYear() >= 16 && currentDate.getYear() - employee.dateOfBirth.getYear() <= 65) {
            // if exactly 16 years old
            if(currentDate.getYear() - employee.dateOfBirth.getYear() == 16) {
                if (employee.dateOfBirth.getMonthValue() - currentDate.getMonthValue() > 0) {
                    return true;        // DOB.month > currentDate.month, thus person is already 16+
                }
                else if (employee.dateOfBirth.getMonthValue() - currentDate.getMonthValue() == 0) {
                    if (employee.dateOfBirth.getDayOfMonth() - currentDate.getDayOfMonth() >= 0) {
                        return true;    // DOB.day > currentDate.day, thus person is already 16+
                    }
                    else { return false; }
                }
                else { return false; }
            }
            // if exactly 64 years old
            else if(currentDate.getYear() - employee.dateOfBirth.getYear() == 65) {
                if (currentDate.getMonthValue() - employee.dateOfBirth.getMonthValue() > 0) {
                    return true;        // DOB.month < currentDate.month, thus person is not 65 yet
                }
                else if (currentDate.getMonthValue() - employee.dateOfBirth.getMonthValue() == 0) {
                    if (currentDate.getDayOfMonth() - employee.dateOfBirth.getDayOfMonth() > 0) {
                        return true;    // DOB.day < currentDate.day, thus person is not 65 yet (but will be in current month)
                    }
                    else { return false; }
                }
                else { return false; }
            }
            else { return true; }
        }
        else { return false; }  // otherwise, if person is less than 16 years old or older than or equal to 65, that person is unemployable

         */
    }

    // check if given person is current employee or not
    public boolean isCurrentEmployee() {
        if(this.employmentEndDate == null) { return true; }
        return false;
    }

    // check what level employee has
    public short experienceLevel() {
        // calculate number of fully worked years in the company
        short yearsWorked = (short)( ((12 * LocalDate.now().getYear() + LocalDate.now().getMonthValue())
                - (12 * this.employmentStartDate.getYear() + this.employmentStartDate.getMonthValue())) / 12);

        if(yearsWorked < 2) { return 1; }
        else if(yearsWorked < 4) { return 2; }
        else if (yearsWorked <= 6) { return 3; }
        else { return 4; }
    }


}
