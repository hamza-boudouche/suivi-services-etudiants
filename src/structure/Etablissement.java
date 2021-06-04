package structure;

public class Etablissement {
	private int codeTab;
	private String desEtab;
	private int etudDpm;


	public Etablissement(int codeTab, String desEtab, int etudDpm) {
		this.codeTab = codeTab;
		this.desEtab = desEtab;
		this.etudDpm = etudDpm;
	}


	@Override
	public String toString() {
		return "{" +
			" codeTab='" + getCodeTab() + "'" +
			", desEtab='" + getDesEtab() + "'" +
			", etudDpm='" + getEtudDpm() + "'" +
			"}";
	}

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
