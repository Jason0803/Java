package poly.service;

import java.util.Scanner;

import poly.child.Student;
import poly.course.Course;
import poly.parent.Person;

public class ManagerService {

// ------------------------------ 학생추가 (보경) [OK]  ----------------------------- //
		public void addPerson(Person[] people, Person person) {
			int count = 0;
			for (int i = 0; i < people.length; i++) {
				if (people[i].equals(null)) {
					continue;
				} else {
					count++;
				}
			} // for
			people[count] = person;
			System.out.println(people + "이(가) 성공적으로 추가되었습니다.");
		}

// ------------------------------ 학생삭제 (보경) [OK]  ----------------------------- //
		public void deletePerson(Person[] people, Person person) {
			int index = 0;

			for (int i = 0; i < people.length; i++) {
				if (people[i].equals(null)) {
					for (int j = 0; j < people.length - 1; j++) {
						people[j] = people[j + 1];
						break;
					}
					continue;
				}
			} // for
			//System.out.println(people + "이(가) 성공적으로 삭제되었습니다.");

		}

// ------------------------------ 코스추가 (세진) [OK]  ----------------------------- //
		public void createCourse(Course[] courses, Course course) {
		 int count = 0;
		 for (int i = 0; i < courses.length; i++) {
		  if (courses[i].getTitle().equals("")) {
		   continue;
		  } else {
		   count++;
		  }
		 }
		 courses[count] = course;
		 System.out.println("강좌"+ course.getTitle() +"이(가) 성공적으로 등록되었습니다.");
	 }

// ----------------------------- 코스삭제 (기쁨) [OK]  ------------------------------- //
	 public void deleteCourse(Course[] courses, Course course) {
	  int index = 0 ;
	  for (int i = 0; i < courses.length; i++) {
	   if (courses[i].equals(null)) {
	    for (int j = 0; j < courses.length-1; j++) {
	     courses[j] = courses[j+1];
	     break;
	    }
	    continue;
	   }
	  }
	  System.out.println("강좌" + course +"이(가) 성공적으로 삭제되었습니다.");
	 }

// ----------------------- Manager : findPerson 3가지 [NOK]  ----------------------- //

	public Person findPerson(String personId) {
		return null;
	}

	public Person[] findPerson(char grade) {
		return null;
	}

	public Person[] findPerson(Course course) {
		return null;
	}

	Course[] c; // ? 이거 뭐지


// --------------------------- Manager : 수강신청 수락 [NOK]  --------------------------- //
	public void approveCourseApply(Student student, Course course) {
	  // 학생의 수강신청을 승인하는 기능 (Y/N)
	  Scanner scan = new Scanner(System.in);
	  System.out.println(student.getName()+"의 "+course.getTitle()+" 강좌 수강신청을 승인하시겠습니까? (y/n)\n>>");
		 if(scan.nextLine().equals("y")) {
		  student.setCourse(course);
		  System.out.println("승인되었습니다.");
		  return;
		 }
		 System.out.println("거절되었습니다.");
	}

// --------------------------- 학생 : 출결 기록 -- 수영 [OK]  --------------------------- //
	public void inputRandomAttendance(Student[] students){
		int randomIndex = 0;
		int temp[] = new int[30];
		for (int i = 0; i < students.length; i++){
			temp = new int[30];
			for(int j = 0; j < 30; j++){
				randomIndex = (int)((Math.random()*10 + 1))%3;
				temp[j] = randomIndex;
			}
			students[i].setAttendance(temp);
		}
	}
	// ------------------------------------ 출력용 ------------------------------------ //
	public void countAttendance(Student student) {
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
		
		System.out.println("Student : " + student.getName() + 
				"\n-Attendence : " + attendCount +
				"\n-Late : " + lateCount +
				"\n-Absent : " + absentCount +"\n");
	}
	
	// ------------------------------------ 본 메소드 ------------------------------------ //
	public void manageAttendance(Student[] students) throws InterruptedException{
		int attendCount;
		int lateCount;
		System.out.println("학생 출결 정보 기입 중...");

		//학생들에게 정보 기입 
		inputRandomAttendance(students);
		
		// 3초있다가 표현
		Thread.sleep(3000);

		
		for(Student student : students)
			countAttendance(student);
		
		
		// 제적 기준 : 출석률 70%미만 ( ** scanner 로 수정 예정 ** ) //
		System.out.println("\n제적 될 학생 목록 입니다..");
		for(Student stu : students){
			int[] temp = stu.getAttendance();
			attendCount = 0;
			lateCount = 0;
			for(int i = 0 ; i < 30; i++){
				if(temp[i] == 0) {
					attendCount++;
				} else if(temp[i] == 1){
					lateCount++;
				}
			}
			// 이부분만 정의하면 적정 수준 결석사람 보여
			if ( (attendCount + lateCount*0.5) <= 12 ){
				System.out.println("-" + stu.getName() );
				deletePerson(students, stu);
			}
		}
	}
	// ----------------- 객체 생성 시, instanceof로 적절히 배열에 넣음[NOK]  ------------------- //
	
}