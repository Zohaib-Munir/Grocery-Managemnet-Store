package ActorsAndActions;

import ParentComponents.Person;

public class Admin extends Person {
    private String adminName;
    private String adminPassword;

    public Admin(String firstName, String lastName, String cnic, String contactNumber, String adminName,
            String adminPassword) {
        super(firstName, lastName, cnic, contactNumber);
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String toString() {
        return "Admin [ AdminName : " + adminName +
                " , AdminPassword " + adminPassword + "]";
    }
}
