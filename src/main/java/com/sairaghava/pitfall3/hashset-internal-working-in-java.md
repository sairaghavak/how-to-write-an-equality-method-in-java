### How does HashSet stores its values

- Note that `HashSet` is a wrapper on top of `HashMap`
- Example a HashSet = {1}
- It's backed by a HashMap internally as shown below
  ```
  private static final Object PRESENT = new Object();
  public boolean add(E e) {
    return map.put(e, PRESENT)==null;
    // PRESENT is a stataic final field of Object type in HashMap
  }
  ```
  > Note: Format of storage is :   
  > new Node(key, value, hash(key), nextNode)
  > [0] - new Node(1, PRESENT, hash(1), null)
  
- So, this `put()` is HashMap's put operation, refer this [doc](hashmap-internal-storage-structure-in-java.md) to know next steps
- When you do `contains()` on a HashSet(), it will call `hashCode()` on the object passed and search this hashCode in HashMap backed by this set. Below is the HashSet contains() method implementation
  ```
  public boolean contains(Object o) {
    return map.containsKey(o);
  }
  ```
  ```
  public boolean containsKey(Object key) {
    return getNode(hash(key), key) != null; // The passed in Object's hashCode() is called and checked against the Node's in array
  }
  ```
> ***HINT: Think of HashSet implementation like a a collection of buckets with each having different items.  
For example, a bucket is tagged as Vegetables(hashCode=456) inside this bucket it wil have veggies and there could be another bucket called Fruits(hashCode=123)
If we do `add("tomato")`, as it's veggie it will select the bucket to get into, in this case it should get into vegetables bucket, later it will see if there is already tomato in the bucket, it will be added only if it doesn't exist***


