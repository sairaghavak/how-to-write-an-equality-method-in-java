### Pitfall 5 - Failure to define equals as equivalence relation when subclasess are  - Equals not transitive (if a = b and b = c, then a = c)

- After applying the Pitfall4 remedy, now pitfall5 doesn't satisfy transitivity property
- Now the Symmetry check is valid that is <u>if a=b, then b=a</u>
  - `cp.equals(p); // returns true`
  - `p.equals(cp); // returns true`
- But, this new relation betwen Point and ColoredPoint is not longer transitive that is <u>if a=b and b=c, then a=c</u>
  - `blackP.equals(p); // returns true that is a=b`
  - `p.equals(whiteP); // returns true that is b=c`
  - `blackP.equals(whiteP); // returns false that is a!=c`
- Making the `equals()` method more general seems to have more problems like fails to obey transitivity rule

> **Remedy/Fix: Try to make the equals() method in ColoredPoint <u>as more stricter</u>, so that cp.equals(p) should return true**