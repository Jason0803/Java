package org.edu.service;

import java.util.ArrayList;
import org.edu.exception.DuplicateSSNException;
import org.edu.exception.RecordNotFoundException;
import org.edu.vo.Employee;
import org.edu.vo.Person;
import org.edu.vo.Student;
import org.edu.vo.Teacher;

public class EducationService {
	private Person[ ] p;
	private int index;
	ArrayList<Person> people = new ArrayList<Person>();
	
	public EducationService(int size){
		p = new Person[size];
	}

	public void addPerson(Person per)throws DuplicateSSNException{
		for(Person person : people) {
			if(person.getSsn() == per.getSsn()) {
				throw new DuplicateSSNException();
			} 
		}
		people.add(per);
	}
	

	public void deletePerson(int ssn)throws RecordNotFoundException{
		boolean found = false;
		for(Person person : people) {
			if(person.getSsn() == ssn) {
				found = true;
				people.remove(person);
				break;
			}
		}
		if(!found) throw new RecordNotFoundException();
		
	}
	
	public Person findPerson(int ssn) throws RecordNotFoundException{
		Person person = null;
		boolean found = false;
		for(Person p : people) {
			if(p.getSsn() == ssn)
				person = p;
				found = true;
		}
		if(!found) {
			throw new RecordNotFoundException();
		} else return person;
	}
	
	public Person[ ] findPerson(String address) throws RecordNotFoundException{
		Person[] parr = null;
		ArrayList<Person> temp = new ArrayList<Person>();
		boolean found = false;
		for(Person p : people) {
			if(p.getAddress().equals(address)) {
				temp.add(p);
				found = true;
			}
		}
		if (!found) throw new RecordNotFoundException();
		else parr = (Person[]) temp.toArray();
		
		return parr;
	}
	
	public void updatePerson(int ssn, Person person) throws RecordNotFoundException{
		boolean found = false;
		for(Person p : people) {
			if(p.getSsn() == ssn) {
				if(person.getSsn() != ssn) throw new RecordNotFoundException();
				found = true;
				p.setAddress(person.getAddress());
				// p.setName(person.getName());
				// p.setBirthDate(person.getBirthDate());
				
				if(person instanceof Employee) {
					Employee e1 = (Employee)p;
					e1.setDept("hi");
					// e1.setDept()
				}
					
			} else throw new RecordNotFoundException();
		}
		
	}	
	public void getPersons(){
		for(Person per : p){
			System.out.println(per);
		}
	}
}


























