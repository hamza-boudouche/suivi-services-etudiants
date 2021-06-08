package DAO;

/**
 * Classe factory permettant d'avoir un acces directe a des instances des classes DAO
 */
public class DAOFactory {

	public static EtablissementDAO getEtablissementDAO(){
		return new EtablissementDAO();
	}

	public static EtudiantDAO getEtudiantDAO(){
		return new EtudiantDAO();
	}

	public static FiliereDAO getFiliereDAO(){
		return new FiliereDAO();
	}

	public static InscriptionDAO getInscriptionDAO(){
		return new InscriptionDAO();
	}

	public static ServiceEtudDAO gServiceEtudDAO(){
		return new ServiceEtudDAO();
	}
}
