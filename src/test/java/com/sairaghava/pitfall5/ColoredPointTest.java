package com.sairaghava.pitfall5;

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
  private ColoredPoint blackPoint, whitePoint, anotherBlackPoint;
  private HashSet<Point> set;

  @BeforeAll
  public void setup() {
    p = new Point(1, 2);
    blackPoint = new ColoredPoint(1, 2, Color.BLACK);
    anotherBlackPoint = new ColoredPoint(1, 3, Color.BLACK);
    whitePoint = new ColoredPoint(1, 2, Color.WHITE);
    set = new HashSet<>();
  }

  @Test
  @DisplayName("return_false_on_equals_with_same_type_and_distinct_data_and_same_reference_type")
  public void testEqualityOnTwoDistinctObjectsWithDistinctTypes() {
    assertFalse(blackPoint.equals(whitePoint));
    assertFalse(blackPoint.equals(anotherBlackPoint));
  }

  /* Test cases for Object's Equivalence relation */
  @Test
  @DisplayName("return_true_on_reflexive_property")
  public void testReflexive() {
    assertTrue(p.equals(p)); // invokes p's equals() method
    assertTrue(blackPoint.equals(blackPoint)); // invokes cp's equals() method
  }

  @Test
  @DisplayName("return_true_when_checked_for_symmetric_property")
  public void testSymmetry() {
    assertTrue(p.equals(blackPoint));
    assertTrue(blackPoint.equals(p));
    // invokes cp's equals() method, Point is not instance of ColoredPoint
    assertTrue(p.equals(blackPoint) && blackPoint.equals(p));
  }

  @Test
  @DisplayName("throw_assertion_error_when_checked_for_transitive_property")
  public void testTransitivity() {
    assertTrue(blackPoint.equals(p));
    assertTrue(p.equals(whitePoint));
    assertThrows(AssertionError.class, () -> assertTrue(
        blackPoint.equals(p) && p.equals(whitePoint) && blackPoint.equals(whitePoint)));
  }

  @Test
  @DisplayName("return_false_on_equals_with_null")
  public void testNullEquality() {
    assertFalse(blackPoint.equals(null));
  }

  /* Test cases for Objects added to a collection */
  @Test
  @DisplayName("return_true_when_searched_for_subclass_in_set_having_superclass")
  public void testIfSetContainsSubType() {
    set.add(p);
    assertTrue(set.contains(blackPoint));
    // searches for cp's hashCode() in the set(backed by HashMap) if found, scans for cp.equals(p)
  }

  @Test
  @DisplayName("return_true_when_searched_for_superclass_in_set_having_subclass")
  public void testIfSetContainsSuperType() {
    set.add(blackPoint);
    assertTrue(set.contains(p));
    // searches for p's hashCode() if found, scans for p.equals(cp)
  }
}
