package com.jsp.hibernate.queries.criteriabuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.queries.entity.Actor;

public class App_CroteriaBulder_Update {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Actor.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		//Builder 
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		//update query construction
		CriteriaUpdate<Actor> cu = cb.createCriteriaUpdate(Actor.class);
		Root<Actor> root = cu.from(Actor.class);
		cu.set(root.get("actorAge"), 50);
		cu.where(cb.equal(root.get("actorId"), 103));
		
		//Query Execution
		  
		 Query<Actor> query = session.createQuery(cu);
		 int rowsUpdates = query.executeUpdate();
		 System.out.print(rowsUpdates + "data updated");
		
		 
		 tran.commit();
		 session.close();
		 sf.close();
		
	}
}
