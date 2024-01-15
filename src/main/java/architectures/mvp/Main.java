package architectures.mvp;

public class Main {
    public static void main(String[] args) {
        // Creare model, view și presenter
        User model = new User("john_doe", "<secure_password>");
        UserView view = new UserViewImpl();
        UserPresenter presenter = new UserPresenter(model, view);

        // Afișare detalii utilizator
        presenter.updateView();

        // Modificare datelor utilizatorului și afișare din nou
        presenter.setUserData("new_user", "<new_password>");
        presenter.updateView();
    }
}
