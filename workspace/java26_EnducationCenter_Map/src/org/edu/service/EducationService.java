package org.edu.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.edu.exception.DuplicateSSNException;
import org.edu.exception.RecordNotFoundException;
import org.edu.vo.Employee;
import org.edu.vo.Person;
import org.edu.vo.Student;
import org.edu.vo.Teacher;

public class EducationService {
	private HashMap<Integer, Person> map;
	
	public EducationService(int size){
		map = new HashMap<Integer, Person>();
		
	}

	public void addPerson(int ssn, Person p) throws DuplicateSSNException{
		if(map.containsKey(ssn)) {
			throw new DuplicateSSNException();
		} else {
			map.put(ssn, p);
		}
			
	}
	

	public void deletePerson(int ssn)throws RecordNotFoundException{
		if(!(true==map.remove(ssn, map.get(ssn))) ) throw new RecordNotFoundException();
	}
	
	public Person findPerson(int ssn) throws RecordNotFoundException{
		return null;
	}
	
	public Person[ ] findPerson(String address) throws RecordNotFoundException{
		return null;
	}
	
	public void updatePerson(int ssn, Person person) throws RecordNotFoundException{
		
	}	
	public void getPersons(){
		
	}
}


























