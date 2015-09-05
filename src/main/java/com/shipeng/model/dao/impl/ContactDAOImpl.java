package com.shipeng.model.dao.impl;

import com.shipeng.model.dao.ContactDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.shipeng.entity.Contact;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.transaction.annotation.Transactional;


@Repository("ContactDaoImpl")
@Transactional
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addContact(Contact contact) {
		System.out.println("it's hehrere.");
		
		try {
			/*
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			*/

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(contact);

			session.getTransaction().commit();
			session.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}//end addContact

}//end class


