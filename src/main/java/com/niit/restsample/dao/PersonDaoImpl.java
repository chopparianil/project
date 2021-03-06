package com.niit.restsample.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.restsample.model.Person;
@Repository
public class PersonDaoImpl implements PersonDao{
@Autowired
private SessionFactory sessionFactory;

	public Person addPerson(Person person) {
		Session session=sessionFactory.openSession();
		session.save(person);
		session.flush();
		session.close();
		return person;
	}

	public Person getPerson(int id) {
		Session session=sessionFactory.openSession();
		Person person=(Person)session.get(Person.class, id);
		session.close();
		return person;
	}

	public Person updatePerson(Person person) {
		//update
		Session session=sessionFactory.openSession();
		session.update(person);
		session.flush();
		//select for the same person id
		Person updatedPerson=(Person)session.get(Person.class, person.getId());
		session.close();
		return updatedPerson;
	}

	public void deletePerson(int id) {
		Session session=sessionFactory.openSession();
		// select * from person where id=155
		Person person=(Person)session.get(Person.class, id);
		//delete from person where id=155
		session.delete(person);
		session.flush();
		session.close();
	}

	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Person");
		List<Person> persons=query.list();
		session.close();
		return persons;
	}
	

}

