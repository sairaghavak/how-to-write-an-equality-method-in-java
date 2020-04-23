package com.sairaghava.pitfall5;

import com.sairaghava.commons.Color;

public class ColoredPoint extends Point {
  private final Color color;

  public ColoredPoint(int x, int y, Color color) {
    super(x, y);
    this.color = color;
  }

  @Override
  public boolean equals(Object other) {
    boolean result = false;
    if (other instanceof ColoredPoint) {
      ColoredPoint that = (ColoredPoint) other;
      result = this.color.equals(that.color) && super.equals(that);
    } else if (other instanceof Point) {
      Point that = (Point) other;
      result = that.equals(this); // delegate the call to Point's equals() method
    }
    return result;
  }

  // if you don't override hashCode in this class, it calls superClass(Point) hashCode()
}
