package com.sairaghava.pitfall6;

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
    }
    return result;
  }

  // if you don't override hashCode in this class, it calls superClass(Point) hashCode()
}
