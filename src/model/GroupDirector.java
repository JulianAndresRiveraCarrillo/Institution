package model;

public class GroupDirector extends Teacher{

	//relaciones 
	private GroupDirector left;
	private GroupDirector right;
	private int assignedClassroom;
	
	//metodo constructor
	public GroupDirector(String firstName, String lastName, int id, Teacher left, Teacher right,int c) {
		super(firstName, lastName, id, left, right);
		left = null;
		right = null;
		assignedClassroom = c;
	}

	//metodos getters y setters
	public GroupDirector getLeft() {
		return left;
	}

	public void setLeft(GroupDirector left) {
		this.left = left;
	}

	public GroupDirector getRight() {
		return right;
	}

	public void setRight(GroupDirector right) {
		this.right = right;
	}

	public int getAssignedClassroom() {
		return assignedClassroom;
	}

	public void setAssignedClassroom(int assignedClassroom) {
		this.assignedClassroom = assignedClassroom;
	}
	
	
	
}
