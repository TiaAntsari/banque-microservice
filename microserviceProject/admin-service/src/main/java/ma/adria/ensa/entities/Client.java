package ma.adria.ensa.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;
	private String cne;
	private String cin;
	@NotNull
	@Size(min = 2, max = 30)
	private String nom;
	@NotNull
	@Size(min = 2, max = 40)
	private String prenom;
	private Date dateNaissance;
	private String nationalite;
	private String adresse;
	private String tel;
	private String email;

	public Client() {
		super();
	}

	// public Client(@NotNull String cNE, @NotNull String cin, @NotNull @Size(min
	// = 2, max = 30) String nom,
	// @NotNull @Size(min = 2, max = 40) String prenom, Date dateNaissance, String
	// nationalite, String adresse,
	// String tel, String email, Set<Inscription> inscriptions, Set<Passer> passers,
	// Filiere filiere) {
	// super();
	// cne = cNE;
	// this.cin = cin;
	// this.nom = nom;
	// this.prenom = prenom;
	// this.dateNaissance = dateNaissance;
	// this.nationalite = nationalite;
	// this.adresse = adresse;
	// this.tel = tel;
	// this.email = email;
	// this.inscriptions = inscriptions;
	// this.passers = passers;
	// this.filiere = filiere;
	// }

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}