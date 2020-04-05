package com.sairaghava.pitfall2;

public class Point {
  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  // A better definition, but still not perfect
  /*- That's why it's always recommended to use @Override to ensure that you're actually overriding correctly and not overloading, advantage is this annotation enforces you to override it correctly */
  @Override
  public boolean equals(Object other) {
    boolean result = false;
    if (other instanceof Point) {
      Point that = (Point) other;
      result = this.getX() == that.getX() && this.getY() == that.getY();
    }
    return result;
  }
}
