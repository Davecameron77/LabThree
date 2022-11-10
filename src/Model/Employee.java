package Model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employee")
public class Employee extends  Person {

    public Employee() {
        super();
        uuid = UUID.randomUUID();
    }

    public Employee(String firstName, String lastName, String street, String city, String postalCode, String country) {
        super(firstName, lastName, street, city, postalCode, country);
        uuid = UUID.randomUUID();
    }

    @Column(name = "uuid", nullable = true, unique = true, length = 16)
    private UUID uuid;

    @Column(name = "job_title")
    private String jobTitle;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "employee_task",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") }
    )
    private List<Task> tasks;

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

    public List<Task> getTasks() { return this.tasks; }

    public void addTask(Task task) { this.tasks.add(task); }

    //endregion
}
