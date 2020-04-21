### Pitfall 3 - Defining `equals()` and `hashCode()` but class having mutable fields

- The `hashCode()` method can be overriden by adding prime number like `41` to one of the field, thereby multiplying the result with `41` thereby adding this result with other field, yields a decent `hashCode()`
- By now, the `equals()` and `hashCode()` methods are properly overridden, but here is the problem 
- This time, the class has mutable fields, problem araises when you create an object and put it into a collection like `HashSet` and later mutate the Object's state.
  - Now, when you search for object in `HashSet` using `contains(x)` it returns false, as there is no object in the set that has same hashCode as the searched one i.e., x
- What happens when you `add()` a value to HashSet
  ```
  private static final Object PRESENT = new Object();
  public boolean add(E e) {
    return map.put(e, PRESENT)==null;// Present is a final object in HashMap class
    // So, this `put()` is HashMap's put operation, refer this hashmap-internal-storage-structure-in-java.md to know next steps
  }
  ```

***Note:This pitfall also illustrates the difference between a `contains()` method of a Collection and `equals()` of an Object***

> **Remedy/Fix: When overriding `equals()` & `hashCode()` ensure that they don't depend on mutable state**