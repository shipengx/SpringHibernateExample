package com.shipeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.shipeng.entity.Contact;
import com.shipeng.model.dao.ContactDAO;
import com.shipeng.model.dao.impl.ContactDAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


@Controller
public class ContactController {

	@Autowired
	@Qualifier("ContactDaoImpl")
	private ContactDAO ContactDAOImpl;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(Model model) {
	        
		Contact contact = new Contact();
		model.addAttribute("contactForm", contact);

                /*	
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
 
		for (int i = 21; i< 30; i++) {
	    	    Contact contact = new Contact("Shipeng"+i,"shipeng"+i+"@gmail.com","programmer"+i);
		    session.save(contact);
		}//end for loop
		
		session.getTransaction().commit();
		session.close();
		*/

		//for display
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;
	}

	@RequestMapping(value="/addContact", method = RequestMethod.POST)
	public String addContact (@ModelAttribute("contactForm")Contact contact, ModelMap model) {
	
		ContactDAOImpl.addContact(contact);
		System.out.println(contact.getName());
		System.out.println(contact.getEmail());
		System.out.println(contact.getProfession());
	
		model.addAttribute("name",contact.getName());
		model.addAttribute("email",contact.getEmail());
		model.addAttribute("profession",contact.getProfession());
		return "result";		
	}


}




