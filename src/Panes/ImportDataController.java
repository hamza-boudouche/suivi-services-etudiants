package Panes;

import java.io.File;

import DAO.ConnectionFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * C'est la classe de control de la fentre d'import des données de fichier externe "importData.fxml"
 * Elle permet de designer un fichier csv par plusieurs methodes:
 *  + par son chemin absolue ecrit dans un champ de text
 *  + en le choisissant a partir d'une fenetre de choix de fichier du systeme
 *  + en le glissant a l'interieur d'une zone dans la fenetre affichee
 */
public class ImportDataController {
	@FXML
	Button btnChoisirFichier;
	@FXML
	Button btnImporter;
	@FXML
	TextField tfPath;
	@FXML
	VBox vbDragTarget;
	@FXML 
	ComboBox cbTabels;

	// ecrire le chemin dans la zone de texte
	@FXML
	void getFile() {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {
			String path = file.getAbsolutePath();
			System.out.println(path);
			path = path.replace("\\", "/");
			tfPath.setText(path);
		}
	}

	// permettre d'accepter le glissement du fichier sur la fenetre
	@FXML
	void onDragOver(DragEvent event) {
		if (event.getGestureSource() != vbDragTarget && event.getDragboard().hasFiles()) {
			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		}
		event.consume();
	}

	// recuperer le chemin absolue du fichier glissé eet l'ecrire dans la zone de texte
	@FXML
	void onDragDropped(DragEvent event) {
		Dragboard db = event.getDragboard();
		boolean success = false;
		if (db.hasFiles()) {
			System.out.println();
			String path = db.getFiles().get(0).getAbsolutePath();
			path = path.replace("\\", "/");
			tfPath.setText(path);
			success = true;
		}
		event.setDropCompleted(success);
		event.consume();
	}

	// permet d'importer les donnees du fichier dans une table deja specifiee a partir d'un comboBox (menu defilant)
	@FXML
	void importer() {
		String pathString = tfPath.getText();
		System.out.println(pathString);
		String table = (String) cbTabels.getValue();
		int result = ConnectionFactory.importData(pathString, table);

		// si le fichier n'est pas compatible
		if(!pathString.endsWith(".csv")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur d'importation");
			alert.setContentText("Ce type de fichier n'est pas supporté. Utiliser plutot un .csv");
			alert.showAndWait();
			return;
		}

		// succes
		if(result == 0){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Succes");
			alert.setHeaderText("le fichier a été importé avec succes!");
			alert.setContentText("Vous pouvez fermer cette fenetre");

			alert.showAndWait();
		} else {
			// fichier introuvable
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Erreur d'importation");
			alert.setContentText("Avez vous formattez le chemin correctement?");
			alert.showAndWait();
		}
	}
}
