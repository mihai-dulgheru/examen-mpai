package architectures.mvvm;

public class Main {
    public static void main(String[] args) {
        // Creare model, view și viewModel
        User model = new User("john_doe", "<secure_password>");
        UserView view = new ConsoleUserView();
        UserViewModel viewModel = new UserViewModel(model, view);

        // Afișare inițială
        viewModel.update();

        // Modificare datelor utilizatorului și afișare din nou
        viewModel.setUserData("new_user", "<new_password>");
    }
}
