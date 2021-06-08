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

/**
 * DeleteEtudiantController est la classe de controle associee a la fenetre deleteEtudiant.fxml
 * Ces dernieres permettent la suppression d'un etudiant de la base de donnees en utilisation la classe DAO correspondante 
 */
public class DeleteEtudiantController {
	
	@FXML
	private Button buttonSupprimer;
	
	@FXML
	private TextField txtIdentifiant;
	
	// methode associee au bouton de suppression
	@FXML
	public boolean supprimer(ActionEvent event) throws SQLException {
		int id;
		try {
			id=Integer.parseInt(txtIdentifiant.getText());
		} catch (NumberFormatException e) {
			// s'execute si l'utilisateur ne donne pas un nombre
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("id etudiant invalide");
			alert.showAndWait();
			return false;
		}
		// on utilise le pattern DAO etablit pour acceder a la base de donnees et chercher si l'etudiant existe deja
		Etudiant e = DAOFactory.getEtudiantDAO().get(id);
		if(e!=null) {
			// on utilise le pattern DAO etablit pour acceder a la base de donnees et supprimer cet etudiant
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
