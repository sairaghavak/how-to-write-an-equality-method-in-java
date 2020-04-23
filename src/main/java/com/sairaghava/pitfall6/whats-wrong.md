### Pitfall 6 - A technically valid but, unsatisfying, equals method

- After applying the Pitfall5 remedy, that is making the equals() more stringent
- It is so strict because we have enabled runtime class check in `equals()` using `getClass()`, that is subtypes are never equal to superType, in other words, a ColoredPoint can never be equal to Point thought it has same coordinates. So, when two objects are checked for equality they should have same runtime class.
- Both the symmetry and transitivty property works good now
- > But there is new problem whenever we create an anonymous inner class of a Point and does equals comparison it fails, as `java.lang.Class` objects associated with Point and Anonymous Point are different

> **Remedy/Fix: canEqual() method as the final solution**