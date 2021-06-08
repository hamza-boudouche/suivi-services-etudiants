package Panes;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import DAO.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import structure.Etudiant;

/**
 * AjoutEtudiantController est la classe de controle associee a la fenetre ajoutEtudiant.fxml
 * Ces dernieres permettent l'insertion d'un nouvel etudiant dans la base de donnees en utilisation la classe DAO correspondante 
 */
public class AjoutEtudiantController{
	
	@FXML
	private Button buttonEnregistrer;
	
	@FXML
	private TextField txtIdentifiant, txtCNE, txtNomEtudiant, txtPrenomEtudiant, txtSFamiliale, txtNationalite, txtSexe, txtAdresse, txtCodePostal, txtVille, txtDept, txtTel, txtMail, txtRIB, txtCniePere, txtNomPere, txtPrenomPere, txtCnieMere, txtNomMere, txtPrenomMere;
	
	@FXML
	private DatePicker dateNaissEtudiant, dateNaissPere, dateDecesPere, dateNaissMere, dateDecesMere;
	
	// methode associee au bouton d'ajout
	@FXML
	public boolean enregistrer(ActionEvent event ) throws SQLException{
		int ide;
		// gestion des erreurs
		try {
			ide = Integer.parseInt(txtIdentifiant.getText());
		} catch (NumberFormatException e) {
			// s'execute si l'utilisateur ne donne pas un nombre
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("id etudiant invalide");
			alert.showAndWait();
			return false;
		}
		String cne=txtCNE.getText();
		String nomE=txtNomEtudiant.getText();
		String prenomE=txtPrenomEtudiant.getText();
		String sFamiliale=txtSFamiliale.getText();
		String nationalite=txtNationalite.getText();
		
		LocalDate localDateE=dateNaissEtudiant.getValue();
		Date dateNaissE = localDateE == null ? null : Date.valueOf(localDateE);
		
		String sexe=txtSexe.getText();
		String adresse=txtAdresse.getText();

		Integer codePostal;
		try {
			if(txtCodePostal.getText().equals("")){
				// si l'utilisateur laisse le champs vide, c'est qu'il veut que le champs soit null (vide)
				codePostal = null;
			} else {
				codePostal = Integer.parseInt(txtCodePostal.getText());
			}
		} catch (NumberFormatException e) {
			// s'execute si l'utilisateur ne donne pas un nombre
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("code postal invalide");
			alert.showAndWait();
			return false;
		}
		String ville = txtVille.getText();
		Integer departement;
		try {
			if(txtDept.getText().equals("")){
				// si l'utilisateur laisse le champs vide, c'est qu'il veut que le champs soit null (vide)
				departement = null;
			} else {
				departement=Integer.parseInt(txtDept.getText());
			}
		} catch (NumberFormatException e) {
			// s'execute si l'utilisateur ne donne pas un nombre
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("departement invalide");
			alert.showAndWait();
			return false;
		}
		String telephone=txtTel.getText();
		String mail=txtMail.getText();
		String rib=txtRIB.getText();
		String cniep=txtCniePere.getText();
		String nomP=txtNomPere.getText();
		String prenomP=txtPrenomPere.getText();
		
		LocalDate localDateP1 = dateNaissPere.getValue();
		Date dateNaissP = localDateP1 == null ? null : Date.valueOf(localDateP1);
		LocalDate localDateP2 = dateDecesPere.getValue();
		Date dateDecesP = localDateP2 == null ? null :Date.valueOf(localDateP2);
		
		String cniem=txtCnieMere.getText();
		String nomM=txtNomMere.getText();
		String prenomM=txtPrenomMere.getText();
		
		Date dateNaissM = dateNaissMere.getValue() == null ? null : Date.valueOf(dateNaissMere.getValue());
		Date dateDecesM = dateDecesMere.getValue() == null ? null : Date.valueOf(dateDecesMere.getValue());

		
    	Etudiant  e = new Etudiant(ide,cne,nomE,prenomE,sFamiliale,nationalite,dateNaissE,sexe,adresse,codePostal,ville,departement,telephone,mail,rib,cniep,nomP,prenomP,dateNaissP,dateDecesP,cniem,nomM,prenomM,dateNaissM,dateDecesM);
    	
		// on utilise le pattern DAO etablit pour acceder a la base de donnees et ajouter un etudiant
    	if(DAOFactory.getEtudiantDAO().insert(e)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Succes");
			alert.setHeaderText("Succes");
			alert.setContentText("L'etudiant a ete ajoute avec succes!");
			alert.showAndWait();
    		return true;
    	}
    	else {
			// s'execute si l'id etudiant donne est deja utilise (c'est une cle primaire donc unique)
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur");
			alert.setContentText("L'etudiant n'a pas ete ajoute; l'etudiant " + ide + " existe deja");
			alert.showAndWait();
			return false;
    	}
    }
}
