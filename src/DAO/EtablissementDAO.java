package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import structure.Etablissement;

public class EtablissementDAO implements DAO<Etablissement>{
	private Connection connection;

	@Override
	public boolean insert(Etablissement etablissement) {
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO etablissement VALUES (?, ?, ?);");
			ps.setInt(1, etablissement.getCodeTab());
			ps.setString(2, etablissement.getDesEtab());
			ps.setInt(3, etablissement.getEtudDpm());
			int i = ps.executeUpdate();
			ps.close();
			connection.close();
			if(i == 1){
				return true;
			}
		} catch (SQLException e) {
			if(e.getMessage().contains("foreign key")){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Contrainte referentielle non respectée");
				alert.setContentText("Le departement " + etablissement.getEtudDpm() + " n'existe pas");
				alert.showAndWait();
			}
		}
		return false;
	}

	@Override
	public Etablissement get(int codeetab) {
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			String query = "select * from etablissement where codeetab = " + codeetab + ";";
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()){
				int etuddpm = rs.getInt("etuddpm");
				String desetab = rs.getString("desetab");
				rs.close();
				connection.close();
				return new Etablissement(codeetab, desetab, etuddpm);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("L'etablissement " + codeetab + " n'existe pas");
				alert.showAndWait();
				rs.close();
				connection.close();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Etablissement> getAll() {
		ArrayList<Etablissement> resultat = new ArrayList<Etablissement>();
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			String query = "select * from etablissement;";
			ResultSet rs = statement.executeQuery(query);
			int codeetab;
			String desetab;
			int etuddpm;
			while (rs.next()) {
				codeetab = rs.getInt("codeetab");
				desetab = rs.getString("desetab");
				etuddpm = rs.getInt("etuddpm");
				resultat.add(new Etablissement(codeetab, desetab, etuddpm));
			}
			rs.close();
			connection.close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Etablissement etablissement) {
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("update etablissement set desetab = ?, etuddpm = ? where codeetab = " + etablissement.getCodeTab() + ";");
			ps.setString(1, etablissement.getDesEtab());
			ps.setInt(2, etablissement.getEtudDpm());
			int i = ps.executeUpdate();
			ps.close();
			connection.close();
			if(i != 1){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("L'etablissement " + etablissement.getCodeTab() + " n'existe pas");
				alert.showAndWait();
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		connection = ConnectionFactory.getConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "delete from etablissement where codeetab = " + id + ";";
			int i = statement.executeUpdate(query);
			if(i != 1){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("L'etablissement " + id + " n'existe pas");
				alert.showAndWait();
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
