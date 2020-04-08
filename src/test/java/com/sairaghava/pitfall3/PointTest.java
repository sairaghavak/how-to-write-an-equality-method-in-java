package com.sairaghava.pitfall3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PointTest {
  private Point p1, p2, q, r;
  private Object p;
  private HashSet<Point> set;

  @BeforeAll
  public void setup() {
    p1 = new Point(1, 2);
    p2 = new Point(1, 2);
    q = new Point(2, 3);
    r = new Point(1, 3);
    p = p1;
  }

  @BeforeEach
  public void beforeEach() {
    set = new HashSet<>();
  }

  /* Test cases for Object's Equivalence relation */
  @Test
  @DisplayName("return_true_on_reflexive_property")
  public void testReflexive() {
    assertTrue(p1.equals(p1));
  }

  @Test
  @DisplayName("return_true_on_symmetric_property")
  public void testSymmetry() {
    assertTrue(p1.equals(p2) && p2.equals(p1));
  }

  @Test
  @DisplayName("return_true_on_transitive_property")
  public void testTransitive() {
    assertTrue(p1.equals(p2) && p2.equals(p) && p1.equals(p));
  }

  @Test
  @DisplayName("return_true_on_consistency")
  public void testConsistency() {
    assertTrue(p1.equals(p2) && p1.equals(p2));
  }

  @Test
  @DisplayName("return_false_on_equals_with_null")
  public void testNullEquality() {
    assertFalse(p1.equals(null));
  }

  @Test
  @DisplayName("return_true_on_equals_with_same_type_and_same_data_and_same_reference_type")
  public void testEqualityOnTwoSimilarObjects() {
    assertTrue(p1.equals(p2));
  }

  @Test
  @DisplayName("return_true_on_equals_with_same_type_and_same_data_but_distinct_reference_type")
  public void testEqualityOnTwoSimilarObjectsWithDistinctReferenceTypes() {
    assertTrue(p1.equals(p)); // calls Overriden Object's equals() method
    assertTrue(p2.equals(p)); // calls Overriden Object's equals() method
  }

  @Test
  @DisplayName("return_false_on_equals_with_same_type_and_distinct_data_and_same_reference_type")
  public void testEqualityOnTwoDistinctObjectsWithDistinctTypes() {
    assertFalse(p1.equals(q));
    assertFalse(p1.equals(r));
  }

  /* Test cases for Objects added to a collection */
  @Test
  @DisplayName("return_false_when_adding_duplicates_to_set")
  public void testIfSetAddsDuplicate() {
    set.add(p1);
    assertFalse(set.add(p2));
  }

  @Test
  @DisplayName("return_true_when_searched_for_duplicate")
  public void testIfSetContainsDuplicate() {
    set.add(p1);
    assertTrue(set.contains(p2));
  }
}
