### Pitfall 2 - Changing `equals()` without changing `hashCode()`

- Add objects to hash-based collections like `HashSet` that has method
  - `contains()`
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
- In this case, though we have properly overrridden Object's equals() method, two `Point` objects with same data is still not equal as we didn't override hashcode
- And for each Point Object created, Object's `hashCode()` method is called and hence two `Point` objects have different hashcodes and so they are not equal
- ***Golden Rule for Object's equals***
  > Two objects are said to be equal when their `hashcode's` are equal but the reverse is not true  

  > Given a class, when overriding `equals()` and `hashCode()` they both should use same fields

> **Remedy/Fix: Override the Object's `hashCode()` method properly in `Point` class using the same fields that are used in overridden` equals()` method**
