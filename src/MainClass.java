
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Claudia
 *
 *This Class tests the implementation of Student and LazyStudent
 *The analysis of these two classes consists in computing the 
 *time needed for ((int)1e7) 10000000 calls of the method get for each class
 *  
 */
public class MainClass {
	
	//Maximum and minimum age of a student
	static final int min_age = 19;
	static final int max_age = 27;
	
	/**
	 * Returns a list of random generated strings. The length of
	 * the list is given as paaramete. 
	 * 
	 * @param count number of random strings to be generated
	 * @return a list of random strings
	 */
	private static List<String> getRandomStrings (int count) {
		Random r = new Random();
		StringBuffer buf = new StringBuffer();
		List<String> strings = new LinkedList<String>();

		for (int s = 0; s < count; s++) {
			buf.delete(0, buf.length());
			int length = r.nextInt(10) + 1; 
			// avoid 0 length strings

			for (int i = 0; i < length; i++) {
				char c = (char)(r.nextInt(99) + 33);
				buf.append(c);
			}

			strings.add(buf.toString());
		}

		return strings;
	}
	
	//testing Student class & LazyStudent class
	public static void main (String[] args){
		
		
		//checking the Student class
		List<Student> listStud = new ArrayList<Student>();
		//checking the implementation of the class for 5000 Students
		List<String> randomStrings = getRandomStrings(5000);
		int x = (int) 1e7;
		
		for (String randomString : randomStrings){
			//random age between [min_age;max_age]
			int rand = min_age + (int)(Math.random()* (max_age - min_age) +1);
			listStud.add(new Student(randomString,rand));
		}
		
		//the list of students is put in the hashmap that has 100 buckets 
		MyHashMap<Student,Integer> map = new MyHashMapImpl(100);
		for (Student list : listStud){
			map.put(list,(int)Math.random() * 10);
		}
		
		Random randGenerator = new Random();
		
		//verifying the time used for calling 1e7 times "get" method
		// using currentTimeMillis and nanoTime
		long startTime = System.currentTimeMillis();
		long stTime = System.nanoTime();
		for (int i = 0; i < x; i++){
			int index = randGenerator.nextInt(listStud.size());
			Student st  = listStud.get(index);
		}
		long endTime = System.currentTimeMillis();
		long eTime = System.nanoTime();
		
		
		//Printing the difference using currentTimeMillis()
		System.out.println("difference in mili seconds (currentTimeMillis()): " + (endTime - startTime));
		
		//Printing the difference using nanoTime()
		//The difference is divided by 1e6 in order to transform nano seconds
		// into milliseconds 
		double differ = (eTime -stTime)/1e6;
		System.out.println("difference in mili seconds (nanoTime()): " + differ);
		
		
		//checking the LazyStudent
		List<LazyStudent> listLazyStud = new ArrayList<LazyStudent>();
		List<String> randomLazyStrings = getRandomStrings(5000);
		
		
		for (String randomString : randomLazyStrings){
			int rand = min_age + (int)(Math.random()* (max_age - min_age) +1);
			listLazyStud.add(new LazyStudent(randomString,rand));
		}
		
		//mapping the students from the listLazyStudent with teh grades
		MyHashMap<LazyStudent,Integer> mapLazy = new MyHashMapImpl(100);
		for (LazyStudent list : listLazyStud){
			mapLazy.put(list,(int)Math.random() * 10);
		}
		
		//as used before, verifying the time used for calling 1e7 times "get" method
		// using currentTimeMillis and nanoTime
		startTime = System.currentTimeMillis();
		stTime = System.nanoTime();
		for (int i = 0; i < x; i++){
			int index = randGenerator.nextInt(listLazyStud.size());
			Student stLazy  = listLazyStud.get(index);
		}
		
		//Printing the difference using currentTimeMillis()
		endTime = System.currentTimeMillis();
		eTime = System.nanoTime();
		System.out.println("difference in mili seconds (currentTimeMillis()): " + (endTime - startTime));
		
		//Printing the difference using nanoTime()
		//The difference is divided by 1e6 in order to transform nano seconds
		// into milliseconds 
		differ = (eTime -stTime)/1e6;
		System.out.println("difference in mili seconds (nanoTime()) : " + differ);
	}
}
