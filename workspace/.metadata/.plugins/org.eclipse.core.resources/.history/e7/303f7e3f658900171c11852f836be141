package org.edu.service;

import org.edu.exception.DuplicateSSNException;
import org.edu.exception.RecordNotFoundException;
import org.edu.vo.Employee;
import org.edu.vo.Person;
import org.edu.vo.Student;
import org.edu.vo.Teacher;

public class EducationService {
	private Person[ ] p;
	private int index;
	
	public EducationService(int size){
		p = new Person[size];
	}
	/*
	 * Person의 자식을 배열에 추가하는 로직.
	 * 배열안에 객체를 추가하고 / index는 증가해야 한다.
	 * 만약에 기존의 배열안에 추가하려는 사람이 이미 있다면
	 * 추가가 진행되지 않도록 한다.
	 * DuplicateSSNException을 터뜨린다.
	 */
	public void addPerson(Person per)throws DuplicateSSNException{
		for(int i=0; i<index;i++){
			if(per.getSsn()==p[i].getSsn())//이미 있는 사람이라면
				throw new DuplicateSSNException("이미 그런 사람 있어여");
		}//for
		
		p[index++] = per;
	}
	
	/*
	 * 배열안에 들어있는 특정한 사람을 삭제하는 로직
	 * 이때 삭제하고자하는 사람이 있다면 삭제를 진행...
	 * (이중 for문을 사용해서....)
	 * 만약에 삭제하려고 하는 사람이 없다면
	 * RecoredNotFoundException을 터뜨린다.
	 */
	public void deletePerson(int ssn)throws RecordNotFoundException{
		boolean found = false;
		
		for(int i=0; i<index; i++){
			if(ssn==p[i].getSsn()){//ssn에 해당하는 사람이 있다면
				for(int j=i; j<index-1;j++){
					p[j] = p[j+1];
				}//for
				p[index-1] = null;//추가
				index--;
				found = true;
			}//if
		}//for
		
		if(found==false)//ssn에 해당하는 사람이 없다면
			throw new RecordNotFoundException("삭제할 사람이 없어여");
	}
	/*
	 * ssn을 조건으로 주어 특정한 사람을 찾아서 리턴하는 로직
	 */
	public Person findPerson(int ssn){
		Person person = null;
		for(int i=0; i<index; i++){
			if(ssn==p[i].getSsn())
				person = p[i];
		}//for
		
		return person;
	}
	
	public Person[ ] findPerson(String address){
		Person[ ] parr = new Person[index];//6칸...2칸
		int count = 0;
		
		for(int i=0; i<index; i++){
			if(address.equals(p[i].getAddress())){//주소가 동일한 사람이 있따면
				parr[count++] = p[i];
			}
		}
		return parr;
	}
	/*
	 * 수정할 사람이 없다면 RecordNotFoubndException을 터뜨린다.
	 * ssn은 수정의 대상이 아니다.
	 */
	public void updatePerson(int ssn, Person person)
			throws RecordNotFoundException{//인자값??
		boolean flag = false;		
		for(int i=0; i<index; i++){
			if(ssn==p[i].getSsn()){
				p[i].setName(person.getName());
				p[i].setAddress(person.getAddress());
				if(person instanceof Student){
					Student s = (Student)person;
					s.setStuId(((Student) person).getStuId());
				}
				if(person instanceof Teacher){
					Teacher t = (Teacher)person;
					t.setSubject(((Teacher) person).getSubject());
				}
				if(person instanceof Employee){
					Employee e = (Employee)person;
					e.setDept(((Employee) person).getDept());
				}//if
				flag = true;
			}//if
		}//for
		if(flag==false) throw new RecordNotFoundException("수정할 대상이 없어여");
		
	}	
	public void getPersons(){
		for(Person per : p){
			System.out.println(per);
		}
	}
}


























