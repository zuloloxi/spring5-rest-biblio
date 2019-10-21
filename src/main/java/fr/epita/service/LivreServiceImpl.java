package fr.epita.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import fr.epita.dao.LivreDAO;
import fr.epita.entite.Livre;

@Service
public class LivreServiceImpl implements LivreService{
	
	@Autowired
	LivreDAO livreDAO;
	
	public String enregistrerLivre(Livre l) {
		livreDAO.createLivre(l);
		return "SUCCESS";
		//LivreDAOImpl l=new LivreDAOImpl();
		//System.out.println("On est dans la couche service");
		
	}

}
