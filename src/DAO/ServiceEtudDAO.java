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
import structure.ServiceEtud;

/**
 * Classe DAO permettant acces a la table "serviceetud"
 */
public class ServiceEtudDAO implements DAO<ServiceEtud>{
	private Connection connection;

	@Override
	public boolean insert(ServiceEtud t) {
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO servicesetud VALUES (?, ?, ?, ?, ?, ?);");
			ps.setInt(1, t.getEtudId());
			ps.setInt(2, t.getEtudAns());
			ps.setObject(3, t.getEtudBo(), java.sql.Types.INTEGER);
			ps.setObject(4, t.getEtudCu(), java.sql.Types.INTEGER);
			ps.setObject(5, t.getEtudCmb(), java.sql.Types.INTEGER);
			ps.setObject(6, t.getEtudCmbo(), java.sql.Types.INTEGER);
			System.out.println(ps.toString());
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
				alert.setHeaderText("Contrainte referentielle non respectee");
				alert.setContentText("L'etudiant " + t.getEtudId() + " n'existe pas");
				alert.showAndWait();
			}
		}
		return false;
	}

	public ServiceEtud get(int id, int anneeScolaire) {
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			String query = "select * from servicesetud where etudid = " + id + " and etudans = " + anneeScolaire +";";
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()){
				int etudbo=rs.getInt("etudbo");
				int etudcu=rs.getInt("etudcu");
				int etudcmb=rs.getInt("etudcmb");
				int etudcmbo=rs.getInt("etudcmbo");
				
				rs.close();
				connection.close();
				return new ServiceEtud(id,anneeScolaire,etudbo,etudcu,etudcmb,etudcmbo);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Le service de l'etudiant " + id + " pour l'annee " + anneeScolaire + " n'existe pas");
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
	public ServiceEtud get(int id) {
		return null;
	}
	

	@Override
	public List<ServiceEtud> getAll() {
		ArrayList<ServiceEtud> resultat = new ArrayList<ServiceEtud>();
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			String query = "select * from  servicesetud;";
			ResultSet rs = statement.executeQuery(query);
			int etudid, etudans, etudbo, etudcu, etudcmb, etudcmbo;
			while (rs.next()) {
				etudid=rs.getInt("etudid");
				etudans=rs.getInt("etudans");
				etudbo=rs.getInt("etudbo");
				etudcu=rs.getInt("etudcu");
				etudcmb=rs.getInt("etudcmb");
				etudcmbo=rs.getInt("etudcmbo");
				
				resultat.add(new ServiceEtud(etudid,etudans,etudbo,etudcu,etudcmb,etudcmbo));
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
	public boolean update(ServiceEtud t) {
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("update servicesetud set etudbo = ?, etudcu = ?, etudcmb = ?, etudcmbo = ? where etudid = " + t.getEtudId() + " and etudans = " + t.getEtudAns() +";");
			ps.setObject(1, t.getEtudBo(), java.sql.Types.INTEGER);
			ps.setObject(2, t.getEtudCu(), java.sql.Types.INTEGER);
			ps.setObject(3, t.getEtudCmb(), java.sql.Types.INTEGER);
			ps.setObject(4, t.getEtudCmbo(), java.sql.Types.INTEGER);
			int i = ps.executeUpdate();
			ps.close();
			connection.close();
			if(i != 1){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Le service de l'etudiant " + t.getEtudId() + " pour l'annee " + t.getEtudAns() + " n'existe pas");
				alert.showAndWait();
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean delete(int id,int anneeScolaire) {
		connection = ConnectionFactory.getConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "delete from servicesetud where etudid = " + id + " and etudans =" + anneeScolaire + ";";
			int i = statement.executeUpdate(query);
			if(i != 1){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("Le service de l'etudiant " + id + " pour l'annee " + anneeScolaire + " n'existe pas");
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
}
