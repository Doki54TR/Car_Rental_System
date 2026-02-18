package MyCarRentalSystem;

import java.io.IOException;
import java.net.URL;
import java.util.List; 
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerOfCars implements Initializable {

    // Defined buttons from FXML
    @FXML
    private Button rent1, rent2, rent3, backButton, iButton1, iButton2, iButton3;

    // --- INITIALIZATION ---

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // 1. Load Back Button Image
        try {
            String imagePath = "Images/BackArrow.png";
            Image logoImage = new Image(getClass().getResourceAsStream(imagePath));
            ImageView imageView = new ImageView(logoImage);
            imageView.setFitWidth(20); 
            imageView.setFitHeight(20);  
            imageView.setPreserveRatio(true); 
            backButton.setGraphic(imageView);
        } catch (Exception e) {
            System.err.println("Image not found: Images/BackArrow.png");
        }

        // 2. Check User Role (Admin or User)
        checkUserRole();

        // 3. Apply styles to buttons (User mode)
        styleUserButtons();
    }

    // --- HELPER METHOD: GET DATA FROM FACTORY ---
    
    /**
      This method retrieves the car list for the current brand from the Factory
      and returns the specific car based on the index (0, 1, or 2).
     */
    private CarModel getCarFromFactory(ActionEvent event, int index) {
        // Get the current stage title (Brand Name)
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        String brand = stage.getTitle();
        
        // Fetch the list of cars for this brand from the Factory
        List<CarModel> cars = CarDataFactory.getCarsByBrand(brand);
        
        // Safety check: if list is empty or index is out of bounds
        if (cars == null || cars.isEmpty() || index >= cars.size()) {
            return null;
        }
        
        // Return the specific car object
        return cars.get(index);
    }

    // --- RENT BUTTON ACTIONS ---

    @FXML
    public void rent(ActionEvent event) {
        // Get the 1st car (Index 0)
        CarModel car = getCarFromFactory(event, 0); 
        if (car != null) {
            startRentalProcess(car.getModelName(), car.getDailyPrice());
        }
    }

    @FXML
    public void rent2(ActionEvent event) {
        // Get the 2nd car (Index 1)
        CarModel car = getCarFromFactory(event, 1);
        if (car != null) {
            startRentalProcess(car.getModelName(), car.getDailyPrice());
        }
    }

    @FXML
    public void rent3(ActionEvent event) {
        // Get the 3rd car (Index 2)
        CarModel car = getCarFromFactory(event, 2);
        if (car != null) {
            startRentalProcess(car.getModelName(), car.getDailyPrice());
        }
    }

    // --- INFO BUTTON ACTIONS ---

    @FXML
    public void info(ActionEvent event) {
        CarModel car = getCarFromFactory(event, 0);
        if (car != null) {
            displayInfo(car.getModelName(), car.getImagePath(), car.getDetails());
        }
    }

    @FXML
    public void info2(ActionEvent event) {
        CarModel car = getCarFromFactory(event, 1);
        if (car != null) {
            displayInfo(car.getModelName(), car.getImagePath(), car.getDetails());
        }
    }

    @FXML
    public void info3(ActionEvent event) {
        CarModel car = getCarFromFactory(event, 2);
        if (car != null) {
            displayInfo(car.getModelName(), car.getImagePath(), car.getDetails());
        }
    }

    // --- LOGIC: RENTAL PROCESS ---

    private void startRentalProcess(String carModelName, int dailyPrice) {
        TextInputDialog dialog = new TextInputDialog("1"); 
        dialog.setTitle("Rental Duration");
        dialog.setHeaderText("You are about to rent the " + carModelName + ".");
        dialog.setContentText("How many days do you want to rent it for?");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(daysString -> {
            try {
                int days = Integer.parseInt(daysString);
                if (days <= 0) {
                    showError("Please enter a valid number of days!");
                    return;
                }

                int totalPrice = days * dailyPrice;

                Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                confirmation.setTitle("Order Confirmation");
                confirmation.setHeaderText("Calculating Total Price...");
                confirmation.setContentText(
                        "Car: " + carModelName + "\n" +
                        "Duration: " + days + " Days\n" +
                        "Daily: " + dailyPrice + " TL\n" +
                        "---------------------\n" +
                        "TOTAL: " + totalPrice + " TL\n\n" +
                        "Do you confirm?"
                );

                Optional<ButtonType> confirmResult = confirmation.showAndWait();
                if (confirmResult.isPresent() && confirmResult.get() == ButtonType.OK) {
                    showSuccess("Success!", "Your car has been rented. Have a safe journey!");
                    System.out.println("Rental Completed: " + carModelName + " - " + totalPrice + " TL");
                } else {
                    System.out.println("User cancelled the operation.");
                }

            } catch (NumberFormatException e) {
                showError("Please enter numbers only!");
            }
        });
    }

    // --- LOGIC: DISPLAY INFO ---

    private void displayInfo(String title, String imagePath, String details) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Car Information");
        alert.setHeaderText(title);
        alert.setContentText(details);

        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(200); 
            imageView.setFitWidth(300);
            imageView.setPreserveRatio(true);
            alert.setGraphic(imageView);
        } catch (Exception e) {
            System.out.println("Image not found: " + imagePath);
        }

        alert.getDialogPane().setPrefSize(600, 600); 
        alert.setResizable(true);
        alert.getDialogPane().setStyle("-fx-font-size: 14px;");
        alert.showAndWait();
    }

    // --- STYLING METHODS ---

    private void styleUserButtons() {
        // Rent buttons style (Greenish)
        String rentStyle = "-fx-background-color: #c2baa6; " + 
                           "-fx-text-fill: white; " +
                           "-fx-font-weight: bold; " +
                           "-fx-background-radius: 15; " +
                           "-fx-cursor: hand;";

        // Info buttons style (Blue)
        String infoStyle = "-fx-background-color: #3498db; " + 
                           "-fx-text-fill: white; " +
                           "-fx-font-weight: bold; " +
                           "-fx-background-radius: 15; " +
                           "-fx-cursor: hand;";

        rent1.setStyle(rentStyle);
        rent2.setStyle(rentStyle);
        rent3.setStyle(rentStyle);

        iButton1.setStyle(infoStyle);
        iButton2.setStyle(infoStyle);
        iButton3.setStyle(infoStyle);
    }

    // --- ADMIN LOGIC ---

    private void checkUserRole() {
        String currentUser = UserData.currentUsername;
        boolean isAdmin = "admin".equals(currentUser);

        if (isAdmin) {
            // In Admin mode, we identify cars by their position (1st, 2nd, 3rd)
            transformToAdminMode(rent1, iButton1, "1st Car"); 
            transformToAdminMode(rent2, iButton2, "2nd Car");
            transformToAdminMode(rent3, iButton3, "3rd Car");
        }
    }

    private void transformToAdminMode(Button rentBtn, Button infoBtn, String carIdentifier) {
        // Hide User buttons
        rentBtn.setVisible(false); rentBtn.setManaged(false);
        infoBtn.setVisible(false); infoBtn.setManaged(false);

        // Create Admin Update Button
        Button updateBtn = new Button("Update");
        updateBtn.setStyle("-fx-background-color: #e67e22; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 15; -fx-cursor: hand;");
        updateBtn.setPrefWidth(80); 

        // Set Action
        updateBtn.setOnAction(event -> {
            handleUpdateAction(carIdentifier);
        });

        // Add to layout
        Pane parentContainer = (Pane) rentBtn.getParent();
        parentContainer.getChildren().add(updateBtn);
    }

    private void handleUpdateAction(String carIdentifier) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Admin Update Panel");
        dialog.setHeaderText("Updating: " + carIdentifier);
        dialog.setContentText("Enter new daily price:");

        dialog.showAndWait().ifPresent(price -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText(carIdentifier + " price updated to: " + price + " TL");
            alert.showAndWait();
        });
    }

    // --- NAVIGATION & UTILS ---

    private void showSuccess(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void goBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("userInterface.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setTitle("Car Rental System");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error occurred while returning to the main menu!");
            e.printStackTrace();
        }
    }
}