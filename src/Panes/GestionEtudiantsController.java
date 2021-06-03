package Panes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class GestionEtudiantsController {
	@FXML Button btnAjoutEtudiant;
	@FXML Button btnRechercheEtudiant;
	@FXML Button btnMajEtudiant;
	@FXML Button btnDelEtudiant;
	@FXML Pane gestionEtudiantsPane;
	
	@FXML void switchToAjoutEtudiant(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/ajoutEtudiant.fxml"));
		gestionEtudiantsPane.getChildren().clear();
        gestionEtudiantsPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToRechercheEtudiant(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/rechercheEtudiant.fxml"));
		gestionEtudiantsPane.getChildren().clear();
        gestionEtudiantsPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToMajEtudiant(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/majEtudiant.fxml"));
		gestionEtudiantsPane.getChildren().clear();
        gestionEtudiantsPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToDeleteEtudiant(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/deleteEtudiant.fxml"));
		gestionEtudiantsPane.getChildren().clear();
        gestionEtudiantsPane.getChildren().add(newLoadedPane);
    }
}
