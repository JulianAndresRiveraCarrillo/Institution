package model;

import exception.NotFoundException;

public interface SubjectInterface {

	public static Subject searchPrevSubject(Subject root,int id) {
		Subject prev = null;
		Subject actual = root;
		
		while(actual!=null && actual.getId()!=id) {
			prev = actual;
			actual = actual.getNextSubject();
		}
		return actual !=null?prev:null;
	}
	
	
	//erases a Subject
	public static void eraseSubject(Subject root,int id) {
		Subject aux = root;
		try {
			if(aux == null || (aux.getId()!=id&&aux.getNextSubject()==null))
				throw new NotFoundException();
			else if(root.getId()==id)
				root = root.getNextSubject();
			else {
				Subject prev = searchPrevSubject(root,id);
				if(prev==null)
					throw new NotFoundException();
				prev.setNextSubject(prev.getNextSubject().getNextSubject());
			}
		}
		catch(NotFoundException o) {
			System.out.println(o.getMessage());
		}
	}

	//searches a Subject
	public static Subject searchSubject(Subject root,int id) {
		Subject aux = null;
		if(root!=null) {
			aux = root;
			boolean end = false;
			
			while(aux.getNextSubject()!=null && end==false) {
				if(aux.getId()==id) {
					end = true;
				}
				else {
					aux = aux.getNextSubject();
				}
			}
		}
		return aux;
	}
	
	public static void addSubjectStart(Subject root,Subject toAdd) {
		if(root == null) {
			root = toAdd;
		}
		else {
			if(searchSubject(root,toAdd.getId())==null) {
				toAdd.setNextSubject(root);
				root = toAdd;
			}
		}
	}
	
	public static Subject getLastSubject(Subject root) {
		Subject actual = root;
		if(actual !=null) {
			while(actual.getNextSubject() !=null) {
				actual = actual.getNextSubject();
			}
		}
		return actual;
	}
	
	public static void addSubjectEnd(Subject root,Subject toAdd) {
		if(root == null) {
			root = toAdd;
		}
		else {
			if(searchSubject(root,toAdd.getId())==null) {
				getLastSubject(root).setNextSubject(toAdd);
			}
		}
	}
	
	public static void addSubjectAfter(Subject root,int id, Subject toAdd) throws NotFoundException {
		
		if(root == null) {
			root = toAdd;
		}
		else {
			try{
				Subject prev = searchSubject(root, id);
				if(prev==null)
					throw new NotFoundException();
				else{
					toAdd.setNextSubject(prev.getNextSubject());
					prev.setNextSubject(toAdd);
					}
				}
			catch(NotFoundException o) {
				System.out.println(o.getMessage());
			}
		}
	}

	public static void addSubjectBefore(Subject root,int id, Subject toAdd) throws NotFoundException{
		
		if(root == null)
			root = toAdd;
		else {
			Subject aux = root;
			try{
				if(aux==null || aux.getId()!=id&&aux.getNextSubject()==null)
					throw new NotFoundException();
				else if(aux.getId()==id) {
					toAdd.setNextSubject(aux);
					root = toAdd;
				}
			else {
				 while(aux.getNextSubject().getId()==id) {
					 aux = aux.getNextSubject();
				 }
				 toAdd.setNextSubject(aux.getNextSubject());
				 aux.setNextSubject(toAdd);
			 	}
			}
			catch(NotFoundException o) {
				System.out.println(o.getMessage());
			}
		}
	}
}
