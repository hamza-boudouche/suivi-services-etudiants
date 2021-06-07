package Panes;

import java.sql.SQLException;

import DAO.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import structure.Etudiant;

public class DeleteEtudiantController {
	
	@FXML
	private Button buttonSupprimer;
	
	@FXML
	private TextField txtIdentifiant;
	
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
		Etudiant e = DAOFactory.getEtudiantDAO().get(id);
		if(e!=null) {
			if(DAOFactory.getEtudiantDAO().delete(id)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setContentText("L'etudiant " + id + " a ete supprime");
				alert.showAndWait();
				return true;
			}
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("L'etudiant " + id + " n'existe pas");
				alert.showAndWait();
				return false;
			}
		}
		else{
			return false;
		}
	}

}
