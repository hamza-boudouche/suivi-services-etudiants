package DAO;

public class DAOFactory {

	public static EtablissementDAO gEtablissementDAO(){
		return new EtablissementDAO();
	}

	public static EtudiantDAO gEtudiantDAO(){
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
