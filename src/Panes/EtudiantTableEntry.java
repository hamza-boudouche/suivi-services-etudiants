package Panes;

import javafx.beans.property.SimpleStringProperty;
import structure.Etudiant;

public class EtudiantTableEntry {
	private Etudiant etudiant;
	private SimpleStringProperty etudid = new SimpleStringProperty();
	private SimpleStringProperty etudcne = new SimpleStringProperty();
	private SimpleStringProperty etudnom = new SimpleStringProperty();
	private SimpleStringProperty etudprenom = new SimpleStringProperty();
	private SimpleStringProperty etudsfam = new SimpleStringProperty();
	private SimpleStringProperty etudnat = new SimpleStringProperty();
	private SimpleStringProperty etudnai = new SimpleStringProperty();
	private SimpleStringProperty etudesexe = new SimpleStringProperty();
	private SimpleStringProperty etudad1 = new SimpleStringProperty();
	private SimpleStringProperty etudcps = new SimpleStringProperty();
	private SimpleStringProperty etudvil = new SimpleStringProperty();
	private SimpleStringProperty etuddpt = new SimpleStringProperty();
	private SimpleStringProperty etudtel = new SimpleStringProperty();
	private SimpleStringProperty etudmail = new SimpleStringProperty();
	private SimpleStringProperty etudrib = new SimpleStringProperty();
	private SimpleStringProperty cniepere = new SimpleStringProperty();
	private SimpleStringProperty etudnomp = new SimpleStringProperty();
	private SimpleStringProperty etudprep = new SimpleStringProperty();
	private SimpleStringProperty etuddnp = new SimpleStringProperty();
	private SimpleStringProperty etudddp = new SimpleStringProperty();
	private SimpleStringProperty cniemere = new SimpleStringProperty();
	private SimpleStringProperty etudnomm = new SimpleStringProperty();
	private SimpleStringProperty etudprem = new SimpleStringProperty();
	private SimpleStringProperty etuddnm = new SimpleStringProperty();
	private SimpleStringProperty etudddm = new SimpleStringProperty();

	public EtudiantTableEntry(Etudiant etudiant){
		this.etudiant = etudiant;
		this.etudid.set(((Integer) etudiant.getEtudID()).toString());
		this.etudcne.set(etudiant.getEtudCne());
		this.etudnom.set(etudiant.getEtudNom());
		this.etudprenom.set(etudiant.getEtudPrenom());
		this.etudsfam.set(etudiant.getEtudsFam());
		this.etudnat.set(etudiant.getEtudNat());
		this.etudnai.set(etudiant.getEtudNai().toString());
		this.etudesexe.set(etudiant.getEtudSex());
		this.etudad1.set(etudiant.getEtudad1());
		this.etudcps.set(((Integer)etudiant.getEtudCps()).toString());
		this.etudvil.set(etudiant.getEtudVil());
		this.etuddpt.set(((Integer)etudiant.getEtudDpt()).toString());
		this.etudtel.set(etudiant.getEtudTel());
		this.etudmail.set(etudiant.getEtudMail());
		this.etudrib.set(etudiant.getEtudRib());
		this.cniepere.set(etudiant.getCniePere());
		this.etudnomp.set(etudiant.getEtudNomP());
		this.etudprep.set(etudiant.getEtudPreP());
		this.etuddnp.set(etudiant.getEtudDNP().toString());
		this.etudddp.set(etudiant.getEtudDDP() != null ? etudiant.getEtudDDP().toString() : " ");
		this.cniemere.set(etudiant.getCnieMere());
		this.etudnomm.set(etudiant.getEtudNomM());
		this.etudprem.set(etudiant.getEtudPreM());
		this.etuddnm.set(etudiant.getEtudDNM().toString());
		this.etudddm.set(etudiant.getEtudDDM() != null ? etudiant.getEtudDDM().toString() : " ");
	}

	
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public String getCniemere() {
		return cniemere.get();
	}

	public String getCniepere() {
		return cniepere.get();
	}

	public String getEtudad1() {
		return etudad1.get();
	}

	public String getEtudcne() {
		return etudcne.get();
	}

	public String getEtudcps() {
		return etudcps.get();
	}

	public String getEtudddm() {
		return etudddm.get();
	}

	public String getEtudddp() {
		return etudddp.get();
	}

	public String getEtuddnm() {
		return etuddnm.get();
	}

	public String getEtuddnp() {
		return etuddnp.get();
	}

	public String getEtuddpt() {
		return etuddpt.get();
	}

	public String getEtudesexe() {
		return etudesexe.get();
	}

	public String getEtudid() {
		return etudid.get();
	}

	public String getEtudmail() {
		return etudmail.get();
	}

	public String getEtudnai() {
		return etudnai.get();
	}

	public String getEtudnat() {
		return etudnat.get();
	}

	public String getEtudnom() {
		return etudnom.get();
	}

	public String getEtudnomm() {
		return etudnomm.get();
	}

	public String getEtudnomp() {
		return etudnomp.get();
	}

	public String getEtudprem() {
		return etudprem.get();
	}

	public String getEtudprenom() {
		return etudprenom.get();
	}

	public String getEtudprep() {
		return etudprep.get();
	}

	public String getEtudrib() {
		return etudrib.get();
	}

	public String getEtudsfam() {
		return etudsfam.get();
	}

	public String getEtudtel() {
		return etudtel.get();
	}

	public String getEtudvil() {
		return etudvil.get();
	}
}
