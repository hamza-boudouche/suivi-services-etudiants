package structure;

/**
 * Filiere est la classe associee a la table "filiere" de la base de donnees
 */
public class Filiere {
	public int codeEtab;
	private int codeFil;
	private String desFil;
	

	public Filiere(int codeEtab, int codeFil, String desFil) {
		this.codeEtab = codeEtab;
		this.codeFil = codeFil;
		this.desFil = desFil;
	}

	// ajoutée pour des raisons de debogage
	@Override
	public String toString() {
		return "{" +
			" codeEtab='" + getCodeEtab() + "'" +
			", codeFil='" + getCodeFil() + "'" +
			", desFil='" + getDesFil() + "'" +
			"}";
	}

	// setters and getters
	public int getCodeEtab() {
		return this.codeEtab;
	}

	public void setCodeEtab(int codeEtab) {
		this.codeEtab = codeEtab;
	}

	public int getCodeFil() {
		return this.codeFil;
	}

	public void setCodeFil(int codeFil) {
		this.codeFil = codeFil;
	}

	public String getDesFil() {
		return this.desFil;
	}

	public void setDesFil(String desFil) {
		this.desFil = desFil;
	}

}
