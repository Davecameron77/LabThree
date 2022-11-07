package Model;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {

    public Person(String firstName, String lastName, String street, String city, String postalCode, String country) {
        name = new FullName(firstName, lastName);
        homeAddress = new FullAddress(street, city, postalCode, country);
    }

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private FullName name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
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
