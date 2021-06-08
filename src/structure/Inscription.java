package structure;

import java.sql.Date;

/**
 * Inscription est la classe associee a la table "inscription" de la base de donnees
 */
public class Inscription {
	private int etudId;
	private int etudEtab;
	private Integer etudFil;
	private Date etudInsc;


	public Inscription(int etudId, int etudEtab, Integer etudFil, Date etudInsc) {
		this.etudId = etudId;
		this.etudEtab = etudEtab;
		this.etudFil = etudFil;
		this.etudInsc = etudInsc;
	}

	// ajoutée pour des raisons de debogage
	@Override
	public String toString() {
		return "{" +
			" etudId='" + getEtudId() + "'" +
			", etudEtab='" + getEtudEtab() + "'" +
			", etudFil='" + getEtudFil() + "'" +
			", etudInsc='" + getEtudInsc() + "'" +
			"}";
	}

	// setters and getters
	public int getEtudId() {
		return this.etudId;
	}

	public void setEtudId(int etudId) {
		this.etudId = etudId;
	}

	public int getEtudEtab() {
		return this.etudEtab;
	}

	public void setEtudEtab(int etudEtab) {
		this.etudEtab = etudEtab;
	}

	public Integer getEtudFil() {
		return this.etudFil;
	}

	public void setEtudFil(Integer etudFil) {
		this.etudFil = etudFil;
	}

	public Date getEtudInsc() {
		return this.etudInsc;
	}

	public void setEtudInsc(Date etudInsc) {
		this.etudInsc = etudInsc;
	}

}
