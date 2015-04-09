/**
 * 
 * @author Claudia
 *
 * @param <K> the type of keys maintained by the hashmap 
 * @param <V> value the type of mapped values
 */
class EntryImpl<K,V> implements MyHashMap.Entry<K,V>{
		
		//each entry has an association key-value
		private K key;
		private V value;
		
		//link to the next entry in the bucket
		EntryImpl<K,V> next;
		
		/**
		 * Constructs the entry in the bucket
		 * 
		 * @param key the key within the association key-value
		 * @param value the value within the association key-value
		 * @param next the next entry in the bucket
		 */
		EntryImpl( K key, V value, EntryImpl<K,V> next){
			this.value = value;
			this.key = key;
			this.setNext(next);
		}

		/**
		 * 
		 * Sets the next entry in the bucket
		 * 
		 * @param next next entry in the bucket
		 */
		private void setNext(EntryImpl<K, V> next) {
			this.next = next;
		}
		
		/**
		 * 
		 * Returns the key for the current entry
		 * 
		 * @return key
		 */
		@Override
		public K getKey() {
			return key;
		}

		/**
		 * Returns the value for the current entry
		 * 
		 * @return value
		 */
		@Override
		public V getValue() {
			return value;
		}
		
		/**
		 * Sets the value with the given one 
		 * 
		 * @param value sets the value within mapping with the given one
		 */
		public void setValue(V value){
			this.value = value;
		}
}