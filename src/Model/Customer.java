package Model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class Customer extends Person {

    public Customer() {
        super();
        uuid = UUID.randomUUID();
    }

    public Customer(String firstName, String lastName, String street, String city, String postalCode, String country) {
        super(firstName, lastName, street, city, postalCode, country);
        uuid = UUID.randomUUID();
    }

//    @Id
//    @GeneratedValue
//    @Column(name = "customer_id", nullable = false, unique = true, length = 11)
//    private int id;

    @Column(name = "uuid", nullable = false, unique = true, length = 11)
    private UUID uuid;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "customer_task",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") }
    )
    private List<Task> tasks;
}
