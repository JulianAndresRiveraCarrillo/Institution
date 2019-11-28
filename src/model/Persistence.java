package model;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Persistence {

	void readObject()throws FileNotFoundException, IOException ;
	
	void writeObject()throws FileNotFoundException, IOException, ClassNotFoundException, EOFException;
}
