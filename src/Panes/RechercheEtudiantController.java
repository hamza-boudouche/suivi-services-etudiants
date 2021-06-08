package Panes;

import java.util.List;

import DAO.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import structure.Etudiant;

/**
 * RechercheEtudiantController est la classe de controle associee a la fenetre rechercheEtudiant.fxml
 * Ces dernieres permettent la recherche d'un (ou plusieurs etudiant) dans la base de donnees en utilisation la classe DAO correspondante 
 * si les champs de recherche restent vides alors tous les resultats possibles vont etre affiches
 */
public class RechercheEtudiantController {
	@FXML
	TextField tfIdEdtudiant;
	@FXML 
	Button btnRechercher;
	@FXML 
	HBox hbTableContainer;

	TableView<EtudiantTableEntry> tvResultat = new TableView<EtudiantTableEntry>();

	void initComponents(){
		TableColumn<EtudiantTableEntry, String> tcetudid = new TableColumn<EtudiantTableEntry, String>("Identifiant");
        TableColumn<EtudiantTableEntry, String> tcetudcne = new TableColumn<EtudiantTableEntry, String>("etudcne");
        TableColumn<EtudiantTableEntry, String> tcetudnom = new TableColumn<EtudiantTableEntry, String>("etudnom");
		TableColumn<EtudiantTableEntry, String> tcetudprenom = new TableColumn<EtudiantTableEntry, String>("etudprenom");
		TableColumn<EtudiantTableEntry, String> tcetudsfam = new TableColumn<EtudiantTableEntry, String>("etudsfam");
		TableColumn<EtudiantTableEntry, String> tcetudnat = new TableColumn<EtudiantTableEntry, String>("etudnat");
		TableColumn<EtudiantTableEntry, String> tcetudnai = new TableColumn<EtudiantTableEntry, String>("etudnai");
		TableColumn<EtudiantTableEntry, String> tcetudesexe = new TableColumn<EtudiantTableEntry, String>("etudesexe");
		TableColumn<EtudiantTableEntry, String> tcetudad1 = new TableColumn<EtudiantTableEntry, String>("etudad1");
		TableColumn<EtudiantTableEntry, String> tcetudcps = new TableColumn<EtudiantTableEntry, String>("etudcps");
		TableColumn<EtudiantTableEntry, String> tcetudvil = new TableColumn<EtudiantTableEntry, String>("etudvil");
		TableColumn<EtudiantTableEntry, String> tcetuddpt = new TableColumn<EtudiantTableEntry, String>("etuddpt");
		TableColumn<EtudiantTableEntry, String> tcetudtel = new TableColumn<EtudiantTableEntry, String>("etudtel");
		TableColumn<EtudiantTableEntry, String> tcetudmail = new TableColumn<EtudiantTableEntry, String>("etudmail");
		TableColumn<EtudiantTableEntry, String> tcetudrib = new TableColumn<EtudiantTableEntry, String>("etudrib");
		TableColumn<EtudiantTableEntry, String> tccniepere = new TableColumn<EtudiantTableEntry, String>("cniepere");
		TableColumn<EtudiantTableEntry, String> tcetudnomp = new TableColumn<EtudiantTableEntry, String>("etudnomp");
		TableColumn<EtudiantTableEntry, String> tcetudprep = new TableColumn<EtudiantTableEntry, String>("etudprep");
		TableColumn<EtudiantTableEntry, String> tcetuddnp = new TableColumn<EtudiantTableEntry, String>("etuddnp");
		TableColumn<EtudiantTableEntry, String> tcetudddp = new TableColumn<EtudiantTableEntry, String>("etudddp");
		TableColumn<EtudiantTableEntry, String> tccniemere = new TableColumn<EtudiantTableEntry, String>("cniemere");
		TableColumn<EtudiantTableEntry, String> tcetudnomm = new TableColumn<EtudiantTableEntry, String>("etudnomm");
		TableColumn<EtudiantTableEntry, String> tcetudprem = new TableColumn<EtudiantTableEntry, String>("etudprem");
		TableColumn<EtudiantTableEntry, String> tcetuddnm = new TableColumn<EtudiantTableEntry, String>("etuddnm");
		TableColumn<EtudiantTableEntry, String> tcetudddm = new TableColumn<EtudiantTableEntry, String>("etudddm");
		tvResultat.getColumns().addAll(tcetudid, tcetudcne, tcetudnom, tcetudprenom, tcetudsfam, tcetudnat, tcetudnai, tcetudesexe, tcetudad1, tcetudcps, tcetudvil, tcetuddpt, tcetudtel, tcetudmail, tcetudrib, tccniepere, tcetudnomp, tcetudprep, tcetuddnp, tcetudddp, tccniemere, tcetudnomm, tcetudprem, tcetuddnm, tcetudddm);
		
		
		

		tcetudid.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudid")
		);
		tcetudcne.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudcne")
		);
		tcetudnom.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudnom")
		);
		tcetudprenom.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudprenom")
		);
		tcetudsfam.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudsfam")
		);
		tcetudnat.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudnat")
		);
		tcetudnai.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudnai")
		);
		tcetudesexe.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudesexe")
		);
		tcetudad1.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudad1")
		);
		tcetudcps.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudcps")
		);
		tcetudvil.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudvil")
		);
		tcetuddpt.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etuddpt")
		);
		tcetudtel.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudtel")
		);
		tcetudmail.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudmail")
		);
		tcetudrib.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudrib")
		);
		tccniepere.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("cniepere")
		);
		tcetudnomp.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudnomp")
		);
		tcetudprep.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudprep")
		);
		tcetuddnp.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etuddnp")
		);
		tcetudddp.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudddp")
		);
		tccniemere.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("cniemere")
		);
		tcetudnomm.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudnomm")
		);
		tcetudprem.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudprem")
		);
		tcetuddnm.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etuddnm")
		);
		tcetudddm.setCellValueFactory(
			new PropertyValueFactory<EtudiantTableEntry,String>("etudddm")
		);
	}

	@FXML void rechercher(){
		initComponents();

		ObservableList<EtudiantTableEntry> data = FXCollections.observableArrayList();

		if(tfIdEdtudiant.getText().equals("")){
			List<Etudiant> etudiants = DAOFactory.getEtudiantDAO().getAll();
			if(etudiants.size() == 0){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Aucun etudiant n'existe dans la base de donnees");
				alert.showAndWait();
			}
			for (Etudiant etudiant : etudiants) {
				data.add(new EtudiantTableEntry(etudiant));
			}
		} else {
			try {
				int etudid = Integer.parseInt(tfIdEdtudiant.getText());
				Etudiant e = DAOFactory.getEtudiantDAO().get(etudid);
				if(e == null){
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erreur");
					alert.setContentText("Cet etudiant n'existe pas");
					alert.showAndWait();
				} else {
					data.add(new EtudiantTableEntry(e));
				}
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("id etudiant invalide");
				alert.showAndWait();
			}
		}
		tvResultat.getItems().clear();
		tvResultat.setItems(data);
		hbTableContainer.getChildren().clear();
		hbTableContainer.getChildren().add(tvResultat);
	}
}
