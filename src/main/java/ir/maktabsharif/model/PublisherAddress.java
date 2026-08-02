package ir.maktabsharif.model;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class PublisherAddress {
    private String City;
    private String Street;
    private String PostalCode;

    public PublisherAddress(String city, String street, String postalCode) {
        City = city;
        Street = street;
        PostalCode = postalCode;
    }

    public PublisherAddress() {}

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PublisherAddress that = (PublisherAddress) o;
        return Objects.equals(City, that.City) && Objects.equals(Street, that.Street) && Objects.equals(PostalCode, that.PostalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(City, Street, PostalCode);
    }

    @Override
    public String toString() {
        return "PublisherAddress{" +
                "City='" + City + '\'' +
                ", Street='" + Street + '\'' +
                ", PostalCode='" + PostalCode + '\'' +
                '}';
    }
}
