package Panes;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import DAO.DAOFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import structure.Etablissement;
import structure.Etudiant;
import structure.ServiceEtud;

public class ListeEtudiantsController {
	@FXML
	ComboBox<String> etablissement;
	@FXML
	Button btnRechercher;
	@FXML
	HBox hbTableContainer;

	@FXML void initElements(){
		List<Etablissement> etabs = DAOFactory.gEtablissementDAO().getAll();
		for (Etablissement etab : etabs) {
			etablissement.getItems().add(((Integer) etab.getCodeTab()).toString());
		}
	}

	@FXML
	void rechercher(){
		TableView<TableEntry> tvResultat = new TableView<TableEntry>();

		TableColumn<TableEntry, String> tcIdEtudiant = new TableColumn<TableEntry, String>("Identifiant");
        TableColumn<TableEntry, String> tcNomPrenomEtudiant = new TableColumn<TableEntry, String>("Nom Prenom");
        TableColumn<TableEntry, String> tcBourse = new TableColumn<TableEntry, String>("bourse");
		TableColumn<TableEntry, String> tcCiteUniv = new TableColumn<TableEntry, String>("cité univ");
		TableColumn<TableEntry, String> tcCouvMed = new TableColumn<TableEntry, String>("Couv. Medic.");
		TableColumn<TableEntry, String> tcService = new TableColumn<TableEntry, String>("Service");
		tcService.getColumns().addAll(tcBourse, tcCiteUniv, tcCouvMed);
		tvResultat.getColumns().addAll(tcIdEtudiant, tcNomPrenomEtudiant, tcService);

		
		Map<Etudiant, ServiceEtud> rawData = DAOFactory.gEtudiantDAO().getEtudiantServiceParEtab();
		ObservableList<TableEntry> data = FXCollections.observableArrayList();
		rawData.forEach((key, value) -> data.add(new TableEntry(key, value)));

		
		tcIdEtudiant.setCellValueFactory(
			new PropertyValueFactory<TableEntry,String>("idEtudiant")
		);
		tcNomPrenomEtudiant.setCellValueFactory(
			new PropertyValueFactory<TableEntry,String>("nomPrenomEtudiant")
		);
		tcBourse.setCellValueFactory(
			new PropertyValueFactory<TableEntry,String>("bourse")
		);
		tcCiteUniv.setCellValueFactory(
			new PropertyValueFactory<TableEntry,String>("citeUniv")
		);
		tcCouvMed.setCellValueFactory(
			new PropertyValueFactory<TableEntry,String>("couvMedic")
		);

		tvResultat.setItems(data);
		hbTableContainer.getChildren().add(tvResultat);
	}
}

