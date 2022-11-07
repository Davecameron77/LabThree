package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "Customer")
public class Customer extends Person {

    public Customer(String firstName, String lastName, String street, String city, String postalCode, String country) {
        super(firstName, lastName, street, city, postalCode, country);
    }

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false, unique = true, length = 11)
    private UUID id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private ArrayList<Task> tasks;
}
