package architectures.mvvm;

public class UserViewModel {
    private final UserView view;
    private final User model;

    public UserViewModel(User model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public void setUserData(String newUsername, String newPassword) {
        model.setUsername(newUsername);
        model.setPassword(newPassword);
        update();
    }

    public void update() {
        view.displayUserDetails(model.getUsername(), model.getPassword());
    }
}
