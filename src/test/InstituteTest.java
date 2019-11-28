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
		Teacher t2 = new Teacher("Alejandra", "Diaz", 0001, null, null);
		Teacher t = new Teacher("Julian", "Rivera", 0002, null, t2);
		inst.addTeacher(t2);
		inst.addTeacher(t);
	}
	
	void setupScenary2() {
		inst = new Institute("");
		Teacher t2 = new Teacher("Alejandra", "Diaz", 0001, null, null);
		Teacher t = new Teacher("Julian", "Rivera", 2911, null, t2);
		inst.searchTeacher(0001);
		inst.searchTeacher(0002);
		inst.addTeacher(t2);
		inst.addTeacher(t);
	}
	
	void setupScenary3() {
		inst = new Institute("");
		GroupDirector gp = new GroupDirector("Andres", "Diaz", 0120, null, null, 8);
		GroupDirector gp2 = new GroupDirector("Juan", "Arango", 0130, gp, null, 9);
		inst.addGroupDirector(gp);
		inst.addGroupDirector(gp2);
	}
	
	void setupScenary4() {
		inst = new Institute("");
		Student s = new Student("Mafalda", "Gondra", 0123, 10, 3, "3009564851", "Avenida Roosevelt");
		inst.addStudent(s);
		inst.searchStudentByFirstName("Mafalda");
	}
	@Test
	void addTeacherTest() {
		setupScenary1();
		Teacher t2 = new Teacher("Alejandra", "Diaz", 0001, null, null);
		Teacher t = new Teacher("Julian", "Rivera", 0002, null, t2);
		inst.addTeacher(t2);
		inst.addTeacher(t);
		assertTrue(inst.searchTeacher(0001).getFirstName().equalsIgnoreCase(t2.getFirstName()));
		assertTrue(inst.searchTeacher(0002).getFirstName().equalsIgnoreCase(t.getFirstName()));
	}
	
	@Test
	void searchTeacherTest() {
		setupScenary2();
		Teacher t2 = new Teacher("Alejandra", "Diaz", 0101, null, null);
		Teacher t = new Teacher("Julian", "Rivera", 2911, null, t2);
		inst.addTeacher(t2);
		inst.addTeacher(t);
		assertTrue(inst.searchTeacher(0101).getFirstName().equalsIgnoreCase(t2.getLastName()));
		assertTrue(inst.searchTeacher(2911).getFirstName().equalsIgnoreCase(t.getLastName()));
	}
	
	@Test
	void addGroupDirectorTest() {
		setupScenary3();
		GroupDirector gp = new GroupDirector("Andres", "Diaz", 0120, null, null, 8);
		GroupDirector gp2 = new GroupDirector("Juan", "Arango", 0130, gp, null, 9);
		inst.addGroupDirector(gp);
		inst.addGroupDirector(gp2);
		assertTrue(inst.searchTeacher(0120).getLeft() == null);
		assertTrue(inst.searchTeacher(0130).getId() == gp2.getId());
	}
	
	@Test
	void addStudentTest() {
		setupScenary4();
		Student s = new Student("Mafalda", "Gondra", 0123, 10, 3, "3009564851", "Avenida Roosevelt");
		inst.addStudent(s);
		assert(inst.searchStudentByFirstName("Mafalda").getFirstName().equalsIgnoreCase(s.getFirstName()));
	}
}
