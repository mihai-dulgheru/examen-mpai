package architectures.mvp;

public class UserViewImpl implements UserView {
    @Override
    public void displayUserDetails(String username, String password) {
        System.out.println("User Details:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
