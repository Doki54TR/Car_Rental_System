package MyCarRentalSystem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainOfUserInterface extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root=FXMLLoader.load(getClass().getResource("userInterface.fxml"));


        Scene scene = new Scene(root);

        try{
          Image icon = new Image(getClass().getResourceAsStream("Images/app_icon.png"));
          primaryStage.getIcons().add(icon);
        }
        catch (Exception e) {
            System.err.println("Icon image not found: " + e.getMessage());
        }
        primaryStage.setTitle("Car Brands");
        // Change the background color of the window
        scene.getRoot().setStyle("-fx-background-color: #b6af9aff");
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
    public static void main(String[] args) { 
    launch(args);
  }
    
}
