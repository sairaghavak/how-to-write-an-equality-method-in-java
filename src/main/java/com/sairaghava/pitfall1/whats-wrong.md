### Pitfall 1 - Defining `equals()` with wrong signature

- In Pitfall 1, the Object's `equals()` method is not overridden, rather it is overloaded
- So during compile time the Point object will have
  ```
  // Overloaded equals in Point class
  public boolean equals(Point point) {
    return this.getX() == other.getX() && this.getY() == other.getY();
  }

  // Super class Object's equals() method implementation
  public boolean equals(Object object) {
    return this == o;
  }
  ```
- So whenever you call equals on Point object the respective equals method is called based on the parameter passed.
> **Remedy/Fix: Override the Object's `equals()` method properly in `Point` class**