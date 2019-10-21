package fr.epita.service;

import fr.epita.entite.Livre;

public interface LivreService {
	
	/**
	 * Cette methode permet d'enregistrer un livre 
	 * dans la base de donnees
	 * @param l le livre a enregistre
	 */
	String enregistrerLivre(Livre l);

}
