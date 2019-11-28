package model;

public class GroupDirector extends Teacher{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//relaciones 
	private GroupDirector left;
	private GroupDirector right;
	private int assignedClassroom;
	
	//metodo constructor
	/**
	 * Constructor that instantiates a group director
	 * @param firstName the first name of the group director
	 * @param lastName the last name of the group director
	 * @param id the identification number of the group director
	 * @param left left attribute that identifies this data structure as a binary tree
	 * @param right right attribute that identifies this data structure as a binary tree
	 * @param c number of the classroom to which the group director is assigned
	 */
	public GroupDirector(String firstName, String lastName, int id, Teacher left, Teacher right,int c) {
		super(firstName, lastName, id, left, right);
		left = null;
		right = null;
		assignedClassroom = c;
	}

	//metodos getters y setters
	/**
	 * returns the group director on the left branch
	 * @return group director
	 */
	public GroupDirector getLeft() {
		return left;
	}

	/**
	 * Changes group director on the left branch for the one in the parameters
	 * @param left new group director
	 */
	public void setLeft(GroupDirector left) {
		this.left = left;
	}

	/**
	 * returns the group director on the right branch
	 * @return group director
	 */
	public GroupDirector getRight() {
		return right;
	}

	/**
	 * Changes group director on the right branch for the one in the parameters
	 * @param right new group director
	 */
	public void setRight(GroupDirector right) {
		this.right = right;
	}

	/**
	 * returns number of the classroom to which the group director is assigned
	 * @return number of the assigned classroom
	 */
	public int getAssignedClassroom() {
		return assignedClassroom;
	}

	/**
	 * Changes the number of the classroom to which the group director is assigned for the one in the parameters
	 * @param assignedClassroom assigned classroom
	 */
	public void setAssignedClassroom(int assignedClassroom) {
		this.assignedClassroom = assignedClassroom;
	}
	
	
	
}
