package com.niit.restsample.dao;

import java.util.List;

import com.niit.restsample.model.Person;

public interface PersonDao {
Person addPerson(Person person);
Person getPerson(int id);
Person updatePerson(Person person);
void deletePerson(int id);
List<Person> getAllPersons();
}