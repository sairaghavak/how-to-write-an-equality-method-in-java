### How does HashMap stores its key and values?
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
      //initializations
      int n = 15; // size of the array
      Node[] arr = new Node[n];

      OldValue/NULL put(K, V) {
        
        // Prepare all the params required for Node
        
        hash = hash(K) 
        // Step 1 : calls overrridden hashCode() on K if k is not null, otherwise assigns some random hashCode

        arrIndex = hash & n-1;
        // Step 2: & here is bitwise AND operator. 
        
          // Example: 12 & 5 = 4, as 12 in 
          binary = 1100 & 5 in binary = 0101
          1100 &
          0101 =
          -----
          0100 ~ 4
          -----
        Node next = new Node();
        // Step 3: Create a next node

        // Initialize the Node with all the above data
        arr[arrIndex] = new Node(key, value, hash, next);
      }
      ```

### Example Illustration/Debugging a Map.put operation
- Imagine an array of Node objects of size = 3
  > `Node[] nodes = new Nodes[3]` // 5 is assumed for brevity
- Consider the below node visualization 
  > |key - Object|value - Object | hash(key)/key.hashCode() | next - Node |
   >|---|---|---|---|
   >||||||
- Consider the `Node[]` array if size = 3
  |Index|Node|
  |---|---|
  |0| null|
  |1| null|
  |2| null|
- `put("srk", 1)`
  - **Steps**  
      1. Assumptions: nodes.length = 3
      2. Calculate hash - `hash(srk)` or `srk.hashCode()` - assume = 1234
      3. Determine arrayIndex - Step2 & n-1 - assume = 1
      4. Next node = null
      5. Node data
          > |key - Object|value - Object | hash(key)/key.hashCode() | next - Node |
          >|---|---|---|---|
          >|"srk"|1|1234|null|
      6. Checks if the `nodes[1]` is empty
      7. If empty: insert Step5
          |Index|Node|
          |---|---|
          |0| null|
          |1|"`|"srk"|1|1234|null)|`"|
          |2| null|
- `put("sairaghava", 109)`
  - **Steps**  
      1. Assumptions: nodes.length = 3
      2. Calculate hash - `hash(sairaghava)` or `sairaghava.hashCode()` - assume = 6549
      3. Determine arrayIndex - Step2 & n-1 - assume = 2
      4. Next node = null
      5. Node data
          > |key - Object|value - Object | hash(key)/key.hashCode() | next - Node |
          >|---|---|---|---|
          >|"sairaghava"|109|6549|null|
      6. Checks if the `nodes[2]` is empty
      7. If empty: insert Step5
          |Index|Node|
          |---|---|
          |0| null|
          |1| `|"srk"|1|1234|null|`|
          |2| `|"sairaghava"|109|6549|null|`|
- `put('srk', 1)` - Collision Example - Keys matching
    - **Steps**  
      1. Assumptions: nodes.length = 3
      2. Calculate hash - `hash(srk)` or `srk.hashCode()` - assume = 1234
      3. Determine arrayIndex - Step2 & n-1 - assume = 1
      4. Next node = null
      5. Node data
          > |key - Object|value - Object | hash(key)/key.hashCode() | next - Node |
          >|---|---|---|---|
          >|"srk"|1|1234|null|
      6. Checks if the `nodes[1]` is empty
      7. If empty: insert Step5
      8. else: Compare existing node value with this node/Step5
          - Comparison steps
            - If keys match in this case `srk.equals(srk)`, then replace old value with new value i.e., `1` with `1` and return old value 
            - |Index|Node|
              |---|---|
              |0| null|
              |1| `|"srk"|1|1234|null|`|
              |2| `|"sairaghava"|109|6549|null|`|

- `put('srk-hero', 3)` - Collision Example - Keys don't match
  - **Steps**  
      1. Assumptions: nodes.length = 3
      2. Calculate hash - `hash(srk)` or `srk.hashCode()` - assume = 9989
      3. Determine arrayIndex - Step2 & n-1 - assume = 1
      4. Next node = null
      5. Node data
          > |key - Object|value - Object | hash(key)/key.hashCode() | next - Node |
          >|---|---|---|---|
          >|"srk-hero"|3|9989|null|
      6. Checks if the `nodes[1]` is empty
      7. If empty: insert Step5
      8. else: Compare existing node value with this node/Step5
          - Comparison steps
            - If keys match in this case `srk-hero.equals(srk)` is false
            - else : add this node to next of the previous node
              - |Index|Node|
                |---|---|
                |0| null|
                |1| `|"srk"|1|1234|next =|"srk-hero"|3|9989|null)||`
                |2| `|"sairaghava"|109|6549|null|`|