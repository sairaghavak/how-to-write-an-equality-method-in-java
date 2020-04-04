package com.sairaghava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  public void testHello() {
    assertEquals("Hell! 00", new Main().sayHello());
  }
}
