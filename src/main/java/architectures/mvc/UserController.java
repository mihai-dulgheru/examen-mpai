package architectures.mvc;

public class UserController {
    private final User model;
    private final UserView view;

    public UserController(User model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public void setUserData(String username, String password) {
        model.setUsername(username);
        model.setPassword(password);
    }

    public void updateView() {
        view.printUserDetails(model.getUsername(), model.getPassword());
    }
}
