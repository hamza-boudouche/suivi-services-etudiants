package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import structure.Inscription;

public class InscriptionDAO implements DAO<Inscription>{
	private Connection connection;
	
	@Override
	public boolean insert(Inscription inscription) {
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO inscription VALUES (?, ?, ?, ?);");
			ps.setInt(1, inscription.getEtudId());
			ps.setInt(2, inscription.getEtudEtab());
			ps.setObject(3, inscription.getEtudFil(), java.sql.Types.INTEGER);
			ps.setDate(4, inscription.getEtudInsc());
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
				alert.setContentText("L'etudiant " + inscription.getEtudId() + " n'existe pas");
				alert.showAndWait();
			}
		}
		return false;
	}

	public Inscription getInscription(int etudid, int etudetab, Date etudinsc) {
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			String query = "select * from inscription where etudid = " + etudid + " and etudetab = " + etudetab + " and etudinsc = " + etudinsc + ";";
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()){
				int etudfil = rs.getInt("etudfil");
				rs.close();
				connection.close();
				return new Inscription(etudid, etudetab, etudfil, etudinsc);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Cette inscription n'existe pas");
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
	public List<Inscription> getAll() {
		ArrayList<Inscription> resultat = new ArrayList<Inscription>();
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			String query = "select * from inscription;";
			ResultSet rs = statement.executeQuery(query);
			int etudid;
			int etudetab;
			int etudfil;
			Date etudinsc;
			while (rs.next()) {
				etudid = rs.getInt("etudid");
				etudetab = rs.getInt("etudetab");
				etudfil = rs.getInt("etudfil");
				etudinsc = rs.getDate("etudinsc");
				resultat.add(new Inscription(etudid, etudetab, etudfil, etudinsc));
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
	public boolean update(Inscription inscription) {
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("update inscription set etudfil = ? where etudetab = " + inscription.getEtudEtab() + " and etudid = " + inscription.getEtudId() + " etudinsc = " + inscription.getEtudInsc() + " ;");
			ps.setObject(1, inscription.getEtudFil(), java.sql.Types.INTEGER);
			int i = ps.executeUpdate();
			ps.close();
			connection.close();
			if(i != 1){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Cette inscription n'existe pas");
				alert.showAndWait();
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int etudid, int etudetab, Date etudinsc) {
		connection = ConnectionFactory.getConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "delete from inscription where etudid = " + etudid + " and etudetab = " + etudetab + " and etudinsc = " + etudinsc + ";";
			int i = statement.executeUpdate(query);
			if(i != 1){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Cette inscription n'existe pas");
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
	public Inscription get(int id) {
		return null;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}
}
