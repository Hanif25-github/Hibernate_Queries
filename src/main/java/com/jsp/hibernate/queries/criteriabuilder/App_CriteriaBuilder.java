package com.jsp.hibernate.queries.criteriabuilder;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.queries.entity.Actor;


public class App_CriteriaBuilder {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Actor.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		//Builder 
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		//Query Construction select root from actor as root
//		CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
//		cq.from(Actor.class);
				
		
		//Query Construction 2nd way select root from actor as root where root.actorId=101
//		CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
//		Root<Actor> root = cq.from(Actor.class);
//		cq.select(root.get("actorId"));
		
		
		CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
		Root<Actor> root = cq.from(Actor.class); //it mostly remains same generic type
		cq.select(root);
//		cq.where(cb.equal(root.get("actorId"), 101));
//		cq.where(cb.like(root.get("actorName"), "hanif"));
//		cq.where(cb.between(root.get("actorId"), 101, 104));
//		cq.where(cb.lt(root.get("actorId"), 104));
		cq.where(cb.gt(root.get("actorId"), 101));
		
		
		//Query Execution
		Query<Actor> query = session.createQuery(cq);
		List<Actor> actors = query.list();
		for( Actor actor : actors) {
			System.out.println(actor);
		}
		
		
		tran.commit();
		session.clear();
		sf.close();
		
		
		
	}

}
