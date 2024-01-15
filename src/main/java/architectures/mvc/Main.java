package architectures.mvc;

public class Main {
    public static void main(String[] args) {
        // Creare model, view și controller
        User model = new User("john_doe", "<secure_password>");
        UserView view = new UserView();
        UserController controller = new UserController(model, view);

        // Afișare detalii utilizator
        controller.updateView();

        // Modificare datelor utilizatorului și afișare din nou
        controller.setUserData("new_user", "<new_password>");
        controller.updateView();
    }
}
