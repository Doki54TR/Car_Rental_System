package MyCarRentalSystem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.util.Optional;

import javafx.event.ActionEvent;

public class ControllerOfLogin {

    @FXML
    private TextField tField1;

    @FXML
    private PasswordField pField1;

    @FXML
    private Label label2;

    @FXML   
    private Hyperlink hLink1;

    @FXML
    public void handleLogin(ActionEvent event) {
        String username = tField1.getText();
        String password = pField1.getText();

        // Validate the user using UserData class
        if (UserData.validateUser(username, password)) {
            
            // --- EKSİK OLAN VE EKLEMEN GEREKEN SATIR BURASI ---
            // Giriş başarılı olduğu an, kimin girdiğini hafızaya (UserData'ya) kaydediyoruz.
            UserData.currentUsername = username; 
            // --------------------------------------------------

            // If login is successful, check if the user is admin
            boolean isAdmin = username.equals("admin"); 
            loadMainScreen(event, isAdmin);

        } else {
            label2.setText("Invalid username or password!");
            label2.setStyle("-fx-text-fill: red;");
        }
    }

    // Register new user
    @FXML
    public void handleCreateAccount(ActionEvent event) {
        // Take username and password via dialog boxes

        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Create Account");
        dialog.setHeaderText("New Member Registration");
        dialog.setContentText("Enter a new username:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(newUsername -> {
            if (newUsername.trim().isEmpty()) return;

            // Ask for password
            TextInputDialog passDialog = new TextInputDialog();
            passDialog.setTitle("Create Account");
            passDialog.setHeaderText("Hello " + newUsername);
            passDialog.setContentText("Create a password:");
            
            Optional<String> passResult = passDialog.showAndWait();
            passResult.ifPresent(newPass -> {
                if (newPass.trim().isEmpty()) return;

                // We send the new user data to UserData class to add the user
                boolean isAdded = UserData.addUser(newUsername, newPass);

                if (isAdded) {
                    label2.setText("Account created! You can login now.");
                    label2.setStyle("-fx-text-fill: green;");
                } else {
                    label2.setText("Username already taken!");
                    label2.setStyle("-fx-text-fill: red;");
                }
            });
        });
    }

    // Change to main user interface screen
    private void loadMainScreen(ActionEvent event, boolean isAdmin) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("userInterface.fxml"));
            Parent root = loader.load();

            // We send the information about admin privileges to the main controller
            ControllerOfUserInterface mainController = loader.getController();
            mainController.setAdminPrivileges(isAdmin); 

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}