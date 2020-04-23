### Pitfall 4 - Failure to define equals as equivalence relation when subclasess are  - Equals not symmetric (if a = b, the b = a)

- Even though Point and ColoredPoint seems to be equal from the outside world, one of the equality check succeeds and other fails
  - `p.equals(cp); // true`
  - `cp.equals(p); // false`
- Similarly, when Point is added to set and ColoredPoint is searched in set it returns false, and when ColoredPoint is added to set and Point is searched it returns true
  - ```
    set.add(p); // Add point to set
    p.contains(cp); // search for ColoredPoint and it returns false. Why?
    //Reason: cp.hashCode() is searched in set, if found, cp.equals(eachItem in Node)
    ```
  - ```
    set.add(cp); // Add ColoredPoint to set
    cp.contains(p); // Search for Point and it returns true. Why?
    //Reason: p.hashCode() is searched in set, if found, p.equals(eachItem in the Node)
    ```
- Finally, the problem is ColoredPoint is Not Symmertric

> **Remedy/Fix: Try to make the equals() method in ColoredPoint as more General, so that cp.equals(p) should return true**