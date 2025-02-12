package com.jsp.hibernate.queries.criteriabuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.queries.entity.Actor;

public class App_CriteriaBulder_Delete {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Actor.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		//Builder
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		//Delete query construction
		CriteriaDelete<Actor> cd = cb.createCriteriaDelete(Actor.class);
		Root<Actor> root = cd.from(Actor.class);
		cd.where(cb.equal(root.get("actorAge"), 50));
		
		//Query Execution
		Query<Actor> query = session.createQuery(cd);
		int rowsDeleted = query.executeUpdate();
		System.out.println(rowsDeleted + "Data deleted");
		
		tran.commit();
		session.close();
		sf.close();
		
	}
	
}
