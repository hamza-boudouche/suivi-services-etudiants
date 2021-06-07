package Panes;

import DAO.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import structure.ServiceEtud;

public class MajServiceController {
	
	@FXML
	private Button buttonEnregistrer;
	
	@FXML
	private TextField txtIdentifiant, txtAnneeScolaire, txtBourse, txtCU, txtCMB, txtCMBO;
	
	@FXML
	public boolean enregistrer(ActionEvent event) {
		int id;
		try {
			id=Integer.parseInt(txtIdentifiant.getText());
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("id etudiant invalide");
			alert.showAndWait();
			return false;
		}
		int anneeScolaire;
		try {
			anneeScolaire=Integer.parseInt(txtAnneeScolaire.getText());
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("annee scolaire invalide");
			alert.showAndWait();
			return false;
		}
		Integer bourse;
		try {
			if(txtBourse.getText().equals("")){
				bourse = null;
			} else {
				bourse=Integer.parseInt(txtBourse.getText());
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("bourse invalide");
			alert.showAndWait();
			return false;
		}
		Integer cu;
		try {
			if(txtCU.getText().equals("")){
				cu = null;
			} else {
				cu = Integer.parseInt(txtCU.getText());
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("cite universitaire invalide");
			alert.showAndWait();
			return false;
		}
		Integer cmb;
		try {
			if(txtCMB.getText().equals("")){
				cmb = null;
			} else {
				cmb=Integer.parseInt(txtCMB.getText());
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("couverture medicale invalide");
			alert.showAndWait();
			return false;
		}
		Integer cmbo;
		try {
			if(txtCMBO.getText().equals("")){
				cmbo = null;
			} else {
				cmbo=Integer.parseInt(txtCMBO.getText());
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("organisme de couverture medicale invalide");
			alert.showAndWait();
			return false;
		}
		
		ServiceEtud existingService = DAOFactory.gServiceEtudDAO().get(id);
		if(existingService == null){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("Le service n'a pas ete ajoute!");
			alert.showAndWait();
			return false;
		}

		ServiceEtud newService = new ServiceEtud(id, anneeScolaire, bourse, cu, cmb, cmbo);

		if(DAOFactory.gServiceEtudDAO().update(newService)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Succes");
			alert.setHeaderText("Succes");
			alert.setContentText("Le service a ete ajoute!");
			alert.showAndWait();
    		return true;
    	}
		return true;
	}
}
