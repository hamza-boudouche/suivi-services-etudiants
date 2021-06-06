package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import structure.Etudiant;
import structure.ServiceEtud;

public class EtudiantDAO implements DAO<Etudiant> {
	private Connection connection;

	@Override
	public boolean insert(Etudiant t) {
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = null;
			ps = connection.prepareStatement(
					"INSERT INTO etudiant VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			ps.setInt(1, t.getEtudID());
			ps.setString(2, t.getEtudCne());
			ps.setString(3, t.getEtudNom());
			ps.setString(4, t.getEtudPrenom());
			ps.setString(5, t.getEtudsFam());
			ps.setString(6, t.getEtudNat());
			ps.setDate(7, t.getEtudNai());
			ps.setString(8, t.getEtudSex());
			ps.setString(9, t.getEtudad1());
			ps.setInt(10, t.getEtudCps());
			ps.setString(11, t.getEtudVil());
			ps.setInt(12, t.getEtudDpt());
			ps.setString(13, t.getEtudTel());
			ps.setString(14, t.getEtudMail());
			ps.setString(15, t.getEtudRib());
			ps.setString(16, t.getCniePere());
			ps.setString(17, t.getEtudNomP());
			ps.setString(18, t.getEtudPreP());
			ps.setDate(19, t.getEtudDNP());
			ps.setDate(20, t.getEtudDDP());
			ps.setString(21, t.getCnieMere());
			ps.setString(22, t.getEtudNomM());
			ps.setString(23, t.getEtudPreM());
			ps.setDate(24, t.getEtudDNM());
			ps.setDate(25, t.getEtudDDM());

			int i = ps.executeUpdate();
			ps.close();
			connection.close();
			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Etudiant get(int id) {
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			String query = "select * from etudiant where etudid = " + id + ";";
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				String etudcne = rs.getString("etudcne");
				String etudnom = rs.getString("etudnom");
				String etudprenom = rs.getString("etudprenom");
				String etudsfam = rs.getString("etudsfam");
				String etudnat = rs.getString("etudnat");
				Date etudnai = rs.getDate("etudnai");
				String etudesexe = rs.getString("etudesexe");
				String etudad1 = rs.getString("etudad1");
				int etudcps = rs.getInt("etudcps");
				String etudvil = rs.getString("etudvil");
				int etuddpt = rs.getInt("etuddpt");
				String etudtel = rs.getString("etudtel");
				String etudmail = rs.getString("etudmail");
				String etudrib = rs.getString("etudrib");
				String cniepere = rs.getString("cniepere");
				String etudnomp = rs.getString("etudnomp");
				String etudprep = rs.getString("etudprep");
				Date etuddnp = rs.getDate("etuddnp");
				Date etudddp = rs.getDate("etudddp");
				String cniemere = rs.getString("cniemere");
				String etudnomm = rs.getString("etudnomm");
				String etudprem = rs.getString("etudprem");
				Date etuddnm = rs.getDate("etuddnm");
				Date etudddm = rs.getDate("etudddm");

				rs.close();
				connection.close();
				return new Etudiant(id, etudcne, etudnom, etudprenom, etudsfam, etudnat, etudnai, etudesexe, etudad1,
						etudcps, etudvil, etuddpt, etudtel, etudmail, etudrib, cniepere, etudnomp, etudprep, etuddnp,
						etudddp, cniemere, etudnomm, etudprem, etuddnm, etudddm);

			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("L'etudiant " + id + " n'existe pas");
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
	public List<Etudiant> getAll() {
		ArrayList<Etudiant> resultat = new ArrayList<Etudiant>();
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			String query = "select * from etudiant;";
			ResultSet rs = statement.executeQuery(query);
			int etudid;
			String etudcne;
			String etudnom;
			String etudprenom;
			String etudsfam;
			String etudnat;
			Date etudnai;
			String etudesexe;
			String etudad1;
			int etudcps;
			String etudvil;
			int etuddpt;
			String etudtel;
			String etudmail;
			String etudrib;
			String cniepere;
			String etudnomp;
			String etudprep;
			Date etuddnp;
			Date etudddp;
			String cniemere;
			String etudnomm;
			String etudprem;
			Date etuddnm;
			Date etudddm;

			while (rs.next()) {
				etudid = rs.getInt("etudid");

				etudcne = rs.getString("etudcne");
				etudnom = rs.getString("etudnom");
				etudprenom = rs.getString("etudprenom");
				etudsfam = rs.getString("etudsfam");
				etudnat = rs.getString("etudnat");
				etudnai = rs.getDate("etudnai");
				etudesexe = rs.getString("etudesexe");
				etudad1 = rs.getString("etudad1");
				etudcps = rs.getInt("etudcps");
				etudvil = rs.getString("etudvil");
				etuddpt = rs.getInt("etuddpt");
				etudtel = rs.getString("etudtel");
				etudmail = rs.getString("etudmail");
				etudrib = rs.getString("etudrib");
				cniepere = rs.getString("cniepere");
				etudnomp = rs.getString("etudnomp");
				etudprep = rs.getString("etudprep");
				etuddnp = rs.getDate("etuddnp");
				etudddp = rs.getDate("etudddp");
				cniemere = rs.getString("cniemere");
				etudnomm = rs.getString("etudnomm");
				etudprem = rs.getString("etudprem");
				etuddnm = rs.getDate("etuddnm");
				etudddm = rs.getDate("etudddm");

				resultat.add(new Etudiant(etudid, etudcne, etudnom, etudprenom, etudsfam, etudnat, etudnai, etudesexe,
						etudad1, etudcps, etudvil, etuddpt, etudtel, etudmail, etudrib, cniepere, etudnomp, etudprep,
						etuddnp, etudddp, cniemere, etudnomm, etudprem, etuddnm, etudddm));
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
	public boolean update(Etudiant t) {
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"update etudiant set etudcne = ?, etudnom = ?, etudprenom = ?, etudsfam = ?, etudnat = ?, etudnai = ?, etudesexe = ?, etudad1 = ?, etudcps = ?, etudvil = ?, etuddpt = ?, etudtel = ?, etudmail = ?, etudrib = ?, cniepere = ?, etudnomp = ?, etudprep = ?, etuddnp = ?, etudddp = ?, cniemere = ?, etudnomm = ?, etudprem = ?, etuddnm = ?, etudddm = ? where etudid = "
							+ t.getEtudID() + ";");
			ps.setString(1, t.getEtudCne());
			ps.setString(2, t.getEtudNom());
			ps.setString(3, t.getEtudPrenom());
			ps.setString(4, t.getEtudsFam());
			ps.setString(5, t.getEtudNat());
			ps.setDate(6, t.getEtudNai());
			ps.setString(7, t.getEtudSex());
			ps.setString(8, t.getEtudad1());
			ps.setInt(9, t.getEtudCps());
			ps.setString(10, t.getEtudVil());
			ps.setInt(11, t.getEtudDpt());
			ps.setString(12, t.getEtudTel());
			ps.setString(13, t.getEtudMail());
			ps.setString(14, t.getEtudRib());
			ps.setString(15, t.getCniePere());
			ps.setString(16, t.getEtudNomP());
			ps.setString(17, t.getEtudPreP());
			ps.setDate(18, t.getEtudDNP());
			ps.setDate(19, t.getEtudDDP());
			ps.setString(20, t.getCnieMere());
			ps.setString(21, t.getEtudNomM());
			ps.setString(22, t.getEtudPreM());
			ps.setDate(23, t.getEtudDNM());
			ps.setDate(24, t.getEtudDDM());
			int i = ps.executeUpdate();
			ps.close();
			connection.close();
			if (i != 1) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("L'etudiant " + t.getEtudID() + " n'existe pas");
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
			String query = "delete from etudiant where etudid = " + id + ";";
			int i = statement.executeUpdate(query);
			if (i != 1) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Erreur");
				alert.setContentText("L'etudiant " + id + " n'existe pas");
				alert.showAndWait();
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Map<Etudiant, ServiceEtud> getEtudiantServiceParEtab(int etudetab) {
		Map<Etudiant, ServiceEtud> result = new HashMap<Etudiant, ServiceEtud>();
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			String query = "select * from etudiant join servicesetud on etudiant.etudid = servicesetud.etudid join inscription on servicesetud.etudans = year(inscription.etudinsc) where etudetab = " + etudetab + ";";
			ResultSet rs = statement.executeQuery(query);
			int etudid;
			String etudcne;
			String etudnom;
			String etudprenom;
			String etudsfam;
			String etudnat;
			Date etudnai;
			String etudesexe;
			String etudad1;
			int etudcps;
			String etudvil;
			int etuddpt;
			String etudtel;
			String etudmail;
			String etudrib;
			String cniepere;
			String etudnomp;
			String etudprep;
			Date etuddnp;
			Date etudddp;
			String cniemere;
			String etudnomm;
			String etudprem;
			Date etuddnm;
			Date etudddm;

			int etudans;
			int etudbo;
			int etudcu;
			int etudcmb;
			int etudcmbo;

			while (rs.next()) {
				etudid = rs.getInt("etudid");

				etudcne = rs.getString("etudcne");
				etudnom = rs.getString("etudnom");
				etudprenom = rs.getString("etudprenom");
				etudsfam = rs.getString("etudsfam");
				etudnat = rs.getString("etudnat");
				etudnai = rs.getDate("etudnai");
				etudesexe = rs.getString("etudesexe");
				etudad1 = rs.getString("etudad1");
				etudcps = rs.getInt("etudcps");
				etudvil = rs.getString("etudvil");
				etuddpt = rs.getInt("etuddpt");
				etudtel = rs.getString("etudtel");
				etudmail = rs.getString("etudmail");
				etudrib = rs.getString("etudrib");
				cniepere = rs.getString("cniepere");
				etudnomp = rs.getString("etudnomp");
				etudprep = rs.getString("etudprep");
				etuddnp = rs.getDate("etuddnp");
				etudddp = rs.getDate("etudddp");
				cniemere = rs.getString("cniemere");
				etudnomm = rs.getString("etudnomm");
				etudprem = rs.getString("etudprem");
				etuddnm = rs.getDate("etuddnm");
				etudddm = rs.getDate("etudddm");

				etudans=rs.getInt("etudans");
				etudbo=rs.getInt("etudbo");
				etudcu=rs.getInt("etudcu");
				etudcmb=rs.getInt("etudcmb");
				etudcmbo=rs.getInt("etudcmbo");

				result.put(new Etudiant(etudid, etudcne, etudnom, etudprenom, etudsfam, etudnat, etudnai, etudesexe,
						etudad1, etudcps, etudvil, etuddpt, etudtel, etudmail, etudrib, cniepere, etudnomp, etudprep,
						etuddnp, etudddp, cniemere, etudnomm, etudprem, etuddnm, etudddm), new ServiceEtud(etudid, etudans, etudbo, etudcu, etudcmb, etudcmbo));
			}			
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}