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
		int id=Integer.parseInt(txtIdentifiant.getText());
		int anneeScolaire=Integer.parseInt(txtAnneeScolaire.getText());
		
		ServiceEtud e = DAOFactory.gServiceEtudDAO().get(id, anneeScolaire);
		if(e!=null) {
			if(DAOFactory.gEtudiantDAO().delete(id)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setContentText("Le service de l'�tudiant " + id + " pour l'ann�e " + anneeScolaire + " a �t� supprim�");
				alert.showAndWait();
				return true;
			}
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Le service de l'�tudiant " + id + " pour l'ann�e " + anneeScolaire + " n'a pas �t� supprim�");
				alert.showAndWait();
				return false;
			}
		}
		else{
			return false;
		}
	}
	
}
