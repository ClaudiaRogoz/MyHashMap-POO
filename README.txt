Rogoz Claudia 321 CA

 MyHashMapImpl implements the interface MyHashMap.This implementation provides
all the operation needed for a functional hashmap.

The map is made of an array of buckets and a number of entries for each bucket.

Analysis

MyhashMapImpl.get() is on average O(1).
The efficiency with regards to this get method relies on having a good hashCode.
A good hashCode would distribute uniformly the keys in the buckets.

If the hashCode was to be different for each key, the map would tell exactly where the association key-value is without any other computation.

If there are multiple keys that return the same hashCode, the map would have to find the bucket, iterate over all the entries in that bucket using equals().

Therefore, the better the hashCode, the better the efficiency, the faster the time.  

In MainClass, i used not only currentTimeMillis(), but nanoTime() as well for a better precision.

With regards to the tests implemented in the class, I used 5000 instances of Student ( LazyStudent). This instances were put in a hashmap with only 100 buckets.

