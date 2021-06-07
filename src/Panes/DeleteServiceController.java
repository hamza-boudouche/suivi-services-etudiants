package Panes;

import java.sql.SQLException;

import DAO.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import structure.ServiceEtud;

public class DeleteServiceController {
	
	@FXML
	private Button buttonSupprimer;
	
	@FXML
	private TextField txtIdentifiant, txtAnneeScolaire;
	
	@FXML
	public boolean supprimer(ActionEvent event) throws SQLException {
		int id;
		try {
			id=Integer.parseInt(txtIdentifiant.getText());
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
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
			alert.setContentText("annee scolaire invalide");
			alert.showAndWait();
			return false;
		}
		
		ServiceEtud e = DAOFactory.gServiceEtudDAO().get(id, anneeScolaire);
		if(e!=null) {
			if(DAOFactory.getEtudiantDAO().delete(id)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setContentText("Le service de l'etudiant " + id + " pour l'annee " + anneeScolaire + " a ete supprime");
				alert.showAndWait();
				return true;
			}
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Le service de l'etudiant " + id + " pour l'annee " + anneeScolaire + " n'existe pas");
				alert.showAndWait();
				return false;
			}
		}
		else{
			return false;
		}
	}
	
}
