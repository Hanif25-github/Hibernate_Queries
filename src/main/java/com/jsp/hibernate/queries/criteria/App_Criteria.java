package com.jsp.hibernate.queries.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jsp.hibernate.queries.entity.Actor;

public class App_Criteria {
	
public static void main(String[] args) {
	
	
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Actor.class);
	SessionFactory sf = cfg.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tran = session.beginTransaction();
	
	Criteria criteria = session.createCriteria(Actor.class);
	//Where
//	criteria.add(Restrictions.eqOrIsNull("actorId", 101));
//	criteria.add(Restrictions.gt("actorId", 101));
//	criteria.add(Restrictions.lt("actorId", 104));
//	criteria.add(Restrictions.like("actorName", "sajid"));
//	criteria.add(Restrictions.between("actorId", 101, 104));
	
	criteria.setProjection(Projections.property("actorName"));
	List<String> actors = criteria.list();
	for( String actor : actors) {
		System.out.println(actor);
	}
	
	tran.commit();
	session.close();
	sf.close();
}

}
