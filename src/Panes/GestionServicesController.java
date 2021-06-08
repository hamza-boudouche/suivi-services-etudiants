package Panes;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * GestionServiceController est la classe de controle associee a la fenetre gestionServices.fxml
 * Ces dernieres permettent l'utilisation de 4 boutons associes aux fonctionalites suivantes:
 * + ajout
 * + suppression
 * + affichage
 * + mise a jour
 */
public class GestionServicesController {
	@FXML Button btnAjoutService;
	@FXML Button btnRechercheService;
	@FXML Button btnMajService;
	@FXML Button btnDelService;
	@FXML Pane gestionServicesPane;
	
	@FXML void switchToAjoutService(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre d'ajout des services sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/ajoutService.fxml"));
		gestionServicesPane.getChildren().clear();
        gestionServicesPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToRechercheService(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre de recherche des services sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/rechercheService.fxml"));
		gestionServicesPane.getChildren().clear();
        gestionServicesPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToMajService(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre de maj des services sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/majService.fxml"));
		gestionServicesPane.getChildren().clear();
        gestionServicesPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToDeleteService(ActionEvent event) throws IOException {
		// chargement et affichage de la fenetre de suppression des services sous forme de fichier fxml 
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/deleteService.fxml"));
		gestionServicesPane.getChildren().clear();
        gestionServicesPane.getChildren().add(newLoadedPane);
    }
}
