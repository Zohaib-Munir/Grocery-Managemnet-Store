package ActorsAndActions;

import ParentComponents.Person;
import ParentComponents.Address;

public class User extends Person {
    private String userName;
    private String userPassword;
    private Address userAddress;

    public User(String firstName, String lastName, String cnic, String contactNumber, String userName,
            String userPassword, Address address) {
        super(firstName, lastName, cnic, contactNumber);
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAddress = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public String toString() {
        return "User [ UserName " + userName + " , UserPassword" + userPassword + "]";
    }

}
