package ParentComponents;

import java.io.Serializable;

public class Address implements Serializable {
    private String province;
    private String city;
    private String street;
    private String house;

    public Address(String province, String city, String street, String house) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String toString() {
        return "Address [ Province " + province +
                ", City" + city +
                ", Street " + street +
                ", House " + house +
                "]";
    }
}
