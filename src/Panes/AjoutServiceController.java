package Panes;

import DAO.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import structure.ServiceEtud;

public class AjoutServiceController {
	
	@FXML
	private Button buttonEnregistrer;
	
	@FXML
	private TextField txtIdentifiant, txtAnneeScolaire, txtBourse, txtCU, txtCMB, txtCMBO;
	
	@FXML
	public boolean enregistrer(ActionEvent event) {
		int id=Integer.parseInt(txtIdentifiant.getText());
		int anneeScolaire=Integer.parseInt(txtAnneeScolaire.getText());
		int bourse=Integer.parseInt(txtBourse.getText());
		int cu=Integer.parseInt(txtCU.getText());
		int cmb=Integer.parseInt(txtCMB.getText());
		int cmbo=Integer.parseInt(txtCMBO.getText());
		
		ServiceEtud  s = new ServiceEtud(id, anneeScolaire, bourse, cu, cmb, cmbo);
		
		if(DAOFactory.gServiceEtudDAO().insert(s)) {
    		return true;
    	}
    	else {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("Le service n'a pas été ajouté!");
			alert.showAndWait();
			return false;
    	}		
	}
}
