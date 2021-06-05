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
import structure.Filiere;

public class FiliereDAO implements DAO<Filiere>{
	private Connection connection;
	
	@Override
	public boolean insert(Filiere filiere) {
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO filiere VALUES (?, ?, ?);");
			ps.setInt(1, filiere.getCodeEtab());
			ps.setInt(2, filiere.getCodeFil());
			ps.setString(3, filiere.getDesFil());
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
				alert.setContentText("L'etablissement " + filiere.getCodeEtab() + " n'existe pas");
				alert.showAndWait();
			}
		}
		return false;
	}

	public Filiere get(int codeetab, int codefil) {
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			String query = "select * from filiere where codeetab = " + codeetab + " and codefil = " + codefil + ";";
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()){
				String desfil = rs.getString("desfil");
				rs.close();
				connection.close();
				return new Filiere(codeetab, codefil, desfil);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Cette filiere n'existe pas");
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
	public List<Filiere> getAll() {
		ArrayList<Filiere> resultat = new ArrayList<Filiere>();
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			String query = "select * from filiere;";
			ResultSet rs = statement.executeQuery(query);
			int codeetab;
			int codefil;
			String desfil;
			while (rs.next()) {
				codeetab = rs.getInt("codeetab");
				codefil = rs.getInt("codefil");
				desfil = rs.getString("desfil");
				resultat.add(new Filiere(codeetab, codefil, desfil));
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
	public boolean update(Filiere filiere) {
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("update filiere set desfil = ? where codeetab = " + filiere.getCodeEtab() + " and codefil = " + filiere.getCodeFil() + ";");
			ps.setString(1, filiere.getDesFil());
			int i = ps.executeUpdate();
			ps.close();
			connection.close();
			if(i != 1){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Cette filiere n'existe pas");
				alert.showAndWait();
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteFiliere(int codeetab, int codefil) {
		connection = ConnectionFactory.getConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "delete from filiere where codeetab = " + codeetab + " and codefil = " + codefil + ";";
			int i = statement.executeUpdate(query);
			if(i != 1){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Cette filiere n'existe pas ");
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
		return false;
	}

	@Override
	public Filiere get(int id) {
		return null;
	}
}
