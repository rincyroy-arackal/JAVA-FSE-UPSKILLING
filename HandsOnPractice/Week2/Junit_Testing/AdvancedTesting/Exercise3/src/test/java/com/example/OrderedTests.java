package com.example;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("Running test 1 - Login");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(3)
    void thirdTest() {
        System.out.println("Running test 3 - Logout");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("Running test 2 - Perform Action");
        Assertions.assertTrue(true);
    }
}
