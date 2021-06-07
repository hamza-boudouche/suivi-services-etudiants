package structure;

public class ServiceEtud {
	private int etudId;
	private int etudAns;
	private Integer etudBo;
	private Integer etudCu;
	private Integer etudCmb;
	private Integer etudCmbo;

	public ServiceEtud(int etudId, int etudAns, Integer etudBo, Integer etudCu, Integer etudCmb, Integer etudCmbo) {
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

	public Integer getEtudBo() {
		return this.etudBo;
	}

	public void setEtudBo(Integer etudBo) {
		this.etudBo = etudBo;
	}

	public Integer getEtudCu() {
		return this.etudCu;
	}

	public void setEtudCu(Integer etudCu) {
		this.etudCu = etudCu;
	}

	public Integer getEtudCmb() {
		return this.etudCmb;
	}

	public void setEtudCmb(Integer etudCmb) {
		this.etudCmb = etudCmb;
	}

	public Integer getEtudCmbo() {
		return this.etudCmbo;
	}

	public void setEtudCmbo(Integer etudCmbo) {
		this.etudCmbo = etudCmbo;
	}
}
