package ParentComponents;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String cnic;
    private String contactNumber;

    public Person(String firstName, String lastName, String cnic, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnic = cnic;
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String toString(){
        return "Person [ firstName "+firstName+
        " LastName "+lastName+
        " CNIC"+cnic+
        " Contact "+contactNumber+
        "]";
    }

}
