package fr.epita.entite;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Exemplaire {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeBarre;
	
	@ManyToOne
	private Livre livre;

	public Long getCodeBarre() {
		return codeBarre;
	}

	public void setCodeBarre(Long codeBarre) {
		this.codeBarre = codeBarre;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	
	

}
