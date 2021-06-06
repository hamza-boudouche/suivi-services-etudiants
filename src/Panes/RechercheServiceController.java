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
import structure.ServiceEtud;

public class RechercheServiceController {
	@FXML
	TextField tfetudid;
	@FXML
	TextField tfetudans;
	@FXML
	Button btnrechercher;
	@FXML
	TableView<ServiceEtudTableEntry> tvResultats;
	@FXML
	TableColumn<ServiceEtudTableEntry, String> tcetudid;
	@FXML
	TableColumn<ServiceEtudTableEntry, String> tcetudans;
	@FXML
	TableColumn<ServiceEtudTableEntry, String> tcetudbo;
	@FXML
	TableColumn<ServiceEtudTableEntry, String> tcetudcu;
	@FXML
	TableColumn<ServiceEtudTableEntry, String> tcetudcmb;
	@FXML
	TableColumn<ServiceEtudTableEntry, String> tcetudcmbo;
	

	void initComponents(){
		tcetudid.setCellValueFactory(
			new PropertyValueFactory<ServiceEtudTableEntry,String>("etudid")
		);
		tcetudans.setCellValueFactory(
			new PropertyValueFactory<ServiceEtudTableEntry,String>("etudans")
		);
		tcetudbo.setCellValueFactory(
			new PropertyValueFactory<ServiceEtudTableEntry,String>("etudbo")
		);
		tcetudcu.setCellValueFactory(
			new PropertyValueFactory<ServiceEtudTableEntry,String>("etudcu")
		);
		tcetudcmb.setCellValueFactory(
			new PropertyValueFactory<ServiceEtudTableEntry,String>("etudcmb")
		);
		tcetudcmbo.setCellValueFactory(
			new PropertyValueFactory<ServiceEtudTableEntry,String>("etudcmbo")
		);
	}

	@FXML void rechercher(){
		initComponents();

		ObservableList<ServiceEtudTableEntry> data = FXCollections.observableArrayList();

		if(tfetudans.getText().equals("") && tfetudid.getText().equals("")){
			List<ServiceEtud> services = DAOFactory.gServiceEtudDAO().getAll();
			if(services.size() == 0){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Aucun service n'existe dans la base de donnees");
				alert.showAndWait();
			}
			for (ServiceEtud service : services) {
				data.add(new ServiceEtudTableEntry(service));
			}
		} else {
			try {
				int etudid = Integer.parseInt(tfetudid.getText());
				int etudans = Integer.parseInt(tfetudans.getText());
				ServiceEtud s = DAOFactory.gServiceEtudDAO().get(etudid, etudans);
				if(s == null){
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erreur");
					alert.setContentText("Ce service n'existe pas");
					alert.showAndWait();
				} else {
					data.add(new ServiceEtudTableEntry(s));
				}
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("entrées invalides");
				alert.showAndWait();
			}
		}

		tvResultats.setItems(data);
	}
}
