package Panes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * GestionEtudiantsController est la classe de controle associee a la fenetre gestionEtudiant.fxml
 * Ces dernieres permettent l'utilisation de 4 boutons associes aux fonctionalites suivantes:
 * + ajout
 * + suppression
 * + affichage
 * + mise a jour
 */
public class GestionEtudiantsController {
	@FXML Button btnAjoutEtudiant;
	@FXML Button btnRechercheEtudiant;
	@FXML Button btnMajEtudiant;
	@FXML Button btnDelEtudiant;
	@FXML Pane gestionEtudiantsPane;
	
	@FXML void switchToAjoutEtudiant(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre d'ajout des etudiants sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/ajoutEtudiant.fxml"));
		gestionEtudiantsPane.getChildren().clear();
        gestionEtudiantsPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToRechercheEtudiant(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre de recherche d'etudiant sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/rechercheEtudiant.fxml"));
		gestionEtudiantsPane.getChildren().clear();
        gestionEtudiantsPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToMajEtudiant(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre de mise a jour d'etudiant sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/majEtudiant.fxml"));
		gestionEtudiantsPane.getChildren().clear();
        gestionEtudiantsPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToDeleteEtudiant(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre de suppression d'etudiant sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/deleteEtudiant.fxml"));
		gestionEtudiantsPane.getChildren().clear();
        gestionEtudiantsPane.getChildren().add(newLoadedPane);
    }
}
