package com.library.DAO;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.library.data.entities.Authors;
import com.library.data.entities.Books;

public class DbImpl {

	public static void main(String[] args) {
		
		Books book=new Books();
		Books book1=new Books();
		Authors author1=new Authors();
		Authors author2=new Authors();
		
		author1.setEmail_id("author1@gmail.com");
		author1.setAuthor_name("Gavin King");
		
		author2.setEmail_id("author2@gmail.com");
		author2.setAuthor_name("Tanenbaum");
		
		book.setTitle("Spring in Action");
		book.setIsbn_id(12347);
		book.setYearofpublish(new Date());
		book.setEdition_no("2nd Edition");
		book.getListOfAuthors().add(author1);
		book.getListOfAuthors().add(author2);
		
		book1.setTitle("JavaScript");
		book1.setIsbn_id(12348);
		book1.setYearofpublish(new Date());
		book1.setEdition_no("4th Edition");
		book1.getListOfAuthors().add(author1);
		book1.getListOfAuthors().add(author2);
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(book);
		session.save(book1);
		session.getTransaction().commit();
		session.close();
		
		book=null;
		book1=null;
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		book = 	(Books) session.get(Books.class, 12347);
		book1 =  (Books) session.get(Books.class, 12348);
				
		System.out.println("Name of Book1 is \""+book.getTitle()+"\","+
											",  Author1: "+book.getListOfAuthors().get(0).getAuthor_name()+
											",  Author2 :"+book.getListOfAuthors().get(1).getAuthor_name());
		System.out.println("Name of Book2 is \""+book1.getTitle()+"\","+
											",  Author1: "+book1.getListOfAuthors().get(0).getAuthor_name()+
											",  Author2: "+book1.getListOfAuthors().get(1).getAuthor_name());
		
		session.close();
		
	
	}

}
