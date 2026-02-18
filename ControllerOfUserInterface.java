package MyCarRentalSystem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
//import javafx.geometry.Insets;

public class ControllerOfUserInterface implements Initializable {

    @FXML
    private TilePane brandPane;

    private ArrayList<String> brandList;

    // Add button for admin users
    private Button addBtn; 

    // Admin user flag
    private boolean isAdminUser = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create the brand list
        brandList = new ArrayList<>();
        brandList.add("Toyota");
        brandList.add("Honda");
        brandList.add("BMW");
        brandList.add("Mercedes");
        brandList.add("Ford");
        brandList.add("Fiat");

        brandPane.setPrefTileWidth(200);  
        brandPane.setPrefTileHeight(150);

        brandPane.getChildren().clear();

        // Call the method to draw the interface
        refreshBrandMenu();
        brandPane.setHgap(20);
        brandPane.setVgap(20);
        brandPane.setPadding(new Insets(20));
    }

    // We separated this method because we will call it again when a new brand is added
    private void refreshBrandMenu() {
        // First, clear the old buttons on the screen
        brandPane.getChildren().clear();

        // Iterate over the list and create buttons
        for (String brand : brandList) {
            Button btn = new Button();
            btn.setPrefSize(200, 100);
            btn.getStyleClass().add("brand-card");

            try {
                // Create the image for the brand button
                String imagePath = "Images/" + brand + ".png";
                // Load the image
                Image logoImage = new Image(getClass().getResourceAsStream(imagePath));
                // Create the ImageView
                ImageView imageView = new ImageView(logoImage);
                // Set the image dimensions
                imageView.setFitWidth(150); 
                imageView.setFitHeight(100);  
                imageView.setPreserveRatio(true); 
                btn.setGraphic(imageView);

            } catch (Exception e) {
                System.err.println("Image not found: " + brand + " (" + e.getMessage() + ")");
            }

            btn.setOnAction(event -> {
                System.out.println(brand + " brand button clicked.");
                try {
                    String fxmlFileName = brand.toLowerCase() + ".fxml"; 
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
                    Parent root = loader.load();
                    Stage stage = (Stage) btn.getScene().getWindow();
                    stage.setTitle(brand);
                    try {
                        // We make the icon based on the brand
                        Image icon = new Image(getClass().getResourceAsStream("Images/" + brand + ".png"));
                        
                        // It might be healthier to clear old icons before adding a new one
                        stage.getIcons().clear(); 
                        stage.getIcons().add(icon);
                    } catch (Exception e) {
                        System.out.println("The icon couldnt be set. " + e.getMessage());
                    }

                    // Change background color based on brand
                    if(brand.equals("Toyota")) {
                         root.setStyle("-fx-background-color: #b6af9aff;");
                    } else if(brand.equals("Honda")) {
                         root.setStyle("-fx-background-color: #d1e7ddff;");
                    } else if(brand.equals("BMW")) {
                         root.setStyle("-fx-background-color: #cfe2ff;");
                    } else if(brand.equals("Mercedes")) {
                         root.setStyle("-fx-background-color: #e2e3e5ff;");
                    } else if(brand.equals("Ford")) {
                         root.setStyle("-fx-background-color: #cff4fcff;");
                    } else if(brand.equals("Fiat")) {
                         root.setStyle("-fx-background-color: #f8d7daff;");
                    } else {
                         root.setStyle("-fx-background-color: #ffffff;");
                    }
                    stage.setScene(new Scene(root));
                    stage.show();
            } 
                catch (IOException e) {
                    System.err.println("Error: " + brand + " page could not be opened!");
                    e.printStackTrace();
    }
                   
                
            });

            brandPane.getChildren().add(btn);
        }

        addBtn = new Button("Add new brand"); 
        addBtn.setPrefSize(200, 100);
        addBtn.setStyle("-fx-background-color: #594e4eff; -fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        addBtn.setVisible(isAdminUser);
        addBtn.setManaged(isAdminUser);

        addBtn.getStyleClass().add("add-button");

        addBtn.setOnAction(event -> {
            // Create a dialog to get the new brand name
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Add Brand");
            dialog.setHeaderText("Add New Car Brand");
            dialog.setContentText("Brand Name:");
            // Show the dialog and wait for the response
            
            Optional<String> result = dialog.showAndWait();

            // If the user entered something and clicked OK
            result.ifPresent(name -> {
                if (!name.trim().isEmpty()) {
                    addNewBrand(name);
                }
            });
        });

        // Add the add button to the pane
        brandPane.getChildren().add(addBtn);
    }
    

    // Method to add a new brand to the system
    // You can connect this to a TextField and an Add button for example
    public void addNewBrand(String newBrandName) {
        if (!brandList.contains(newBrandName)) { // Add if the same brand does not exist
            brandList.add(newBrandName);
            refreshBrandMenu(); // Update the list and redraw the screen!
            System.out.println(newBrandName + " added.");
        }
    }
    public void setAdminPrivileges(boolean isAdmin) {
    this.isAdminUser = isAdmin; // Save the status
    
    // We check if the addBtn is initialized
    if (addBtn != null) {
        addBtn.setVisible(isAdmin);
        addBtn.setManaged(isAdmin);
    }
}
}

