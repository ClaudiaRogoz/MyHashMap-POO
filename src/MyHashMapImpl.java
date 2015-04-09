import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Claudia
 *
 * @param <K> the type of keys maintained by the hashmap 
 * @param <V> value the type of mapped values
 * 
 * This class implements the interface MyHashMap.This implementation provides
 * all the operation needed for a functional hashmap  
 *
 */
class MyHashMapImpl<K,V> implements MyHashMap<K,V>{

	//vector of buckets
	BucketImpl<K,V>[] buckets;
	
	//number of entries in the hashmap
	int no_entries;
	
	/**
	 * Constructs an empty hashmap using the number of buckets
	 * 
	 *   @param num_buckets the number of buckets to be initialized in the map 
	 */
	public MyHashMapImpl(int num_buckets){
		buckets = new BucketImpl[num_buckets];
		no_entries = 0;
	}
	
	/**
	 * Returns the index of the bucket where the key is held
	 * This function returns the index using the hashCode of the key
	 * 
	 * @param key the current key whose index bucket is to be returned
	 * @return the bucket index associated with the key
	 */
	public int getBucketIndex(K key){
		return Math.abs(key.hashCode()) % buckets.length;
	}

	/**
	 * Returns the value to which thes pecific key is mapped
	 * or null if the key isn't mapped
	 * 
	 * 	@see MyHashMap#get(java.lang.Object)
	 *  @param key the key whose associated value is to be returned
	 *	@return the value associated with the key given as parameter
	 */
	@Override
	public V get(K key) {
		//the hash index for the the bucket  
		int hash = getBucketIndex(key);
		//checking whether there is no entry in the bucket given
	        if(buckets[hash] == null){
	            return null;
	        }
	        else{
	        	
	            EntryImpl<K,V> temp = buckets[hash].getEntry();
	            
	            //checking whether the key is mapped or not 
	            while(!(temp.getKey().equals(key)) && temp.next != null){
	                temp = temp.next;
	            }
	            //if the key is mapped then it returns the associated value
	            //otherwise null
	        
	            if (temp.getKey().equals(key)){
	                   	return (V) temp.getValue();}
	            else 
	            return null;
	        }
	}
	
	/**
	 * Associates the key with the value in the map.
	 * 
	 * @param key the key to be associated with the value
	 * @param value the value with which the key is associated
	 * 
	 * @return the value of the previous associated value of the key,
	 * or null if there was not any other mapping for the key
	 */
	@Override
	public V put(K key, V value) {
		int p = 0;
		//the hash index for the bucket 
		int hash = getBucketIndex(key);
		
		//checking if the bucket has no entries
        if(buckets[hash] == null){
            EntryImpl newEntryNode = new EntryImpl(key, value, null);
            buckets[hash] = new BucketImpl<K,V>();
            buckets[hash].entry = newEntryNode;
            no_entries++;
        }
        else{
        	//comparing the given key with all the entries in the current bucket
            EntryImpl temp = buckets[hash].getEntry();
            
            while(!(temp.getKey().equals(key)) && temp.next != null){
                temp = temp.next;
            //if the key is already mapped 
            //the value is updated
            }
            if (temp.getKey().equals(key)){
            	V tmp_val = (V) temp.getValue();
            	temp.setValue(value);
            	return tmp_val;
            	}
            else{
            //another entry is added in the bucket 
            EntryImpl newEntryNode = new EntryImpl(key, value, null);
            temp.next = newEntryNode;
            no_entries ++;
            }
            
        }
		return null;
	}

	/**
	 * 
	 * Removes the key given as parameter in the map 
	 * 
	 * @param key the key to be removed
	 * @return the value associated with the key 
	 */
	@Override
	public V remove(K key) {
		//the hash index associated with the key
		int hash = getBucketIndex(key);
		//checking whether the bucket has entries or not
		 	if(buckets[hash] == null){
	        	return null;
	        }
	        else{
	        	if (buckets[hash].getEntry() == null)
	        		return null;
	            
	        	//searching the key
	        	EntryImpl<K,V> temp = buckets[hash].getEntry();
	            EntryImpl<K,V> temp1 = temp;
	            while(!(temp.getKey().equals(key)) && temp.next != null){
	                temp1 = temp; 
	            	temp = temp.next;
	            }
	            
	            //if the key isn't found return null
	            if (temp.next == null && !(temp.getKey().equals(key))){  	
	            	return null;
	            	}
	            V tmpValue= (V) temp.getValue();
	            //if the key is the first entry
	            //set the new first entry
	            if ( temp1.equals(temp) ){
	            	buckets[hash].setEntry(temp.next);
	            	no_entries --;
	            	return tmpValue;
	            }
	            else{
	            	//repare the links between entries
	            	if (temp.getKey().equals(key)){
	            	temp1.next = temp.next;
	            	no_entries--;
	            	return tmpValue;
	            }
	            }
	        }
			return null;
	}

	/**
	 * Gives the size of the map
	 * 
	 * @return number of entries in the map
	 * @see MyHashMap#size()
	 */
	@Override
	public int size() {
		return no_entries;
	}

	/**
	 * Returns a List view of the buckets in the map 
	 * 
	 * @return the list of buckets in the map
	 *  
	 * @see MyHashMap#getBuckets()
	 */
	@Override
	public List<? extends MyHashMap.Bucket<K, V>> getBuckets() {
		List<BucketImpl<K,V>> l = new ArrayList<BucketImpl<K,V>>();
		
		for (int i = 0; i< buckets.length ; i++)
				l.add(buckets[i]);
		return l;
	}
	 
	
}