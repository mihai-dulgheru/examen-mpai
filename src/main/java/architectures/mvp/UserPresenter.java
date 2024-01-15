package architectures.mvp;

public class UserPresenter {
    private final User model;
    private final UserView view;

    public UserPresenter(User model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public void setUserData(String username, String password) {
        model.setUsername(username);
        model.setPassword(password);
    }

    public void updateView() {
        view.displayUserDetails(model.getUsername(), model.getPassword());
    }
}
