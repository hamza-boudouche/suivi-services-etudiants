package structure;

import java.sql.Date;

public class Inscription {
	private int etudId;
	private int etudEtab;
	private int etudFil;
	private Date etudInsc;


	public Inscription(int etudId, int etudEtab, int etudFil, Date etudInsc) {
		this.etudId = etudId;
		this.etudEtab = etudEtab;
		this.etudFil = etudFil;
		this.etudInsc = etudInsc;
	}


	@Override
	public String toString() {
		return "{" +
			" etudId='" + getEtudId() + "'" +
			", etudEtab='" + getEtudEtab() + "'" +
			", etudFil='" + getEtudFil() + "'" +
			", etudInsc='" + getEtudInsc() + "'" +
			"}";
	}

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

	public int getEtudFil() {
		return this.etudFil;
	}

	public void setEtudFil(int etudFil) {
		this.etudFil = etudFil;
	}

	public Date getEtudInsc() {
		return this.etudInsc;
	}

	public void setEtudInsc(Date etudInsc) {
		this.etudInsc = etudInsc;
	}

}
