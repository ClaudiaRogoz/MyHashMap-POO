/**
 * 
 * @author Claudia
 *
 *
 *Implementing a basic Student class
 */
public class Student {
	String nume;
	int varsta;
	
	/**
	 * Constructs a Student based on the information given
	 *  
	 * @param nume the name of the Student
	 * @param varsta The age of the Student 
	 */
	Student(String nume, int varsta){
		this.nume = nume;
		this.varsta = varsta;
	}
	
	/**
	 * Overriding the hahsCode based on the given instructions
	 * 
	 * @return the computed hashCode
	 */
	 @Override
	    public int hashCode() {
	        int hash = 17;
	        hash = hash * 37 + nume.hashCode();
	        hash = hash * 37 + varsta;
	        return hash;
	    }
	 
	 /**
	  * Overriding equals method
	  * 
	  * @param obj The Object to be compared with the current Studnet  
	  * @return false or true 
	  */
	@Override 
	 public boolean equals( Object obj )
		{
			boolean ok = false;
			Student stud = ( Student )obj;
			if( stud.nume == nume )
				ok = true;
			return ok;
		}
	
	/**
	 * Overriding the toString method
	 * 
	 * 
	 * @return the info for the current Student 
	 */
	@Override
	public String toString(){
		
		return (nume+" " + varsta);
		
	}
}
