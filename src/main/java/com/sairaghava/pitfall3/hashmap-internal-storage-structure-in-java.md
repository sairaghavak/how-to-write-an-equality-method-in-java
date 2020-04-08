- How does HashMap stores it's key and values?
  - The internal data structure of HashMap is as explained below
    - Consider the following Node Object, in other words a Singly LinkedList implementation
      ```
      Node<K,V> {
        K Key;
        V Value;
        int hash;
        Node<K,V> next;
      }
      ```
    - Assume there is an array of Node objects with size 15
    - Whenever we `put(key, value)` into the map, hash and index is calculated as shown in below pseudo code
      ```
      // Pseudo code
      int n = 15; // size of the array
      Node[] arr = new Node[n];
      put(K, V) {
        hash = hash(K) // calls overrridden hashCode() on K if k is not null, otherwise assigns some random hashCode
        arrIndex = hash + n-1;
        
        Node next = new Node();
        // Insert this key and value into Node and Node at calculated array Index
        arr[arrIndex] = new Node(hash, key, value, next);
      }
      ```
- Note that `HashSet` is a wrapper on top of `HashMap`
- Example a HashSet = {1}
- It's backed by a HashMap internally as shown below
  ```
  private static final Object PRESENT = new Object();
  > Note: Format of storage is : new Node(hash(key), key, value, nextNode)
  [0] - new Node(hash(1), 1, PRESENT, null)
  ```