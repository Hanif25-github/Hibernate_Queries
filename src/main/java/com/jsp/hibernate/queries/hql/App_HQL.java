package com.jsp.hibernate.queries.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.queries.entity.Actor;

public class App_HQL 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Actor.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		// Fetch Queries
      Query<String> query = session.createQuery("Select a.actorName FROM Actor a");
      List<String> actors = query.list();
      for(String actor: actors) {
      	System.out.println(actor);
      }

		
		// Update Queries
//      Query<String> query = session.createQuery("UPDATE Actor a SET a.actorAge=87 WHERE a.actorId=101");
//      int rowUpdated = query.executeUpdate();
//      System.out.println(rowUpdated+"  row updated !!");
		
		
		// In Update i am using placeholder 2 types are there 1.is(?1 || ?2) && (:Key || :value)
//				Query<String> query = session.createQuery("UPDATE Actor a SET a.actorAge=?1 WHERE a.actorId=:Id");
//				query.setParameter(1, 45);
//				query.setParameter("Id", 105);
//				int rowUpdated = query.executeUpdate();
//				System.out.println(rowUpdated + "  row updated !!");
		
		// Delete Queries
//      Query<String> query = session.createQuery("DELETE Actor a WHERE a.actorId=104");
//      int rowUpdated = query.executeUpdate();
//      System.out.println(rowUpdated+"  Data Deleted !!");

		// Insertion is not possible it will throw exception!!!!!
		// to use insertion we will use direct inbuild method of hibernate [save()]

		tran.commit();
		sf.close();
		session.close();
        
    }
}
