package Panes;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

import DAO.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import structure.Etudiant;

public class AjoutEtudiantController{
	
	@FXML
	private Button buttonEnregistrer;
	
	@FXML
	private TextField txtIdentifiant, txtCNE, txtNomEtudiant, txtPrenomEtudiant, txtSFamiliale, txtNationalite, txtSexe, txtAdresse, txtCodePostal, txtVille, txtDept, txtTel, txtMail, txtRIB, txtCniePere, txtNomPere, txtPrenomPere, txtCnieMere, txtNomMere, txtPrenomMere;
	
	@FXML
	private DatePicker dateNaissEtudiant, dateNaissPere, dateDecesPere, dateNaissMere, dateDecesMere;
	
	@FXML
	public void enregistrer(ActionEvent event ) throws SQLException{
		int ide=Integer.parseInt(txtIdentifiant.getText());
		String cne=txtCNE.getText();
		String nomE=txtNomEtudiant.getText();
		String prenomE=txtPrenomEtudiant.getText();
		String sFamiliale=txtSFamiliale.getText();
		String nationalite=txtNationalite.getText();
		
		LocalDate localDateE=dateNaissEtudiant.getValue();
		java.util.Date dateNaissE = Date.from(localDateE.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		String sexe=txtSexe.getText();
		String adresse=txtAdresse.getText();
		int codePostal=Integer.parseInt(txtCodePostal.getText());
		String ville=txtVille.getText();
		int departement=Integer.parseInt(txtDept.getText());
		String telephone=txtTel.getText();
		String mail=txtMail.getText();
		String rib=txtRIB.getText();
		String cniep=txtCniePere.getText();
		String nomP=txtNomPere.getText();
		String prenomP=txtPrenomPere.getText();
		
		LocalDate localDateP1=dateNaissPere.getValue();
		java.util.Date dateNaissP=Date.from(localDateP1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		LocalDate localDateP2=dateDecesPere.getValue();
		java.util.Date dateDecesP=Date.from(localDateP2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		String cniem=txtCnieMere.getText();
		String nomM=txtNomMere.getText();
		String prenomM=txtPrenomMere.getText();
		
		LocalDate localDateM1=dateNaissMere.getValue();
		java.util.Date dateNaissM=Date.from(localDateM1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		LocalDate localDateM2=dateDecesMere.getValue();
		java.util.Date dateDecesM=Date.from(localDateM2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
    	Etudiant  e = new Etudiant(ide,cne,nomE,prenomE,sFamiliale,nationalite,dateNaissE,sexe,adresse,codePostal,ville,departement,telephone,mail,rib,cniep,nomP,prenomP,dateNaissP,dateDecesP,cniem,nomM,prenomM,dateNaissM,dateDecesM);
    	
    	DAOFactory.gEtudiantDAO().insert(e);
    }
	

}
