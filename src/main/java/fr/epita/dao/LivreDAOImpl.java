package fr.epita.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import fr.epita.entite.Livre;

@Repository
public class LivreDAOImpl implements LivreDAO {
   @PersistenceContext(unitName = "bibliothequePU")
   EntityManagerFactory emf=Persistence.createEntityManagerFactory("bibliothequePU");
   //EntityManager emFromFactory=emf.createEntityManager();

   EntityManager em;
   
   /* un facon de determiner l'EntityManager
   EntityManagerFactory=emf=Persistence.createEntityManagerFactory("bibliothequePU");
   //EntityManager emFromFactory=emf.createEntityManager();
   */
   public void createLivre(Livre l) {
	   em=emf.createEntityManager();
	   try {
	      em.getTransaction().begin();
		  em.persist(l);
		  em.getTransaction().commit();
	   }
	   catch (Exception e){
		   em.getTransaction().rollback();
		   e.printStackTrace();
	   }
		finally
		{em.close();}
   }
   
   public Livre findLivre(Long id) {
	   em=emf.createEntityManager();
	   return  em.find(Livre.class, id);
   }
}
