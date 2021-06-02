import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Controller {
	@FXML Button b1;
	@FXML Button b2;
	@FXML Button b3;
	@FXML Button b4;
	@FXML Pane mainPane;

	@FXML void switchToPane1(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/gestionEtudiants.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToPane2(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/gestionServices.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToPane3(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/listeEtudiant.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToPane4(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/importData.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }

}
