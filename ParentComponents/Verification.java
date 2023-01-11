package ParentComponents;

public class Verification {

    public boolean validName(String userName) {
        return (userName.length() == 0);
    }

    public boolean validPassword(String userPassword) {
        boolean result = false;
        if (userPassword.length() < 7) {
            result = true;
        }
        return result;
    }
}
