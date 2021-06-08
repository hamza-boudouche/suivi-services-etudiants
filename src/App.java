import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    // methode principale appelee par l'API javaFX 
    @Override
    public void start(Stage primaryStage) throws IOException {
        // chargement et affichage de la fenetre principale sous forme de fichier fxml 
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Suivi Services Etudiants");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
