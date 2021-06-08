
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Controller est la classe de controle associee a l'interface principale "ui.fxml"
 * Elle s'occupe des fonctionnalites des boutons de navigation (a gauche de la fenetre principale)
 * Chacun de ces boutons affiche une fenetre qui est associee a une des 4 fonctionnalitees de l'application
 * + Gestion des etudiants
 * + Gestion des services
 * + Affichage des etudiants et de leurs services
 * + Chargement des données dans une table de la base de donnees a partir d'un fichier csv (feuille excel)
 */
public class Controller {
	@FXML Button btnGestionEtudiants;
	@FXML Button btnGestionServices;
	@FXML Button btnListEtudants;
	@FXML Button btnImportData;
	@FXML Pane mainPane;

	@FXML void switchToPane1(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre de gestion des etudiants sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/gestionEtudiants.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToPane2(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre de gestion des services sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/gestionServices.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToPane3(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre d'affichage des etudiants et de leurs services sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/listeEtudiant.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToPane4(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre de chargement des donnees d'un fichier csv sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/importData.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }

}
