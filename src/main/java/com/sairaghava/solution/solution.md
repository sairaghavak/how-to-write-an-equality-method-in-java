### `canEqual()` method 

- Whenever we are overriding the `equals()` and `hashCode()` methods, we should also ensure that the objects of the current class are never equal to objects of some superclass that implement a different equality method.
  - This is achieved by adding a `canEqual(Object other)` on every class that overides `equals()` and `hashCode()`

- As described by the author in the [https://www.artima.com/lejava/articles/equality.html](https://www.artima.com/lejava/articles/equality.html), it's got criticism that it violates [LSP](https://en.wikipedia.org/wiki/Liskov_substitution_principle)
  - Let me reiterate what does the critics say and what's the substance
    - > Criticism: Violation of LSP 
        - > Consider a ColoredPoint with coordiantes 1,2 and Point with same coordinates
        - `point.equals(ColoredPoint)` returns false. Here LSP test is failed, 
        - Critisim is it should return true, but doesn't make sense to return true at least in the case as a ColoredPoint is never equal to an UnColoredPoint
    - > Summary: It's a wrong interpretation that this `canEqual()` approach violates LSP, but it's not true
        - > Consider a Point and AnonymousPoint having same coordinates
        - `point.equals(pAnonymous)` returns true. Here LSP test is passed, and it makes sense as two UnColoredPoints with similar coordinates are equal
    