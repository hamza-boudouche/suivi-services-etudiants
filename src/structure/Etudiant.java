package structure;

import java.sql.Date;

public class Etudiant {
	private int etudID;
	private String etudCne;
	private String etudNom;
	private String etudPrenom;
	private String etudsFam;
	private String etudNat;
	private Date etudNai;
	private String etudSex;
	private String etudad1;
	private Integer etudCps;
	private String etudVil;
	private Integer etudDpt;
	private String etudTel;
	private String etudMail;
	private String etudRib;
	private String cniePere;
	private String etudNomP;
	private String etudPreP;
	private Date etudDNP;
	private Date etudDDP;
	private String cnieMere;
	private String etudNomM;
	private String etudPreM;
	private Date etudDNM;
	private Date etudDDM;


	public Etudiant(int etudID, String etudCne, String etudNom, String etudPrenom, String etudsFam, String etudNat, Date etudNai, String etudSex, String etudad1, Integer etudCps, String etudVil, Integer etudDpt, String etudTel, String etudMail, String etudRib, String cniePere, String etudNomP, String etudPreP, Date etudDNP, Date etudDDP, String cnieMere, String etudNomM, String etudPreM, Date etudDNM, Date etudDDM) {
		this.etudID = etudID;
		this.etudCne = etudCne;
		this.etudNom = etudNom;
		this.etudPrenom = etudPrenom;
		this.etudsFam = etudsFam;
		this.etudNat = etudNat;
		this.etudNai = etudNai;
		this.etudSex = etudSex;
		this.etudad1 = etudad1;
		this.etudCps = etudCps;
		this.etudVil = etudVil;
		this.etudDpt = etudDpt;
		this.etudTel = etudTel;
		this.etudMail = etudMail;
		this.etudRib = etudRib;
		this.cniePere = cniePere;
		this.etudNomP = etudNomP;
		this.etudPreP = etudPreP;
		this.etudDNP = etudDNP;
		this.etudDDP = etudDDP;
		this.cnieMere = cnieMere;
		this.etudNomM = etudNomM;
		this.etudPreM = etudPreM;
		this.etudDNM = etudDNM;
		this.etudDDM = etudDDM;
	}

	@Override
	public String toString() {
		return "{" +
			" etudID='" + getEtudID() + "'" +
			", etudCne='" + getEtudCne() + "'" +
			", etudNom='" + getEtudNom() + "'" +
			", etudPrenom='" + getEtudPrenom() + "'" +
			"}";
	}

	public int getEtudID() {
		return this.etudID;
	}

	public void setEtudID(int etudID) {
		this.etudID = etudID;
	}

	public String getEtudCne() {
		return this.etudCne;
	}

	public void setEtudCne(String etudCne) {
		this.etudCne = etudCne;
	}

	public String getEtudNom() {
		return this.etudNom;
	}

	public void setEtudNom(String etudNom) {
		this.etudNom = etudNom;
	}

	public String getEtudPrenom() {
		return this.etudPrenom;
	}

	public void setEtudPrenom(String etudPrenom) {
		this.etudPrenom = etudPrenom;
	}

	public String getEtudsFam() {
		return this.etudsFam;
	}

	public void setEtudsFam(String etudsFam) {
		this.etudsFam = etudsFam;
	}

	public String getEtudNat() {
		return this.etudNat;
	}

	public void setEtudNat(String etudNat) {
		this.etudNat = etudNat;
	}

	public Date getEtudNai() {
		return this.etudNai;
	}

	public void setEtudNai(Date etudNai) {
		this.etudNai = etudNai;
	}

	public String getEtudSex() {
		return this.etudSex;
	}

	public void setEtudSex(String etudSex) {
		this.etudSex = etudSex;
	}

	public String getEtudad1() {
		return this.etudad1;
	}

	public void setAtudad1(String atudad1) {
		this.etudad1 = atudad1;
	}

	public Integer getEtudCps() {
		return this.etudCps;
	}

	public void setEtudCps(Integer etudCps) {
		this.etudCps = etudCps;
	}

	public String getEtudVil() {
		return this.etudVil;
	}

	public void setEtudVil(String etudVil) {
		this.etudVil = etudVil;
	}

	public Integer getEtudDpt() {
		return this.etudDpt;
	}

	public void setEtudDpt(Integer etudDpt) {
		this.etudDpt = etudDpt;
	}

	public String getEtudTel() {
		return this.etudTel;
	}

	public void setEtudTel(String etudTel) {
		this.etudTel = etudTel;
	}

	public String getEtudMail() {
		return this.etudMail;
	}

	public void setEtudMail(String etudMail) {
		this.etudMail = etudMail;
	}

	public String getEtudRib() {
		return this.etudRib;
	}

	public void setEtudRib(String etudRib) {
		this.etudRib = etudRib;
	}

	public String getCniePere() {
		return this.cniePere;
	}

	public void setCniePere(String cniePere) {
		this.cniePere = cniePere;
	}

	public String getEtudNomP() {
		return this.etudNomP;
	}

	public void setEtudNomP(String etudNomP) {
		this.etudNomP = etudNomP;
	}

	public String getEtudPreP() {
		return this.etudPreP;
	}

	public void setEtudPreP(String etudPreP) {
		this.etudPreP = etudPreP;
	}

	public Date getEtudDNP() {
		return this.etudDNP;
	}

	public void setEtudDNP(Date etudDNP) {
		this.etudDNP = etudDNP;
	}

	public Date getEtudDDP() {
		return this.etudDDP;
	}

	public void setEtudDDP(Date etudDDP) {
		this.etudDDP = etudDDP;
	}

	public String getCnieMere() {
		return this.cnieMere;
	}

	public void setCnieMere(String cnieMere) {
		this.cnieMere = cnieMere;
	}

	public String getEtudNomM() {
		return this.etudNomM;
	}

	public void setEtudNomM(String etudNomM) {
		this.etudNomM = etudNomM;
	}

	public String getEtudPreM() {
		return this.etudPreM;
	}

	public void setEtudPreM(String etudPreM) {
		this.etudPreM = etudPreM;
	}

	public Date getEtudDNM() {
		return this.etudDNM;
	}

	public void setEtudDNM(Date etudDNM) {
		this.etudDNM = etudDNM;
	}

	public Date getEtudDDM() {
		return this.etudDDM;
	}

	public void setEtudDDM(Date etudDDM) {
		this.etudDDM = etudDDM;
	}

}
