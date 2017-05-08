package com.library.DAO;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.library.data.entities.Authors;
import com.library.data.entities.Books;
import com.library.data.entities.UserDetails;
import com.library.data.entities.Vehicles;

public class UserVehicleImpl {

	public static void main(String[] args) {
		
		UserDetails user1=new UserDetails();
		UserDetails user2=new UserDetails();
		Vehicles vehicle1=new Vehicles();
		Vehicles vehicle2=new Vehicles();
		Vehicles vehicle3=new Vehicles();
		
		user1.setUsername("First User");
		user2.setUsername("Second User");
	    
		vehicle1.setVehicleName("Hyundai Verna");
		vehicle2.setVehicleName("Maruti Ciaz");
		vehicle3.setVehicleName("Volkswagen Vento");
		
		user1.getVehicle().add(vehicle1);
		user1.getVehicle().add(vehicle2);
		vehicle1.setUser(user1);
        vehicle2.setUser(user1);
        vehicle3.setUser(user2);
              		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(vehicle3);
		
		session.getTransaction().commit();
		session.close();
			
		session=sessionFactory.openSession();
		session.beginTransaction();
		user1 = 	(UserDetails) session.get(UserDetails.class, 1);
		System.out.println("Username before modification:"+user1.getUsername());
		user1.setUsername("Modified First User");
		session.update(user1);
		session.getTransaction().commit();
		session.close();
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		user1 = 	(UserDetails) session.get(UserDetails.class, 1);
		System.out.println("Username after modification:"+user1.getUsername());
			
					
		session.close();

	}

}
