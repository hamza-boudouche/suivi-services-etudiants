package structure;

public class ServiceEtud {
	private int etudId;
	private int etudAns;
	private int etudBo;
	private int etudCu;
	private int etudCmb;
	private int etudCmbo;

	public ServiceEtud(int etudId, int etudAns, int etudBo, int etudCu, int etudCmb, int etudCmbo) {
		this.etudId = etudId;
		this.etudAns = etudAns;
		this.etudBo = etudBo;
		this.etudCu = etudCu;
		this.etudCmb = etudCmb;
		this.etudCmbo = etudCmbo;
	}

	@Override
	public String toString() {
		return "{" +
			" etudId='" + getEtudId() + "'" +
			", etudAns='" + getEtudAns() + "'" +
			", etudBo='" + getEtudBo() + "'" +
			", etudCu='" + getEtudCu() + "'" +
			", etudCmb='" + getEtudCmb() + "'" +
			", etudCmbo='" + getEtudCmbo() + "'" +
			"}";
	}


	public int getEtudId() {
		return this.etudId;
	}

	public void setEtudId(int etudId) {
		this.etudId = etudId;
	}

	public int getEtudAns() {
		return this.etudAns;
	}

	public void setEtudAns(int etudAns) {
		this.etudAns = etudAns;
	}

	public int getEtudBo() {
		return this.etudBo;
	}

	public void setEtudBo(int etudBo) {
		this.etudBo = etudBo;
	}

	public int getEtudCu() {
		return this.etudCu;
	}

	public void setEtudCu(int etudCu) {
		this.etudCu = etudCu;
	}

	public int getEtudCmb() {
		return this.etudCmb;
	}

	public void setEtudCmb(int etudCmb) {
		this.etudCmb = etudCmb;
	}

	public int getEtudCmbo() {
		return this.etudCmbo;
	}

	public void setEtudCmbo(int etudCmbo) {
		this.etudCmbo = etudCmbo;
	}

}
