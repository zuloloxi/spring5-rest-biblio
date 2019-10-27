package fr.epita.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import fr.epita.entite.Livre;

@Repository
@Transactional
public class LivreDAOImpl implements LivreDAO {
   //@PersistenceContext(unitName = "bibliothequePU")
   //EntityManagerFactory emf=Persistence.createEntityManagerFactory("bibliothequePU");
   //EntityManager emFromFactory=emf.createEntityManager();

   //EntityManager em;
	@Autowired
	private SessionFactory sessionFactory;
   /* un facon de determiner l'EntityManager
   EntityManagerFactory=emf=Persistence.createEntityManagerFactory("bibliothequePU");
   //EntityManager emFromFactory=emf.createEntityManager();
   */
	@Override
	public void createLivre(Livre l) {
//	   em=emf.createEntityManager();
//	   try {
//	      em.getTransaction().begin();
//		  em.persist(l);
//		  em.getTransaction().commit();
//	   }
//	   catch (Exception e){
//		   em.getTransaction().rollback();
//		   e.printStackTrace();
//	   }
//		finally
//		{em.close();}
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(l);	   
   }
   
   public Livre findLivre(Long id) {
//	   em=emf.createEntityManager();
//	   return  em.find(Livre.class, id);
		Session currentSession = sessionFactory.getCurrentSession();
		Livre l = currentSession.get(Livre.class, id);
		return l;
   }
}
