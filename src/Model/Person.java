package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    public Person() {
        name = new FullName();
        homeAddress = new FullAddress();
    }

    public Person(String firstName, String lastName, String street, String city, String postalCode, String country) {
        name = new FullName(firstName, lastName);
        homeAddress = new FullAddress(street, city, postalCode, country);
    }

    @Id
    @Column(name = "person_id", nullable = false, unique = true, length = 11)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    private FullName name;

    @OneToOne(fetch = FetchType.LAZY)
    private FullAddress homeAddress;

    //region getter/setter

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public String getFirstName() { return this.name.getFirstName(); }

    public void setFirstName(String firstName) { this.name.setFirstName(firstName); }

    public String getLastName() { return this.name.getLastName(); }

    public void setLastName(String lastName) { this.name.setLastName(lastName); }

    public FullAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(FullAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    //endregion
}
