/**
 * 
 * @author Claudia
 *
 *Class extends the Student class
 */
public class LazyStudent extends Student {

	/**
	 * 
	 * Constructs the LazyStudent using the super class
	 * @param nume
	 * @param varsta
	 */
	LazyStudent(String nume, int varsta) {
		super(nume, varsta);
	}

	static final int i=37;
	
	/**
	 * Returning a new hashCode = constant 
	 */
	@Override
	public int hashCode(){
		return 13*i;
		
	}
}
