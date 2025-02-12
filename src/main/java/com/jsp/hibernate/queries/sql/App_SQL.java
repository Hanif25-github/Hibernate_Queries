package com.jsp.hibernate.queries.sql;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.jsp.hibernate.queries.entity.Actor;


public class App_SQL {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Actor.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		//Fetch Queries
//		NativeQuery<Actor> nq = session.createNativeQuery("Select * FROM actor", Actor.class);
//		List<Actor> actors = nq.list();
//		for(Actor actor: actors) {
//			System.out.println(actor);
//		}

		//Update Operation
//		NativeQuery<Actor> nq = session.createNativeQuery("update actor set actorAge=:age where actorId=:id", Actor.class);
//		nq.setParameter("age", 20);
//		nq.setParameter("id", 103);
//		
//		int rowupdate = nq.executeUpdate();
//		System.out.println(rowupdate + " Data update");
		
		//Delete Operation:
		NativeQuery<Actor> nq = session.createNativeQuery("Delete from actor where actorId =?1", Actor.class);
		nq.setParameter(1, 102);
		
		int rowDeleted = nq.executeUpdate();
		System.out.println(rowDeleted + " data deleted");

		tran.commit();
		sf.close();
		session.close();
	}
}
