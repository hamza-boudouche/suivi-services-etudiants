package DAO;

public class DAOFactory {
	
	public static BourseDAO getBourseDAO(){
		return new BourseDAO();
	}

	public static CiteUnivDAO gCiteUnivDAO(){
		return new CiteUnivDAO();
	}

	public static CouvMedicDAO getCouvMedicDAO(){
		return new CouvMedicDAO();
	}

	public static EtablissementDAO gEtablissementDAO(){
		return new EtablissementDAO();
	}

	public static EtudiantDAO gEtudiantDAO(){
		return new EtudiantDAO();
	}

	public static FiliereDAO getFiliereDAO(){
		return new FiliereDAO();
	}

	public static MereDAO getMereDAO(){
		return new MereDAO();
	}

	public static PereDAO getPereDAO(){
		return new PereDAO();
	}

	public static UnivDeptDAO gUnivDeptDAO(){
		return new UnivDeptDAO();
	}
}
