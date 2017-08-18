package poly.service;

import poly.child.Student;
import poly.course.Course;
import poly.parent.Person;

public class ManagerService {
	// ����߰�--��ο�
	public void addPerson(Person person) {
	}

	// ��� ����--�躸��
	public void deletePerson(Person person) {
		
	}

	// id�� Ư������� ã�Ƽ� Person�� ����--��� ����
	public Person findPerson(String personId) {
		return null;
	}

	// Ư������� ������� ã�Ƽ� Person[]�� ����--��� ����
	public Person[] findPerson(char grade) {
		return null;
	}

	// �ش� ���¸� ��� �л�, ��簭�縦 ����--��� ����
	public Person[] findPerson(Course course) {
		return null;
	}

	Course[] c;

	// course�߰�--�ڼ���
	public void createCourse(Course course) {

	}

	// ������û--����
	public void approveCourseApply(Student student, Course course) {

	}

	// ������ ���� �⼮,����,����,�Ἦ-�ּ���
	public void manageAttendance(Student student) {
		int attendCount = 0;
		int lateCount = 0;
		int absentCount = 0;
		int[] temp = student.getAttendance();
		
		for(int i = 0; i < 30; i++){
			switch(temp[i]) {
				case Student.ATTEND: {
					attendCount++;
					break;
				}
				case Student.LATE: {
					lateCount++;
					break;
				}
				case Student.ABSENT: {
					absentCount++;
					break;
				}
			}
		}
		
		System.out.println("-Attendence : " + attendCount +
				"\n-Late : " + lateCount +
				"\n-Absent : " + absentCount);
	}

}
