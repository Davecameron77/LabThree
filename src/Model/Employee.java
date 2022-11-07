package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "Employee")
public class Employee extends  Person {

    public Employee() {
        super();
    }

    public Employee(String firstName, String lastName, String street, String city, String postalCode, String country) {
        super(firstName, lastName, street, city, postalCode, country);
    }

    @Column(name = "Id", nullable = false, unique = true, length = 11)
    private UUID id;

    @Column(name = "Job_Title")
    private String jobTitle;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private ArrayList<Task> tasks;

    //region getter/setter

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getFirstName() {
        return super.getFirstName();
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    public String getLastName() {
        return super.getLastName();
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    //endregion
}
