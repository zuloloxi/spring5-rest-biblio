package fr.epita.entite;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Livre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLivre;
	
	
	private String titre;
	private String emplacement;
	private Date parution;
	private String lang;
	
	@OneToMany
	private List<Exemplaire> exemplaires;
	
	@ManyToOne
	private Categorie categorie;
	
	@ManyToMany
	private List<Auteur> auteurs;
	
	
	
	
	public Long getIdLivre() {
		return idLivre;
	}
	public void setIdLivre(Long id) {
		this.idLivre = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public Date getParution() {
		return parution;
	}
	public void setParution(Date parution) {
		this.parution = parution;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}
	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<Auteur> getAuteurs() {
		return auteurs;
	}
	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}
	
	
}
