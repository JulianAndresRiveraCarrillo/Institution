package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import model.Institute;
import model.Student;
import model.Teacher;
import model.GroupDirector;
class InstituteTest {
	
	private Institute inst;
	
	void setupScenary1() {
		inst = new Institute("");
		Teacher t2 = new Teacher("Julian", "Rivera", 0002, null, null);
		Teacher t = new Teacher("Alejandra", "Diaz", 0001, null, t2);
		inst.setTeachersInThisInstitute(t);
	}
	
	void setupScenary2() {
		inst = new Institute("");
		
		Teacher t = new Teacher("Julien", "Rivera", 0002, null, null);
		Teacher t2 = new Teacher("Alejandra", "Diaz", 0001, null, null);
		inst.setTeachersInThisInstitute(t2);
		inst.getTeachersInThisInstitute().setRight(t);
	}
	
	void setupScenary3() {
		inst = new Institute("");
		GroupDirector gp = new GroupDirector("Andres", "Diaz", 0120, null, null, 8);
		GroupDirector gp2 = new GroupDirector("Juan", "Arango", 0130, null, null, 9);
		inst.addGroupDirector(gp);
		inst.addGroupDirector(gp2);
	}
	
	void setupScenary4() {
		inst = new Institute("");
		Student s = new Student("Mafalda", "Gondra", 0123, 10, 3, "3009564851", "Avenida Roosevelt");
		inst.addStudent(s);
	}
	
	@Test
	void addTeacherTest() {
		setupScenary1();
		assertTrue(inst.searchTeacher(0001).getFirstName().equalsIgnoreCase("Alejandra"));
		assertTrue(inst.searchTeacher(0002).getFirstName().equalsIgnoreCase("Julian"));
	}
	
	@Test
	void searchTeacherTest() {
		setupScenary2();
		assertTrue(inst.searchTeacher(0001).getFirstName().equals("Alejandra"));
		assertTrue(inst.searchTeacher(0002).getLastName().equals("Rivera"));
	}
	
	@Test
	void addGroupDirectorTest() {
		setupScenary3();
		assertTrue(inst.searchTeacher(0120).getLeft() == null);
		assertTrue(inst.searchTeacher(0130).getFirstName().equals("Juan"));
	}
	
	@Test
	void addStudentTest() {
		Institute inst = new Institute("");
		Student s = new Student("Mafalda", "Gondra", 0123, 10, 3, "3009564851", "Avenida Roosevelt");
		inst.addStudent(s);
		assert(inst.searchStudentByFirstName("Mafalda").getFirstName().equalsIgnoreCase(s.getFirstName()));
	}
}
