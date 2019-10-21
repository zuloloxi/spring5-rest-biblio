package fr.epita.dao;

import fr.epita.entite.Livre;

public interface LivreDAO {
	public void createLivre(Livre l); 
	public Livre findLivre(Long id);
}
