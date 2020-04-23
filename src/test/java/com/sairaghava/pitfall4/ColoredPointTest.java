package com.sairaghava.pitfall4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.sairaghava.commons.Color;

@TestInstance(Lifecycle.PER_CLASS)
public class ColoredPointTest {
  private Point p;
  private ColoredPoint cp;
  private HashSet<Point> set;

  @BeforeAll
  public void setup() {
    p = new Point(1, 2);
    cp = new ColoredPoint(1, 2, Color.BROWN);
    set = new HashSet<>();
  }

  /* Test cases for Object's Equivalence relation */
  @Test
  @DisplayName("return_true_on_reflexive_property")
  public void testReflexive() {
    assertTrue(p.equals(p)); // invokes p's equals() method
    assertTrue(cp.equals(cp)); // invokes cp's equals() method
  }

  @Test
  @DisplayName("throw_assertion_error_when_checked_for_symmetric_property")
  public void testSymmetry() {
    assertTrue(p.equals(cp));
    assertFalse(cp.equals(p));// invokes cp's equals() method, Point is not instance of ColoredPoint
    assertThrows(AssertionError.class, () -> assertTrue(p.equals(cp) && cp.equals(p)));
  }

  /* Test cases for Objects added to a collection */
  @Test
  @DisplayName("throw_assertion_error_when_searched_for_subclass_in_set_having_superclass")
  public void testIfSetContainsSubType() {
    set.add(p);
    assertThrows(AssertionError.class, () -> assertTrue(set.contains(cp)));
    // searches for cp's hashCode() in the set(backed by HashMap) if found, scans for cp.equals(p)
  }

  @Test
  @DisplayName("return_true_when_searched_for_superclass_in_set_having_subclass")
  public void testIfSetContainsSuperType() {
    set.add(cp);
    assertTrue(set.contains(p));
    // searches for p's hashCode() if found, scans for p.equals(cp)
  }
}
