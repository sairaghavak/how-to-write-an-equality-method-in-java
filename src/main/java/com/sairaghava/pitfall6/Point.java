package com.sairaghava.pitfall6;

public class Point {
  private int x;
  private int y;

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

  @Override
  public boolean equals(Object other) {
    boolean result = false;
    if (other instanceof Point) {
      Point that = (Point) other;
      result = this.getClass().equals(that.getClass()) && this.getX() == that.getX()
          && this.getY() == that.getY();
    }
    return result;
  }

  @Override
  public int hashCode() {
    return (41 * (41 + getX()) + getY());
  }
}
