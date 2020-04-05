package com.sairaghava.pitfall1;

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

  // An utterly wrong definition of equals
  public boolean equals(Point other) {
    return this.getX() == other.getX() && this.getY() == other.getY();
  }
}
