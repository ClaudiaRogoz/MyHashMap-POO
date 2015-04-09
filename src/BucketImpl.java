import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Claudia
 *
 * @param <K> the type of keys maintained by the hashmap 
 * @param <V> value the type of mapped values
 */

public class BucketImpl<K,V> implements MyHashMap.Bucket<K,V> {

	//entries in the current bucket
	EntryImpl<K,V> entry;
	
	/**
	 * Constructs the buckets 
	 */
	BucketImpl(){
		entry = new EntryImpl<K,V>(null,null,null); 
	}
	/**
	 * Returns a List of all the entries in the bucket
	 * 
	 * @return List of all the entries in the bucket
	 * @see MyHashMap.Bucket#getEntries()
	 */
	@Override
	public List<? extends MyHashMap.Entry<K, V>> getEntries() {
		List<EntryImpl<K,V>> l = new ArrayList<EntryImpl<K, V>>();
		EntryImpl<K,V> temp = entry;
		l.add(temp);
		while (temp.next!= null){
			temp = temp.next;
			l.add(temp);
		}
		
		return l;
	}

	/**
	 * The entry is set with the entry given as parameter
	 * 
	 * @param entry1 
	 */
	public void setEntry(EntryImpl<K,V> entry1){
		this.entry = entry1;
	}
	
	/**
	 * Returns the entry in the bucket
	 * 
	 * @return entry in the bucket 
	 */
	public EntryImpl<K,V> getEntry() {
		return entry;
	}
	
}
