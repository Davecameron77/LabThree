package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "full_address")
public class FullAddress {

    public FullAddress() {
        this.street = "";
        this.city = "";
        this.postalCode = "";
        this.country = "";
    }

    public FullAddress(String street, String city, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "country")
    private String country;

    //region getter/setter

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //endregion
}
