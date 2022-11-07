package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Customer")
public class Customer extends Person {

    public Customer() {
        super();
        tasks = new ArrayList<>();
    }

    public Customer(String firstName, String lastName, String street, String city, String postalCode, String country) {
        super(firstName, lastName, street, city, postalCode, country);
        tasks = new ArrayList<>();
    }

    @Column(name = "Uuid", nullable = false, unique = true, length = 11)
    private UUID id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private ArrayList<Task> tasks;
}
