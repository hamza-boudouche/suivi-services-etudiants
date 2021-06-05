package Panes;

import javafx.beans.property.SimpleStringProperty;
import structure.Etudiant;
import structure.ServiceEtud;

public class TableEntry {
	private Etudiant etudiant;
	private ServiceEtud service;
	private SimpleStringProperty idEtudiant;
	private SimpleStringProperty nomPrenomEtudiant;
	private SimpleStringProperty bourse;
	private SimpleStringProperty citeUniv;
	private SimpleStringProperty couvMedic;

	public TableEntry(Etudiant etudiant, ServiceEtud service){
		this.etudiant = etudiant;
		this.service = service;
		this.idEtudiant = new SimpleStringProperty(((Integer) etudiant.getEtudID()).toString()); 
		this.nomPrenomEtudiant = new SimpleStringProperty(etudiant.getEtudNom() + etudiant.getEtudPrenom());
		this.bourse = new SimpleStringProperty(service.getEtudBo() == 0 ? " " : ((Integer) service.getEtudBo()).toString());
		this.citeUniv = new SimpleStringProperty(service.getEtudCu() == 0 ? " " : ((Integer) service.getEtudCu()).toString());
		this.couvMedic = new SimpleStringProperty(service.getEtudBo() == 0 ? " " : ((Integer) service.getEtudBo()).toString());
	}

	public TableEntry(int idEtudiant, String nomPrenomEtudiant, String bourse, String citeUniv, String couvMedic){
		this.idEtudiant = new SimpleStringProperty(((Integer) idEtudiant).toString());
		this.nomPrenomEtudiant = new SimpleStringProperty(nomPrenomEtudiant);
		this.bourse = new SimpleStringProperty(bourse);
		this.citeUniv = new SimpleStringProperty(citeUniv);
		this.couvMedic = new SimpleStringProperty(couvMedic);
	}

	public String getBourse() {
		return bourse.get();
	}

	public String getCiteUniv() {
		return citeUniv.get();
	}

	public String getCouvMedic() {
		return couvMedic.get();
	}

	public String getIdEtudiant() {
		return idEtudiant.get();
	}

	public String getNomPrenomEtudiant() {
		return nomPrenomEtudiant.get();
	}

	public void setBourse(String bourse) {
		this.bourse.set(bourse);
	}

	public void setCiteUniv(String citeUniv) {
		this.citeUniv.set(citeUniv);
	}
	public void setCouvMedic(String couvMedic) {
		this.couvMedic.set(couvMedic);
	}
	public void setIdEtudiant(String idEtudiant) {
		this.idEtudiant.set(idEtudiant);
	}
	public void setNomPrenomEtudiant(String nomPrenomEtudiant) {
		this.nomPrenomEtudiant.set(nomPrenomEtudiant);
	}
}
