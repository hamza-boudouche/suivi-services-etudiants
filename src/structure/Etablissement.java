package structure;

/**
 * Etablissement est la classe associee a la table "etablissement" de la base de donnees
 */
public class Etablissement {
	private int codeTab;
	private String desEtab;
	private int etudDpm;


	public Etablissement(int codeTab, String desEtab, int etudDpm) {
		this.codeTab = codeTab;
		this.desEtab = desEtab;
		this.etudDpm = etudDpm;
	}

	// ajoutée pour des raisons de debogage
	@Override
	public String toString() {
		return "{" +
			" codeTab='" + getCodeTab() + "'" +
			", desEtab='" + getDesEtab() + "'" +
			", etudDpm='" + getEtudDpm() + "'" +
			"}";
	}

	// setters and getters
	public int getCodeTab() {
		return this.codeTab;
	}

	public void setCodeTab(int codeTab) {
		this.codeTab = codeTab;
	}

	public String getDesEtab() {
		return this.desEtab;
	}

	public void setDesEtab(String desEtab) {
		this.desEtab = desEtab;
	}

	public int getEtudDpm() {
		return this.etudDpm;
	}

	public void setEtudDpm(int etudDpm) {
		this.etudDpm = etudDpm;
	}
}
