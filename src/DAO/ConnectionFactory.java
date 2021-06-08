package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
/**
 * le role de cette classe est de creer des instance de connection a la base de données
 */
public class ConnectionFactory {
	// permet l'acces a un base de donnees dont on specifie le nom - remarquez ici l'attribut allowLoadLocalInfile qui egal egal a true pour permettre le chargement de fichiers externes
	public static final String URL = "jdbc:mysql://localhost:3306/suiviserviceetudiants?allowLoadLocalInfile=true";
	// utilisateur root a l'acces a toute les tables par defaut
	public static final String USER = "root";
	// le mot de passe de cet utilisateur est stocke dans une variable d'environnement "PASSWORD" pour des raisons de securité
	public static final String PASSWORD = System.getenv("PASSWORD");
	// le driver utilisé
	public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

	private ConnectionFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// recuperer une instance d'une connection
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return connection;
	}

	// methode d'import des données dans une table a partir d'un fichier donnés
	public static int importData(String path, String table) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement statement = connection.createStatement();
			String command = " LOAD DATA LOCAL INFILE '" + path + "' INTO TABLE " + table + " FIELDS TERMINATED BY \',\'; ";
			return statement.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
