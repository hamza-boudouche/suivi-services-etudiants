package Panes;

import javafx.beans.property.SimpleStringProperty;
import structure.ServiceEtud;

public class ServiceEtudTableEntry {
	private ServiceEtud service;
	private SimpleStringProperty etudid = new SimpleStringProperty();
	private SimpleStringProperty etudans = new SimpleStringProperty();
	private SimpleStringProperty etudbo = new SimpleStringProperty();
	private SimpleStringProperty etudcu = new SimpleStringProperty();
	private SimpleStringProperty etudcmb = new SimpleStringProperty();
	private SimpleStringProperty etudcmbo = new SimpleStringProperty();
	
	public ServiceEtudTableEntry(ServiceEtud service){
		this.service = service;
		this.etudans.set(((Integer)service.getEtudAns()).toString());
		this.etudbo.set(((Integer)service.getEtudBo()).toString());
		this.etudcmb.set(((Integer)service.getEtudCmb()).toString());
		this.etudcmbo.set(((Integer)service.getEtudCmbo()).toString());
		this.etudcu.set(((Integer)service.getEtudCu()).toString());
		this.etudid.set(((Integer)service.getEtudId()).toString());
	}

	public ServiceEtud getService() {
		return service;
	}

	public String getEtudans() {
		return etudans.get();
	}

	public String getEtudbo() {
		return etudbo.get();
	}

	public String getEtudcmb() {
		return etudcmb.get();
	}

	public String getEtudcmbo() {
		return etudcmbo.get();
	}

	public String getEtudcu() {
		return etudcu.get();
	}

	public String getEtudid() {
		return etudid.get();
	}
}
