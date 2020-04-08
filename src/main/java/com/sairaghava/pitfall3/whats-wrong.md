### Pitfall 3 - Defining `equals()` and `hashCode()` but class having mutable fields

- The `hashCode()` method can be overriden by adding prime number like `41` to one of the field, thereby multiplying the result with `41` thereby adding this result with other field, yields a decent `hashCode()`
- By now, the `equals()` and `hashCode()` methods are properly overridden, but here is the problem 
- This time, the class has mutable fields, problem araises when you create an object and put it into a collection like `HashSet` and later mutate the Object's state.
  - Now, when you search for object in `HashSet` using `contains()` it returns false, as there is no object in the set that has same hashCode as the searched one
- What happens when you `add()` a value to HashSet
  ```
  private static final Object PRESENT = new Object();
  public boolean add(E e) {
    return map.put(e, PRESENT)==null;// Present is a final object in HashMap class
  }
  ```
- When you do `contains()` on a HashSet(), it will call hashCode() on the object passed and search this hashCode in Set. Below is the HashSet contains() method implementation
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

> **Remedy/Fix: When overriding `equals()` & `hashCode()` ensure that they don't depend on mutable state, as it may cause problems like this(pitfall3)**