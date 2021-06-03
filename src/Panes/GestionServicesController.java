package Panes;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class GestionServicesController {
	@FXML Button btnAjoutService;
	@FXML Button btnRechercheService;
	@FXML Button btnMajService;
	@FXML Button btnDelService;
	@FXML Pane gestionServicesPane;
	
	@FXML void switchToAjoutService(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/ajoutService.fxml"));
		gestionServicesPane.getChildren().clear();
        gestionServicesPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToRechercheService(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/rechercheService.fxml"));
		gestionServicesPane.getChildren().clear();
        gestionServicesPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToMajService(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/majService.fxml"));
		gestionServicesPane.getChildren().clear();
        gestionServicesPane.getChildren().add(newLoadedPane);
    }

	@FXML void switchToDeleteService(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/Panes/deleteService.fxml"));
		gestionServicesPane.getChildren().clear();
        gestionServicesPane.getChildren().add(newLoadedPane);
    }
}
